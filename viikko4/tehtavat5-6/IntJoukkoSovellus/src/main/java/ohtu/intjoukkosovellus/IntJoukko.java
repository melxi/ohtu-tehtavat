package ohtu.intjoukkosovellus;

import java.util.*;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] lukujono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this(KAPASITEETTI);
    }

    public IntJoukko(int kapasiteetti) {        
        this(kapasiteetti, OLETUSKASVATUS);
    }
    
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetin on oltava positiivinen");
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Kasvatuskoon on oltava positiivinen");
        }
        
        lukujono = new int[kapasiteetti];
        
        for (int i = 0; i < lukujono.length; i++) {
            lukujono[i] = 0;
        }
        
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;

    }

    public boolean lisaa(int luku) {
        if (kuuluu(luku)) {
            return false;
        } else {
            if (alkioidenLkm % lukujono.length == 0) {
                kopioiTaulukko();
            }

            lukujono[alkioidenLkm] = luku;
            alkioidenLkm++;
            return true;
        }
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == lukujono[i]) {
                return true;
            }
        }
        
        return false;
    }

    public boolean poista(int luku) {
        int poistettavanIndeksi = -1;

        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == lukujono[i]) {
                poistettavanIndeksi = i;
                lukujono[i] = 0;
                break;
            }
        }

        if (poistettavanIndeksi != -1) {
            int temp;
            for (int j = poistettavanIndeksi; j < alkioidenLkm - 1; j++) {
                temp = lukujono[j];
                lukujono[j] = lukujono[j + 1];
                lukujono[j + 1] = temp;
            }
            
            alkioidenLkm--;

            return true;
        }

        return false;
    }

    private void kopioiTaulukko() {
        int uusiKoko = alkioidenLkm + kasvatuskoko;
        int[] uusiLukujono = new int[uusiKoko];

        for (int i = 0; i < alkioidenLkm; i++) {
            uusiLukujono[i] = lukujono[i];
        }

        lukujono = uusiLukujono;
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }


    @Override
    public String toString() {
        String lukujonoTuloste = "{";

        for (int i = 0; i < alkioidenLkm; i++) {
             if (i == alkioidenLkm - 1) {
                lukujonoTuloste += lukujono[i] + "";
            } else {
                lukujonoTuloste += lukujono[i] + ", ";
            }
        }
        
        return lukujonoTuloste + "}";
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = lukujono[i];
        }
        return taulu;
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko yhdisteJoukko = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        
        for (int i = 0; i < aTaulu.length; i++) {
            yhdisteJoukko.lisaa(aTaulu[i]);
        }

        for (int i = 0; i < bTaulu.length; i++) {
            yhdisteJoukko.lisaa(bTaulu[i]);
        }

        return yhdisteJoukko;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko leikkausJoukko = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();

        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    leikkausJoukko.lisaa(bTaulu[j]);
                }
            }
        }

        return leikkausJoukko;
    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko erotusJoukko = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();

        for (int i = 0; i < aTaulu.length; i++) {
            erotusJoukko.lisaa(aTaulu[i]);
        }

        for (int i = 0; i < bTaulu.length; i++) {
            erotusJoukko.poista(bTaulu[i]);
        }
 
        return erotusJoukko;
    }   
}