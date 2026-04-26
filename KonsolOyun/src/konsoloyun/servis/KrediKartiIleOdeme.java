package konsoloyun.servis;

public class KrediKartiIleOdeme implements OdemeYontemi {

    private String kartNo;

    public KrediKartiIleOdeme(String kartNo) {
        this.kartNo = kartNo;
    }

    @Override
    public void odemeGerceklestir(double tutar) {
        if (tutar <= 0) {
            System.out.println("Geçersiz tutar!");
            return;
        }
        System.out.println("Kredi kartı (" + kartNo + ") ile " + tutar + " TL ödeme alındı.");
    }
}