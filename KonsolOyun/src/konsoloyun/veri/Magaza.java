package konsoloyun.veri;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import konsoloyun.model.Oyun;

public class Magaza implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Oyun> magazaOyunlari;

    public Magaza() {
        this.magazaOyunlari = new ArrayList<>();
    }

    public void magazaOyunEkle(Oyun yeniOyun) throws OyunZatenVarException {
        for (Oyun o : magazaOyunlari) {
            if (o.getAd().equalsIgnoreCase(yeniOyun.getAd().trim())) {
                throw new OyunZatenVarException("Hata: '" + yeniOyun.getAd() + "' isimli oyun mağazada zaten mevcut!");
            }
        }
        magazaOyunlari.add(yeniOyun);
    }

    public List<Oyun> getMagazaOyunlari() {
        return magazaOyunlari;
    }
}