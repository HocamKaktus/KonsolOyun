package konsoloyun.model;

import java.io.Serializable;


public abstract class Hesap implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String kullaniciAdi;
	private String sifre;
	private String eposta;
	
	public Hesap(int id, String kullaniciAdi,String sifre,String eposta) {
		this.id = id;
		this.kullaniciAdi = kullaniciAdi;
		this.sifre = sifre;
		this.eposta = eposta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKullaniciAdi() {
		return kullaniciAdi;
	}

	public void setKullaniciAdi(String kullaniciAdi) {
		this.kullaniciAdi = kullaniciAdi;
	}

	public String getSifre() {
		return sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}

	public String getEposta() {
		return eposta;
	}

	public void setEposta(String eposta) {
		this.eposta = eposta;
	}
}
