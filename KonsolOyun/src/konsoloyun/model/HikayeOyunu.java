package konsoloyun.model;

public class HikayeOyunu extends Oyun implements AcikDunya, TekOyunculu{

	
	private static final long serialVersionUID = 1L;

	public HikayeOyunu(double id, String ad, double fiyat) {
		super(id, ad, fiyat);
	}

	@Override
	public void haritayiKesfet() {
		System.out.println(getAd() + ": Devasa açık dünya keşfediliyor...");
	}

	@Override
	public void tekOyunculuModuBaslat() {
		System.out.println(getAd() + ": Hikaye modu başlatıldı.");
	}

}
