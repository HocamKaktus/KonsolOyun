package konsoloyun.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import konsoloyun.veri.Sistem;
import konsoloyun.model.Yonetici;

public class YoneticiGirisPenceresi extends JFrame {
    

	private static final long serialVersionUID = 1L;

	public YoneticiGirisPenceresi() {
        setTitle("Yetkili Personel Girişi");
        setSize(350, 300);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
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
        add(txtKullanici);

        JLabel lblSifre = new JLabel("Şifre:");
        lblSifre.setBounds(40, 100, 100, 25);
        lblSifre.setForeground(yaziRengi);
        add(lblSifre);

        JPasswordField txtSifre = new JPasswordField();
        txtSifre.setBounds(150, 100, 140, 25);
        add(txtSifre);

        JLabel lblPin = new JLabel("Admin PIN:");
        lblPin.setBounds(40, 140, 100, 25);
        lblPin.setForeground(yaziRengi);
        add(lblPin);

        JPasswordField txtPin = new JPasswordField();
        txtPin.setBounds(150, 140, 140, 25);
        add(txtPin);

        JButton btnGiris = new JButton("Sisteme Gir");
        btnGiris.setBounds(40, 190, 120, 30);
        btnGiris.setBackground(new Color(220, 53, 69));
        btnGiris.setForeground(Color.WHITE);
        add(btnGiris);

        JButton btnGeri = new JButton("Geri Dön");
        btnGeri.setBounds(170, 190, 120, 30);
        add(btnGeri);

        
        btnGiris.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String kAdi = txtKullanici.getText();
                String sifre = new String(txtSifre.getPassword());
                String pinStr = new String(txtPin.getPassword());

                if (kAdi.isEmpty() || sifre.isEmpty() || pinStr.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Tüm alanları doldurun!", "Uyarı", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try {
                    int pin = Integer.parseInt(pinStr); 
                    
                    Yonetici girenYonetici = Sistem.yoneticiGiris(kAdi, sifre, pin);

                    if (girenYonetici != null) {
                        YoneticiPenceresi yp = new YoneticiPenceresi(girenYonetici);
                        yp.setVisible(true);
                        dispose(); 
                    } else {
                        JOptionPane.showMessageDialog(null, "Hatalı bilgi veya yetkisiz erişim!", "Erişim Reddedildi", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Admin PIN sadece rakamlardan oluşmalıdır!", "Hata", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        
        btnGeri.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GirisPaneli().setVisible(true);
                dispose();
            }
        });
    }
}