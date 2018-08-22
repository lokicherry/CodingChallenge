package Initializer;

import beans.Player;
import beans.Required;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatchIntializer {
    private static MatchIntializer initializerInstance = new MatchIntializer();

    private MatchIntializer(){
    }

    public static MatchIntializer getInitializerInstance(){ return initializerInstance;}

    public List<Player> getAllPlayers() {
        List<Player> players = new ArrayList<Player>();
        players.add(new Player("Kirat Boli",Arrays.asList(5,30,25,10,15,1,9,5),0,0,false,true));
        players.add(new Player("N.S Nodhi",Arrays.asList(10,40,20,5,10,1,4,10),0,0,false,true));
        players.add(new Player("R Rumrah",Arrays.asList(20,30,15,5,5,1,4,20),0,0,false,false));
        players.add(new Player("Kirat Boli",Arrays.asList(30,25,5,0,5,1,4,30),0,0,false,false));
        return players;
    }

    public Required getMatchTarget(){
        Required required = new Required(40,24,4);
        return required;
    }
}
