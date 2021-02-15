package ohtuesimerkki;

import java.util.*;

import org.junit.*;
import static org.junit.Assert.*;

public class StatisticsTest {

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp() {
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }

    @Test
    public void etsittyPelaajaLoytyy() {
        Player player = stats.search("Semenko");
        assertEquals("Semenko", player.getName());
    }

    @Test
    public void etsittyPelaajaEiLoydy() {
        Player player = stats.search("Random");
        assertEquals(null, player);
    }

    @Test
    public void listaJoukkueenPelaajista() {
        List<Player> players = stats.team("EDM");

        assertEquals(players.size(), 3);
    }

    @Test
    public void parhaatMaalinTekijat() {
        List<Player> scorers = stats.topScorers(2);
        
        assertEquals(scorers.size(), 3);
    }
}
