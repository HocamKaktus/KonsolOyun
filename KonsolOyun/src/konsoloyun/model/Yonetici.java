package konsoloyun.model;

public class Yonetici extends Hesap {
	private int adminSifresi;
	
	public Yonetici(int id, String kullaniciAdi, String sifre, String eposta,int adminSifresi) {
		super(id, kullaniciAdi, sifre, eposta);
		this.adminSifresi = adminSifresi;
	}

	public int getAdminSifresi() {
		return adminSifresi;
	}

	public void setAdminSifresi(int adminSifresi) {
		this.adminSifresi = adminSifresi;
	}
	
}
