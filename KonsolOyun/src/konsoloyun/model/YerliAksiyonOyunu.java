package konsoloyun.model;

public class YerliAksiyonOyunu extends Oyun implements Aksiyon,Yerli {
	public YerliAksiyonOyunu(int id,String ad,double fiyat) {
		super(id,ad,fiyat);
	}
	@Override
	public void aksiyonHareketiYap() {
		System.out.println(getAd() + " yerli aksiyon gücüyle çalışıyor!");
	}
	
	@Override
	public void vergiIndirimiUygula() {
		double eskiFiyat = getFiyat();
	    double yeniFiyat = eskiFiyat * 0.80;
	    setFiyat(yeniFiyat);
	    
	    System.out.println(getAd() + " için yerli indirimi uygulandı! " + eskiFiyat + " TL -> " + yeniFiyat + " TL");
	}
}
