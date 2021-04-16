package ohtu.kivipaperisakset;

// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends KiviPaperiSakset {

    private final Tekoaly tekoaly = new Tekoaly();
    private String ekanSiirto;

    public KPSParempiTekoaly(IO io) {
        super(io);
    }

    @Override
    protected String toisenSiirto() {

        String tokanSiirto;
        tokanSiirto = tekoaly.annaSiirto();
        io.print("Tietokone valitsi: " + tokanSiirto);

        tekoaly.asetaSiirto(ekanSiirto);

        return tokanSiirto;
    }
}
