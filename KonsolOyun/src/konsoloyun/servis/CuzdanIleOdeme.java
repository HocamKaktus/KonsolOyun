package konsoloyun.servis;

public class CuzdanIleOdeme implements OdemeYontemi {

    private double bakiye;

    public CuzdanIleOdeme(double bakiye) {
        this.bakiye = bakiye;
    }

    @Override
    public void odemeGerceklestir(double tutar) {
        if (tutar <= 0) {
            System.out.println("Geçersiz tutar!");
            return;
        }

        if (bakiye >= tutar) {
            bakiye -= tutar;
            System.out.println("Cüzdan ile ödeme başarılı. Kalan bakiye: " + bakiye);
        } else {
            System.out.println("Yetersiz bakiye! Mevcut bakiye: " + bakiye);
        }
    }

    public double getBakiye() {
        return bakiye;
    }
}