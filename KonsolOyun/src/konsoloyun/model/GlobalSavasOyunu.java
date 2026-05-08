package konsoloyun.model;

public class GlobalSavasOyunu extends Oyun implements Aksiyon, CokOyunculu{
	
	private static final long serialVersionUID = 1L;

	public GlobalSavasOyunu(double id, String ad, double fiyat) {
		super(id, ad, fiyat);
	}

	@Override
	public void sunucuyaBaglan() {
		System.out.println(getAd() + ": Online sunuculara bağlanılıyor...");
		
	}

	@Override
	public void aksiyonHareketiYap() {
		System.out.println(getAd() + " (Global): Aksiyon dozajı artırıldı!");
	}

	
}
