package konsoloyun.gui;

import javax.swing.*;
import konsoloyun.model.*;
import konsoloyun.veri.OyunZatenVarException;
import konsoloyun.veri.Sistem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class YoneticiPenceresi extends JFrame {
	private static final long serialVersionUID = 1L;

	public YoneticiPenceresi(Yonetici yonetici) {
        setTitle("Yönetici Paneli - " + yonetici.getKullaniciAdi());
        setSize(400, 350);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblAd = new JLabel("Oyun Adı:");
        lblAd.setBounds(30, 30, 100, 25);
        add(lblAd);

        JTextField txtAd = new JTextField();
        txtAd.setBounds(140, 30, 200, 25);
        add(txtAd);

        JLabel lblFiyat = new JLabel("Fiyat (TL):");
        lblFiyat.setBounds(30, 70, 100, 25);
        add(lblFiyat);

        JTextField txtFiyat = new JTextField();
        txtFiyat.setBounds(140, 70, 200, 25);
        add(txtFiyat);

        JLabel lblTur = new JLabel("Oyun Türü:");
        lblTur.setBounds(30, 110, 100, 25);
        add(lblTur);

        String[] turler = {"Hikaye Oyunu", "Global Savaş", "Online Spor", "Yerli Aksiyon"};
        JComboBox<String> cmbTur = new JComboBox<>(turler);
        cmbTur.setBounds(140, 110, 200, 25);
        add(cmbTur);

        JButton btnEkle = new JButton("Mağazaya Ekle");
        btnEkle.setBounds(140, 160, 200, 30);
        add(btnEkle);

        JButton btnVergiIndirimi = new JButton("Yerli Oyunlara Vergi İndirimi Uygula");
        btnVergiIndirimi.setBounds(30, 210, 310, 30);
        add(btnVergiIndirimi);

        JButton btnCikis = new JButton("Çıkış Yap");
        btnCikis.setBounds(30, 260, 310, 30);
        add(btnCikis);

        
        btnEkle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ad = txtAd.getText().trim();
                String fiyatStr = txtFiyat.getText().trim();
                
                if (ad.isEmpty() || fiyatStr.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "HATA: Oyun adı veya fiyatı boş bırakılamaz!", "Eksik Veri", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try {
                    double fiyat = Double.parseDouble(fiyatStr);
                    String secilenTur = (String) cmbTur.getSelectedItem();
                    
                    int yeniId = Sistem.aktifMagaza.getMagazaOyunlari().size() + 1; 
                    
                    Oyun yeniOyun = null;

                    switch (secilenTur) {
                        case "Hikaye Oyunu": yeniOyun = new HikayeOyunu(yeniId, ad, fiyat); break;
                        case "Global Savaş": yeniOyun = new GlobalSavasOyunu(yeniId, ad, fiyat); break;
                        case "Online Spor": yeniOyun = new OnlineSporOyunu(yeniId, ad, fiyat); break;
                        case "Yerli Aksiyon": yeniOyun = new YerliAksiyonOyunu(yeniId, ad, fiyat); break;
                    }

                    Sistem.aktifMagaza.magazaOyunEkle(yeniOyun);
                    
                    Sistem.magazaKaydet();
                    
                    JOptionPane.showMessageDialog(null, ad + " mağazaya başarıyla eklendi!", "İşlem Başarılı", JOptionPane.INFORMATION_MESSAGE);
                    
                    txtAd.setText("");
                    txtFiyat.setText("");

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "HATA: Fiyat kısmına sadece sayı girmelisiniz!", "Hatalı Giriş", JOptionPane.ERROR_MESSAGE);
                } catch (OyunZatenVarException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Ekleme Hatası", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        
        btnVergiIndirimi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int sayac = 0;
                StringBuilder rapor = new StringBuilder(); 

                for (Oyun o : Sistem.aktifMagaza.getMagazaOyunlari()) {
                    if (o instanceof Yerli) {
                        double eskiFiyat = o.getFiyat();
                        ((Yerli) o).vergiIndirimiUygula(); 
                        sayac++;
                        
                        rapor.append("- ").append(o.getAd())
                             .append(" (").append(eskiFiyat).append(" TL -> ")
                             .append(o.getFiyat()).append(" TL)\n");
                    }
                }

                if (sayac > 0) {
                    
                    Sistem.magazaKaydet();
                    
                    JOptionPane.showMessageDialog(null, 
                            sayac + " adet yerli oyuna vergi indirimi uygulandı!\n\nİndirim Detayları:\n" + rapor.toString(), 
                            "İşlem Başarılı", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, 
                            "Mağazada şu an vergi indirimi uygulanabilecek 'Yerli' kategorisinde bir oyun bulunmuyor.\nLütfen önce mağazaya yerli bir oyun ekleyin.", 
                            "Yerli Oyun Bulunamadı", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        btnCikis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GirisPaneli().setVisible(true);
                dispose();
            }
        });
    }
}