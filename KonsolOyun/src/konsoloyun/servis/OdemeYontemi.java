package konsoloyun.servis;

import konsoloyun.veri.YetersizBakiyeException;

public interface OdemeYontemi {
    public void odemeGerceklestir(double tutar) throws YetersizBakiyeException; 
}