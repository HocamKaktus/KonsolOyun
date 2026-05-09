package konsoloyun.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import konsoloyun.veri.Sistem;
import konsoloyun.model.Yonetici;

public class YoneticiGirisPenceresi extends JFrame {
    
    private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public YoneticiGirisPenceresi() {
        setTitle("KonsolOyun - Yetkili Girişi");
        setSize(350, 300);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        getContentPane().setBackground(new Color(45, 45, 45)); 
        Color yaziRengi = Color.WHITE;

        JLabel lblBaslik = new JLabel("YÖNETİCİ GİRİŞ PORTALI");
        lblBaslik.setBounds(70, 15, 250, 25);
        lblBaslik.setForeground(new Color(220, 53, 69)); 
        lblBaslik.setFont(new Font("Verdana", Font.BOLD, 14));
        add(lblBaslik);

        JLabel lblKullanici = new JLabel("Kullanıcı Adı:");
        lblKullanici.setBounds(40, 60, 100, 25);
        lblKullanici.setForeground(yaziRengi);
        add(lblKullanici);

        JTextField txtKullanici = new JTextField();
        txtKullanici.setBounds(150, 60, 140, 25);
        txtKullanici.setBackground(new Color(30, 30, 30));
        txtKullanici.setForeground(Color.WHITE);
        add(txtKullanici);

        JLabel lblSifre = new JLabel("Şifre:");
        lblSifre.setBounds(40, 100, 100, 25);
        lblSifre.setForeground(yaziRengi);
        add(lblSifre);

        JPasswordField txtSifre = new JPasswordField();
        txtSifre.setBounds(150, 100, 140, 25);
        txtSifre.setBackground(new Color(30, 30, 30));
        txtSifre.setForeground(Color.WHITE);
        add(txtSifre);

        JLabel lblPin = new JLabel("Admin PIN:");
        lblPin.setBounds(40, 140, 100, 25);
        lblPin.setForeground(yaziRengi);
        add(lblPin);

        JPasswordField txtPin = new JPasswordField();
        txtPin.setBounds(150, 140, 140, 25);
        txtPin.setBackground(new Color(30, 30, 30));
        txtPin.setForeground(Color.WHITE);
        add(txtPin);

        JButton btnGiris = new JButton("Sisteme Gir");
        btnGiris.setBounds(40, 190, 120, 30);
        btnGiris.setBackground(new Color(220, 53, 69));
        btnGiris.setForeground(Color.WHITE);
        btnGiris.setOpaque(true);
        btnGiris.setBorderPainted(false);
        add(btnGiris);

        JButton btnGeri = new JButton("Geri Dön");
        btnGeri.setBounds(170, 190, 120, 30);
        btnGeri.setBackground(Color.DARK_GRAY);
        btnGeri.setForeground(Color.WHITE);
        btnGeri.setOpaque(true);
        btnGeri.setBorderPainted(false);
        add(btnGeri);

        btnGiris.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String kAdi = txtKullanici.getText().trim();
                String sifre = new String(txtSifre.getPassword()).trim();
                String pinStr = new String(txtPin.getPassword()).trim();

                if (kAdi.isEmpty() || sifre.isEmpty() || pinStr.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "HATA: Tüm alanları doldurmak zorunludur!", "Eksik Bilgi", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try {
                    int pin = Integer.parseInt(pinStr);
                    Yonetici girenYonetici = Sistem.yoneticiGiris(kAdi, sifre, pin);

                    if (girenYonetici != null) {
                        new YoneticiPenceresi(girenYonetici).setVisible(true);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Erişim Reddedildi: Bilgiler hatalı!", "Yetkisiz Erişim", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "PIN kodu sadece rakamlardan oluşmalıdır!", "Format Hatası", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnGeri.addActionListener(e -> {
            new GirisPaneli().setVisible(true);
            dispose();
        });
    }
}