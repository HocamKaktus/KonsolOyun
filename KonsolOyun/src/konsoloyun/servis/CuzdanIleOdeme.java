package konsoloyun.servis;

import konsoloyun.model.Oyuncu;
import konsoloyun.veri.YetersizBakiyeException;

public class CuzdanIleOdeme implements OdemeYontemi {

	private Oyuncu aktifOyuncu;
	
	public CuzdanIleOdeme(Oyuncu aktifOyuncu) {
        this.aktifOyuncu = aktifOyuncu;
    }

	@Override
    public void odemeGerceklestir(double tutar) throws YetersizBakiyeException{
       aktifOyuncu.odemeYap(tutar);	
    }
}