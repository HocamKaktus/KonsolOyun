package konsoloyun.veri;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DosyaYoneticisi {
	
    public static <T> void verileriKaydet(List<T> liste, String dosyaAdi) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dosyaAdi))) {
            oos.writeObject(liste);
            System.out.println("Sistem: " + dosyaAdi + " başarıyla güncellendi.");
        } catch (IOException e) {
            System.err.println("Dosya yazma hatası: " + e.getMessage());
        }
    }


    @SuppressWarnings("unchecked")
    public static <T> List<T> verileriOku(String dosyaAdi) {
        File dosya = new File(dosyaAdi);
        if (!dosya.exists()) {
            return new ArrayList<>(); 
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dosyaAdi))) {
            return (List<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Dosya okuma hatası: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}

