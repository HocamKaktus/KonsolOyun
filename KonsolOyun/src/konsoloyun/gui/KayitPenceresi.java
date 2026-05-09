package konsoloyun.gui;

import javax.swing.*;
import java.awt.*;
import konsoloyun.veri.Sistem;

public class KayitPenceresi extends JFrame {
    
    private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public KayitPenceresi() {
        setTitle("KonsolOyun - Yeni Hesap Oluştur");
        setSize(350, 380);
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

        JLabel lblBaslik = new JLabel("BİZE KATILIN");
        lblBaslik.setFont(new Font("Verdana", Font.BOLD, 18));
        lblBaslik.setForeground(Color.WHITE);
        lblBaslik.setBounds(40, 20, 250, 30);
        panel.add(lblBaslik);

        JLabel lblKullanici = new JLabel("Kullanıcı Adı:");
        lblKullanici.setForeground(yaziRengi);
        lblKullanici.setBounds(40, 65, 100, 20);
        panel.add(lblKullanici);

        JTextField txtKullanici = new JTextField();
        txtKullanici.setBackground(new Color(23, 26, 33));
        txtKullanici.setForeground(Color.WHITE);
        txtKullanici.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        txtKullanici.setBounds(40, 85, 250, 30);
        panel.add(txtKullanici);

        JLabel lblEposta = new JLabel("E-posta:");
        lblEposta.setForeground(yaziRengi);
        lblEposta.setBounds(40, 125, 100, 20);
        panel.add(lblEposta);

        JTextField txtEposta = new JTextField();
        txtEposta.setBackground(new Color(23, 26, 33));
        txtEposta.setForeground(Color.WHITE);
        txtEposta.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        txtEposta.setBounds(40, 145, 250, 30);
        panel.add(txtEposta);

        JLabel lblSifre = new JLabel("Şifre:");
        lblSifre.setForeground(yaziRengi);
        lblSifre.setBounds(40, 185, 100, 20);
        panel.add(lblSifre);

        JPasswordField txtSifre = new JPasswordField();
        txtSifre.setBackground(new Color(23, 26, 33));
        txtSifre.setForeground(Color.WHITE);
        txtSifre.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        txtSifre.setBounds(40, 205, 250, 30);
        panel.add(txtSifre);

        JButton btnKayitOl = new JButton("Hesabı Oluştur");
        btnKayitOl.setBackground(butonMavi);
        btnKayitOl.setForeground(Color.WHITE);
        btnKayitOl.setOpaque(true);
        btnKayitOl.setBorderPainted(false);
        btnKayitOl.setBounds(40, 255, 250, 35);
        panel.add(btnKayitOl);

        JButton btnGeri = new JButton("Girişe Dön");
        btnGeri.setBounds(110, 300, 120, 20);
        btnGeri.setContentAreaFilled(false);
        btnGeri.setBorderPainted(false);
        btnGeri.setForeground(Color.GRAY);
        btnGeri.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(btnGeri);

        btnKayitOl.addActionListener(e -> {
            String kAdi = txtKullanici.getText().trim();
            String sifre = new String(txtSifre.getPassword()).trim();
            String eposta = txtEposta.getText().trim();

            if (kAdi.isEmpty() || sifre.isEmpty() || eposta.isEmpty()) {
                JOptionPane.showMessageDialog(this, "HATA: Tüm alanları doldurmalısınız! Sadece boşluk bırakamazsınız.", "Eksik Bilgi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Sistem.oyuncuEkle(kAdi, sifre, eposta);
            JOptionPane.showMessageDialog(null, "Kayıt Başarılı! Hoş geldin " + kAdi);
            new GirisPaneli().setVisible(true);
            dispose();
        });

        btnGeri.addActionListener(e -> {
            new GirisPaneli().setVisible(true);
            dispose();
        });
    }
}