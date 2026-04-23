package konsoloyun.model;

import java.util.Objects;

public class Oyun {
private double id;
private String ad;
private double fiyat;


	Oyun(double id,String ad, double fiyat) {
	this.id = id;
	this.ad = ad;
	this.fiyat = fiyat;
	}


	public double getId() {
		return id;
	}


	public void setId(double id) {
		this.id = id;
	}


	public String getAd() {
		return ad;
	}


	public void setAd(String ad) {
		this.ad = ad;
	}


	public double getFiyat() {
		return fiyat;
	}


	public void setFiyat(double fiyat) {
		this.fiyat = fiyat;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Oyun other = (Oyun) obj;
		return Double.doubleToLongBits(id) == Double.doubleToLongBits(other.id);
	}
	
}
