package konsoloyun.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import konsoloyun.model.Oyuncu;
import konsoloyun.veri.Sistem;

@SuppressWarnings("unused")
public class GirisPaneli extends JFrame {
   
	private static final long serialVersionUID = 1L;

	public GirisPaneli() {
        setTitle("KonsolOyun Login"); 
        setSize(350, 320);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        Color arkaPlan = new Color(34, 40, 49); 
        Color yaziRengi = new Color(199, 213, 224); 
        Color butonMavi = new Color(42, 71, 94); 
        
        JPanel panel = new JPanel();
        panel.setBackground(arkaPlan);
        panel.setLayout(null);
        setContentPane(panel);

        JLabel lblBaslik = new JLabel("HESABINIZA GİRİŞ YAPIN");
        lblBaslik.setFont(new Font("Verdana", Font.BOLD, 16));
        lblBaslik.setForeground(Color.WHITE);
        lblBaslik.setBounds(40, 20, 250, 30);
        panel.add(lblBaslik);

        JLabel lblKullanici = new JLabel("Kullanıcı Adı");
        lblKullanici.setForeground(yaziRengi);
        lblKullanici.setBounds(40, 70, 100, 20);
        panel.add(lblKullanici);

        JTextField txtKullanici = new JTextField();
        txtKullanici.setBackground(new Color(23, 26, 33));
        txtKullanici.setForeground(Color.WHITE);
        txtKullanici.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        txtKullanici.setBounds(40, 95, 250, 30);
        panel.add(txtKullanici);

        JLabel lblSifre = new JLabel("Şifre");
        lblSifre.setForeground(yaziRengi);
        lblSifre.setBounds(40, 135, 100, 20);
        panel.add(lblSifre);

        JPasswordField txtSifre = new JPasswordField();
        txtSifre.setBackground(new Color(23, 26, 33));
        txtSifre.setForeground(Color.WHITE);
        txtSifre.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        txtSifre.setBounds(40, 160, 250, 30);
        panel.add(txtSifre);

        JButton btnGiris = new JButton("Giriş Yap");
        btnGiris.setBackground(butonMavi);
        btnGiris.setForeground(Color.WHITE);
        btnGiris.setBounds(40, 210, 115, 35);
        panel.add(btnGiris);

        JButton btnKayit = new JButton("Yeni Hesap");
        btnKayit.setBackground(new Color(60, 60, 60));
        btnKayit.setForeground(Color.WHITE);
        btnKayit.setBounds(175, 210, 115, 35);
        panel.add(btnKayit);

        JButton btnYonetici = new JButton("Yetkili Girişi");
        btnYonetici.setBounds(110, 255, 120, 20);
        btnYonetici.setContentAreaFilled(false);
        btnYonetici.setBorderPainted(false);
        btnYonetici.setForeground(Color.GRAY);
        btnYonetici.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(btnYonetici);

        btnGiris.addActionListener(e -> {
            String kAdi = txtKullanici.getText();
            String sifre = new String(txtSifre.getPassword());
            Oyuncu girenOyuncu = Sistem.oyuncuGiris(kAdi, sifre);
            if (girenOyuncu != null) {
                new OyuncuPenceresi(girenOyuncu).setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Hatalı bilgi!", "Hata", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnKayit.addActionListener(e -> {
            new KayitPenceresi().setVisible(true);
            dispose();
        });

        btnYonetici.addActionListener(e -> {
            new YoneticiGirisPenceresi().setVisible(true);
            dispose();
        });
    }
}