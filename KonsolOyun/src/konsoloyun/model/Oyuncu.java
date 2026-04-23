package konsoloyun.model;

public class Oyuncu extends Hesap {
	private double bakiye;
	private Kutuphane kutuphane;
	
	public Oyuncu(int id, String kullaniciAdi, String sifre, String eposta,double bakiye) {
		super(id, kullaniciAdi, sifre, eposta);
		this.bakiye = bakiye;
		this.kutuphane = new Kutuphane();
	}

	public Kutuphane getKutuphane() {
		return kutuphane;
	}

	public double getBakiye() {
		return bakiye;
	}
	
	public void bakiyeEkle(double miktar) {
	    if (miktar > 0) {
	        this.bakiye += miktar;
	        System.out.println("İşlem başarılı! Yeni bakiyeniz: " + this.bakiye);
	    } else {
	        System.out.println("HATA: Eklemek istediğiniz miktar 0'dan büyük olmalıdır!");
	    }
	}
	
	public boolean bakiyeDus(double miktar) {
        if (miktar > 0 && this.bakiye >= miktar) {
            this.bakiye -= miktar;
            System.out.println("Ödeme onaylandı. Kalan bakiye: " + this.bakiye + " TL");
            return true; 
        } else {
            System.out.println("HATA: Ödeme başarısız! Bakiye yetersiz veya miktar geçersiz.");
            return false;
        }
    }
}
