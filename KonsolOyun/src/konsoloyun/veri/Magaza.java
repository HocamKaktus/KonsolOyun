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

    public void magazaOyunEkle(Oyun oyun) throws OyunZatenVarException {
        if (magazaOyunlari.contains(oyun)) {
            throw new OyunZatenVarException(oyun.getAd() + " zaten mağazada mevcut!");
        }
        magazaOyunlari.add(oyun);
    }

    public List<Oyun> getMagazaOyunlari() {
        return magazaOyunlari;
    }
}