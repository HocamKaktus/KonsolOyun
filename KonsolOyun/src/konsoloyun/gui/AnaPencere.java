package konsoloyun.gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.net.URL;

public class AnaPencere extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                AnaPencere frame = new AnaPencere();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public AnaPencere() {
        setResizable(false); 
        setTitle("Oyun Mağazası");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setBounds(300, 100, 500, 400);
        
        contentPane = new JPanel();     
        contentPane.setBackground(SystemColor.activeCaption);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null); 
        
        JLabel lblNewLabel = new JLabel("KONSOL OYUN MAĞAZASI");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel.setBounds(85, -11, 425, 191);
        contentPane.add(lblNewLabel);
        
        JButton btnNewButton = new JButton("Giriş Yap");
        btnNewButton.setFont(new Font("Verdana", Font.BOLD, 15));
        btnNewButton.setBounds(167, 261, 132, 22);
        contentPane.add(btnNewButton);
        
        
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GirisPaneli giris = new GirisPaneli();
                giris.setVisible(true);
                dispose(); 
            }
        });        
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setBounds(190, 167, 146, 83);
        
        URL resimYolu = AnaPencere.class.getResource("/Giris.png");
        if(resimYolu != null) {
            lblNewLabel_1.setIcon(new ImageIcon(resimYolu));
        } else {
            lblNewLabel_1.setText("Resim Yok");
        }
        contentPane.add(lblNewLabel_1);
    }
}