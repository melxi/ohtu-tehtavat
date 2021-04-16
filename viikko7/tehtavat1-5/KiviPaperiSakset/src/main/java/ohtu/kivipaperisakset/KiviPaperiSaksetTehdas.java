package ohtu.kivipaperisakset;

import java.util.HashMap;

public class KiviPaperiSaksetTehdas {
    private final HashMap<String, KiviPaperiSakset> pelit;

    public KiviPaperiSaksetTehdas(IO io) {
        pelit = new HashMap();
        pelit.put("a", new KPSPelaajaVsPelaaja(io));
        pelit.put("b", new KPSTekoaly(io));
        pelit.put("c", new KPSParempiTekoaly(io));
    }

    public KiviPaperiSakset hae(String operaatio) {
        if (pelit.get(operaatio) == null) {
            System.exit(0);
        }
        
        return pelit.get(operaatio);
    }
}