package ohtu.kivipaperisakset;

public class Paaohjelma {

    private static final KonsoliIO io = new KonsoliIO();

    public static void main(String[] args) {
        KiviPaperiSaksetTehdas pelit = new KiviPaperiSaksetTehdas(io);

        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = io.nextLine();
            pelit.hae(vastaus).pelaa();
        }
    }
}
