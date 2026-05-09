package konsoloyun.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import konsoloyun.model.Oyun;
import konsoloyun.model.Oyuncu;
import konsoloyun.servis.KrediKartiIleOdeme;
import konsoloyun.servis.OdemeYontemi;
import konsoloyun.veri.Sistem;

public class KrediKartiPenceresi extends JFrame {
	private static final long serialVersionUID = 1L;

	public KrediKartiPenceresi(Oyuncu aktifOyuncu, Oyun seciliOyun, OyuncuPenceresi anaPencere) {
        setTitle("Kredi Kartı İle Ödeme");
        setSize(350, 250);
        setLocationRelativeTo(null); 
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 

        
        getContentPane().setBackground(new Color(34, 40, 49));
        Color yaziRengi = new Color(199, 213, 224);

        JLabel lblBilgi = new JLabel("Ödenecek Tutar: " + seciliOyun.getFiyat() + " TL");
        lblBilgi.setBounds(30, 20, 250, 25);
        lblBilgi.setForeground(new Color(102, 192, 244));
        lblBilgi.setFont(new Font("Verdana", Font.BOLD, 13));
        add(lblBilgi);

        JLabel lblKartNo = new JLabel("Kart Numarası:");
        lblKartNo.setBounds(30, 60, 100, 25);
        lblKartNo.setForeground(yaziRengi);
        add(lblKartNo);

        JTextField txtKartNo = new JTextField();
        txtKartNo.setBounds(140, 60, 150, 25);
        add(txtKartNo);

        JLabel lblTarih = new JLabel("SKT (AA/YY):");
        lblTarih.setBounds(30, 100, 100, 25);
        lblTarih.setForeground(yaziRengi);
        add(lblTarih);

        JTextField txtTarih = new JTextField();
        txtTarih.setBounds(140, 100, 60, 25);
        add(txtTarih);

        JLabel lblCvv = new JLabel("CVV:");
        lblCvv.setBounds(210, 100, 40, 25);
        lblCvv.setForeground(yaziRengi);
        add(lblCvv);

        JTextField txtCvv = new JTextField();
        txtCvv.setBounds(250, 100, 40, 25);
        add(txtCvv);

        JButton btnOnayla = new JButton("Ödemeyi Onayla");
        btnOnayla.setBounds(30, 150, 260, 30);
        btnOnayla.setBackground(new Color(92, 126, 16));
        btnOnayla.setForeground(Color.WHITE);
        btnOnayla.setOpaque(true);
        btnOnayla.setBorderPainted(false);
        btnOnayla.setFocusPainted(false);
        add(btnOnayla);

        btnOnayla.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String kartNo = txtKartNo.getText();
                
                if (kartNo.isEmpty() || txtTarih.getText().isEmpty() || txtCvv.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Lütfen tüm kart bilgilerini doldurun!", "Uyarı", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try {
                    
                    OdemeYontemi odeme = new KrediKartiIleOdeme(kartNo);
                    odeme.odemeGerceklestir(seciliOyun.getFiyat()); 
                    
                   
                    aktifOyuncu.getKutuphane().oyunEkle(seciliOyun);
                    Sistem.verileriKaydet();
                    
                    
                    anaPencere.listeleriGuncelle();
                    
                    JOptionPane.showMessageDialog(null, seciliOyun.getAd() + " başarıyla satın alındı!", "İşlem Başarılı", JOptionPane.INFORMATION_MESSAGE);
                    dispose(); 

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Ödeme sırasında bir hata oluştu: " + ex.getMessage());
                }
            }
        });
    }
}