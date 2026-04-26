package konsoloyun.model;

public class OnlineSporOyunu extends Oyun implements Spor, CokOyunculu{

	
	private static final long serialVersionUID = 1L;

	OnlineSporOyunu(double id, String ad, double fiyat) {
		super(id, ad, fiyat);
	}

	@Override
	public void sunucuyaBaglan() {
		System.out.println(getAd() + ": Online sunuculara bağlanılıyor...");
	}

	@Override
	public void macaBasla() {
		System.out.println(getAd() + ": Maç için sahaya çıkılıyor!");
	}

	
}
