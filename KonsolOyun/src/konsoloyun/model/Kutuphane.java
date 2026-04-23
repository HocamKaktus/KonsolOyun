package konsoloyun.model;
import java.util.ArrayList;



public class Kutuphane {
	private ArrayList<Oyun> oyunListesi = new ArrayList<>();
	
	Kutuphane() {
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
}
