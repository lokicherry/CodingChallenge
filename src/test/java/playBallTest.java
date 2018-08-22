import beans.Player;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class playBallTest{
    Player player = new Player("loki",Arrays.asList(5,30,25,10,15,1,9,5));
    PlayBall playBallTest = new PlayBall();

    @Test
    public void testingPlayBallMethod(){
        int runs = playBallTest.playBall(player);
       assertTrue(0<=runs&&runs<8);
    }
}
