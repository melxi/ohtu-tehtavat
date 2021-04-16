package ohtu.kivipaperisakset;

public class KPSTekoaly extends KiviPaperiSakset {
    
    private final Tekoaly tekoaly = new Tekoaly();
    private String ekanSiirto;

    public KPSTekoaly(IO io) {
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