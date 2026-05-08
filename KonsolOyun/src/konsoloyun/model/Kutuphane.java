package konsoloyun.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Kutuphane implements Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList<Oyun> oyunListesi = new ArrayList<>();
    
    public Kutuphane() {
    }
    
    public void oyunEkle(Oyun yeniOyun) {
        oyunListesi.add(yeniOyun);
    }
    
    public void oyunlariGoster() {
        if(oyunListesi.isEmpty()) {
            System.out.println("Kütüphanenizde henüz hiç oyun yok.");
        }
        for(Oyun oyun : oyunListesi) {
            System.out.println("- " + oyun.getAd());
        }
    }
    
    public boolean oyunVarMi(Oyun arananOyun) {
        return oyunListesi.contains(arananOyun);
    }

    public List<Oyun> getOyunListesi() {
        return oyunListesi;
    }
}