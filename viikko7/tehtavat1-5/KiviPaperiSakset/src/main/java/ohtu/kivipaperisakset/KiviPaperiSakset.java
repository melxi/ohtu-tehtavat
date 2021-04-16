package ohtu.kivipaperisakset;

public abstract class KiviPaperiSakset {
    protected IO io;
    private String ekanSiirto;

    public KiviPaperiSakset(IO io) {
        this.io = io;
    }

    public void pelaa() {
        Tuomari tuomari = new Tuomari();

        io.print("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");

        ekanSiirto = ensimmaisenSiirto();
        String tokanSiirto = toisenSiirto();
        
        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            io.print(tuomari.toString());
            System.out.println();

            ekanSiirto = ensimmaisenSiirto();
            tokanSiirto = toisenSiirto();
        }

        System.out.println();
        io.print("Kiitos!");
        io.print(tuomari.toString());
    }

    protected String ensimmaisenSiirto() {
        io.print("Ensimmäisen pelaajan siirto: ");
        return io.nextLine();
    }

    // tämä on abstrakti metodi sillä sen toteutus vaihtelee eri pelityypeissä
    abstract protected String toisenSiirto();

    protected static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
}