import Commentary.Commentary;
import Initializer.MatchIntializer;
import Methods.PlayBall;
import Methods.Update;
import beans.Player;
import beans.Required;

import java.util.ArrayList;
import java.util.List;

public class MatchStart {

    public static void main(String[] args) {

        /* initializing match stats */
        MatchIntializer matchIntializer = MatchIntializer.getInitializerInstance();
        List<Player> players = matchIntializer.getAllPlayers();
        Required required = matchIntializer.getMatchTarget();
        List<Player> onCrease = new ArrayList<Player>();

        onCrease.add(players.get(1));
        onCrease.add(players.get(0));
        //to ttrack who has to come next if one gets out
        int index = 2;
        /* to track no of balls completed so that we can swich batsmen when over got completed */

        int ballsCompleted = 0;

        /* to track players*/
        int playerPosition=0;
        for (int i = 0; i < required.getBallsLeft(); i++) {
            if(ballsCompleted%6==0){
                /* switch players of postitions of 0 and 1 when over got completed */
                onCrease=Update.overCompleted(onCrease);
                Commentary.writeOverCommentary(required,ballsCompleted);
            }


            /* playBall function returns integer based on player probability of hitting */
            int run = PlayBall.playBall(onCrease.get(playerPosition));
            ballsCompleted++;
            Commentary.ballbyballcommentary(ballsCompleted,onCrease.get(0),run);
            if(run==1||run==3||run==5){

                /* updating score of indvidual player */
             onCrease=Update.updatePlayerScore(onCrease,playerPosition,run);
                /* updating required score */
             required = Update.updateRequiredScore(required,run);
                /* we need to switch the batsmen when he scored odd number
                 * as we already wrote for switching batsmen when over completed so we can use it */
             onCrease=Update.overCompleted(onCrease);

            }

            else if (run==7) {
                required = Update.updateWickets(required);

                if (required.getWicketsLeft() > 2) {
                    for (int k = 0; k < players.size(); k++) {
                        if ((onCrease.get(0).getName().equals(players.get(k).getName()))) {
                            Player temp = onCrease.get(0);
                            temp.setOut(true);
                            temp.setPlaying(false);
                            int prevBalls = temp.getNumberofBallsPlayed();
                            temp.setNumberofBallsPlayed(prevBalls+1);
                            players.set(k, temp);
                            onCrease.set(0, players.get(index));
                            onCrease.get(0).setPlaying(true);
                            index++;
                            break;
                        }
                    }
                }
                else{
                    for (int k = 0; k < players.size(); k++) {
                        if ((onCrease.get(0).getName().equals(players.get(k).getName()))) {
                            Player temp = onCrease.get(0);
                            temp.setOut(true);
                            temp.setPlaying(false);
                            int prevBalls = temp.getNumberofBallsPlayed();
                            temp.setNumberofBallsPlayed(prevBalls+1);
                            players.set(k, temp);
                            break;
                        }
                    }
                    Commentary.alloutMatchSummary(required);
                    Commentary.printPlayerScores(players);
                    break;
                }
            }


            else{
                onCrease=Update.updatePlayerScore(onCrease,playerPosition,run);

                required = Update.updateRequiredScore(required,run);
            }
            if(required.getNumberOfRunsRequired()<=0){
                Commentary.matchSummary(required,ballsCompleted);
                Commentary.printPlayerScores(players);
                break;
            }

        }
        if(ballsCompleted==(required.getBallsLeft()-1)){
            Commentary.matchSummary(required,ballsCompleted);
            Commentary.printPlayerScores(players);
        }
    }


}
