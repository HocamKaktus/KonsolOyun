package konsoloyun.gui;

import javax.swing.*;
import java.awt.*;
import konsoloyun.model.*;
import konsoloyun.servis.*;
import konsoloyun.veri.Sistem;
import konsoloyun.veri.YetersizBakiyeException;

@SuppressWarnings("unused")
public class OyuncuPenceresi extends JFrame {
    

	private static final long serialVersionUID = 1L;
	private Oyuncu aktifOyuncu;
    private DefaultListModel<String> magazaModel;
    private DefaultListModel<String> kutuphaneModel;
    private JLabel lblBakiye;

    public OyuncuPenceresi(Oyuncu oyuncu) {
        this.aktifOyuncu = oyuncu;

        Color bgSiyah = new Color(23, 26, 33);
        Color bgPanel = new Color(34, 40, 49);
        Color maviAcik = new Color(102, 192, 244); 
        Color yesilButon = new Color(92, 126, 16);

        setTitle("KonsolOyun - " + oyuncu.getKullaniciAdi().toUpperCase());
        setSize(850, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel anaPanel = new JPanel(new BorderLayout());
        anaPanel.setBackground(bgSiyah);
        setContentPane(anaPanel);

        JPanel ustPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 15));
        ustPanel.setBackground(bgSiyah);
        
        lblBakiye = new JLabel("Cüzdan: " + aktifOyuncu.getBakiye() + " TL");
        lblBakiye.setForeground(maviAcik);
        lblBakiye.setFont(new Font("Verdana", Font.BOLD, 15));
        
        JButton btnBakiyeEkle = new JButton("Cüzdana Para Ekle");
        btnBakiyeEkle.setBackground(yesilButon);
        btnBakiyeEkle.setForeground(Color.WHITE);

        JButton btnCikis = new JButton("Çıkış");
        btnCikis.setBackground(Color.DARK_GRAY);
        btnCikis.setForeground(Color.WHITE);

        ustPanel.add(lblBakiye);
        ustPanel.add(btnBakiyeEkle);
        ustPanel.add(btnCikis);
        anaPanel.add(ustPanel, BorderLayout.NORTH);

        JTabbedPane sekmeler = new JTabbedPane();
        sekmeler.setBackground(bgPanel);
        sekmeler.setForeground(Color.WHITE);
        
        
        JPanel magazaPanel = new JPanel(new BorderLayout(15, 15));
        magazaPanel.setBackground(bgPanel);
        magazaModel = new DefaultListModel<>();
        JList<String> listMagaza = new JList<>(magazaModel);
        listMagaza.setBackground(bgSiyah);
        listMagaza.setForeground(maviAcik);
        magazaPanel.add(new JScrollPane(listMagaza), BorderLayout.CENTER);
        
        JButton btnSatinAl = new JButton("SATIN AL");
        btnSatinAl.setBackground(new Color(42, 71, 94));
        btnSatinAl.setForeground(Color.WHITE);
        magazaPanel.add(btnSatinAl, BorderLayout.SOUTH);
        sekmeler.addTab("   MAĞAZA   ", magazaPanel);

       
        JPanel kutuphanePanel = new JPanel(new BorderLayout(15, 15));
        kutuphanePanel.setBackground(bgPanel);
        kutuphaneModel = new DefaultListModel<>();
        JList<String> listKutuphane = new JList<>(kutuphaneModel);
        listKutuphane.setBackground(bgSiyah);
        listKutuphane.setForeground(Color.WHITE);
        kutuphanePanel.add(new JScrollPane(listKutuphane), BorderLayout.CENTER);
        
        JButton btnOyna = new JButton("OYNA ▶");
        btnOyna.setBackground(yesilButon);
        btnOyna.setForeground(Color.WHITE);
        kutuphanePanel.add(btnOyna, BorderLayout.SOUTH);
        sekmeler.addTab("  KÜTÜPHANE  ", kutuphanePanel);

        anaPanel.add(sekmeler, BorderLayout.CENTER);

        listeleriGuncelle();

        btnCikis.addActionListener(e -> {
            new GirisPaneli().setVisible(true);
            dispose();
        });

        btnBakiyeEkle.addActionListener(e -> {
            String miktar = JOptionPane.showInputDialog("Yüklenecek tutar:");
            if (miktar != null && !miktar.trim().isEmpty()) {
                try {
                    aktifOyuncu.bakiyeEkle(Double.parseDouble(miktar));
                    Sistem.verileriKaydet();
                    listeleriGuncelle();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Lütfen geçerli bir sayı giriniz!", "Hatalı Giriş", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnSatinAl.addActionListener(e -> {
            int idx = listMagaza.getSelectedIndex();
           
            if (idx != -1) {
                Oyun oyun = Sistem.aktifMagaza.getMagazaOyunlari().get(idx);
                try {
                    new CuzdanIleOdeme(aktifOyuncu).odemeGerceklestir(oyun.getFiyat());
                    aktifOyuncu.getKutuphane().oyunEkle(oyun);
                    Sistem.verileriKaydet();
                    listeleriGuncelle();
                    JOptionPane.showMessageDialog(this, "Satın alma işlemi başarılı!", "Başarılı", JOptionPane.INFORMATION_MESSAGE);
                } catch (YetersizBakiyeException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Hata", JOptionPane.ERROR_MESSAGE);
                }
            } 
            
            else {
                JOptionPane.showMessageDialog(this, "Lütfen satın almak için listeden bir oyun seçiniz!", "Seçim Yapılmadı", JOptionPane.WARNING_MESSAGE);
            }
        });

        btnOyna.addActionListener(e -> {
            int idx = listKutuphane.getSelectedIndex();
            
            if (idx != -1) {
                Oyun o = aktifOyuncu.getKutuphane().getOyunListesi().get(idx);
                JOptionPane.showMessageDialog(this, o.getAd() + " başlatılıyor...\n(Konsol loglarını kontrol edin)", "Oyun Başlıyor", JOptionPane.INFORMATION_MESSAGE);
                
                
                System.out.println(">>> " + o.getAd().toUpperCase() + " BAŞLATILIYOR <<<");
                if (o instanceof TekOyunculu) ((TekOyunculu) o).tekOyunculuModuBaslat();
                if (o instanceof CokOyunculu) ((CokOyunculu) o).sunucuyaBaglan();
                if (o instanceof AcikDunya)   ((AcikDunya) o).haritayiKesfet();
                if (o instanceof Aksiyon)     ((Aksiyon) o).aksiyonHareketiYap();
                if (o instanceof Spor)        ((Spor) o).macaBasla();
            } 
            
            else {
                JOptionPane.showMessageDialog(this, "Lütfen oynamak için kütüphanenizden bir oyun seçiniz!", "Seçim Yapılmadı", JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    public void listeleriGuncelle() {
        magazaModel.clear();
        for (Oyun o : Sistem.aktifMagaza.getMagazaOyunlari()) {
            magazaModel.addElement(" " + o.getAd() + "  -  " + o.getFiyat() + " TL");
        }
        kutuphaneModel.clear();
        if (aktifOyuncu.getKutuphane().getOyunListesi() != null) {
            for (Oyun o : aktifOyuncu.getKutuphane().getOyunListesi()) {
                kutuphaneModel.addElement(" > " + o.getAd());
            }
        }
        lblBakiye.setText("Cüzdan: " + aktifOyuncu.getBakiye() + " TL");
    }
}