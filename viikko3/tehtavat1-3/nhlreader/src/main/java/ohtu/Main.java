package ohtu;

import java.util.*;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();
                
        // System.out.println("json-muotoinen data:");
        // System.out.println( bodyText );

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        List<Player> finnishPlayers = new ArrayList<>();

        // System.out.println("Oliot:");
        // for (Player player : players) {
        //     System.out.println(player);
        // }  

        Date date = new Date();  
        System.out.println("Players from FIN " + date + "\n");

        for (Player player : players) {
            if (player.getNationality().equals("FIN")) {
                finnishPlayers.add(player);
            }
        }

        Collections.sort(finnishPlayers);

        for (Player player: finnishPlayers) {
            System.out.println(player);
        }
    }
}
