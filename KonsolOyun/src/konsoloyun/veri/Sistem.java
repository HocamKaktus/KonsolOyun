package konsoloyun.veri;

import konsoloyun.model.*;
import java.util.ArrayList;
import java.util.List;

public class Sistem {
    public static Magaza aktifMagaza = new Magaza();
    public static List<Oyuncu> oyuncular = new ArrayList<>();
    public static List<Yonetici> yoneticiler = new ArrayList<>(); 
    
    private static int siradakiId = 1; 

    static {
       
        yoneticiler.add(new Yonetici(1, "admin", "admin123", "admin@mail.com", 9999));

        
        List<Oyuncu> okunanListe = DosyaYoneticisi.verileriOku("oyuncular.dat");
        if (okunanListe != null && !okunanListe.isEmpty()) {
            oyuncular = okunanListe;
            int maxId = 0;
            for (Oyuncu o : oyuncular) {
                if (o.getId() > maxId) maxId = o.getId();
            }
            siradakiId = maxId + 1;
        } else {
            
            
            verileriKaydet();
        }

        
        List<Oyun> okunanMagaza = DosyaYoneticisi.verileriOku("magaza.dat");
        if (okunanMagaza != null && !okunanMagaza.isEmpty()) {
            for (Oyun o : okunanMagaza) {
                try {
                    aktifMagaza.magazaOyunEkle(o);
                } catch (OyunZatenVarException e) {
                    
                }
            }
        } else {
            magazaKaydet(); 
        }
    }

    public static void verileriKaydet() {
        DosyaYoneticisi.verileriKaydet(oyuncular, "oyuncular.dat");
    }

    public static void magazaKaydet() {
        DosyaYoneticisi.verileriKaydet(aktifMagaza.getMagazaOyunlari(), "magaza.dat");
    }

    public static void oyuncuEkle(String kullaniciAdi, String sifre, String eposta) {
        Oyuncu yeniOyuncu = new Oyuncu(siradakiId++, kullaniciAdi, sifre, eposta, 0.0);
        oyuncular.add(yeniOyuncu);
        verileriKaydet(); 
    }

    public static Oyuncu oyuncuGiris(String kullaniciAdi, String sifre) {
        for (Oyuncu o : oyuncular) {
            if (o.getKullaniciAdi().equals(kullaniciAdi) && o.getSifre().equals(sifre)) {
                return o; 
            }
        }
        return null; 
    }

    public static Yonetici yoneticiGiris(String kullaniciAdi, String sifre, int adminPin) {
        for (Yonetici y : yoneticiler) {
            if (y.getKullaniciAdi().equals(kullaniciAdi) && y.getSifre().equals(sifre) && y.getAdminSifresi() == adminPin) {
                return y; 
            }
        }
        return null; 
    }
}