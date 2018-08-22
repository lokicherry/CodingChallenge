import Initializer.Commentary;
import Initializer.MatchIntializer;
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
                onCrease=overCompleted(onCrease);
                Commentary.writeOverCommentary(required,ballsCompleted);
            }


            /* playBall function returns integer based on player probability of hitting */
            int run = PlayBall.playBall(onCrease.get(playerPosition));
            ballsCompleted++;
            Commentary.ballbyballcommentary(ballsCompleted,onCrease.get(0),run);
            if(run==1||run==3||run==5){

                /* updating score of indvidual player */
             onCrease=updatePlayerScore(onCrease,playerPosition,run);
                /* updating required score */
             required = updateRequiredScore(required,run);
                /* we need to switch the batsmen when he scored odd number
                 * as we already wrote for switching batsmen when over completed so we can use it */
             onCrease=overCompleted(onCrease);

            }

            else if (run==7) {
                required = updateWickets(required);
                if (required.getWicketsLeft() > 2) {
                    for (int k = 0; i < players.size(); k++) {
                        if (onCrease.get(0).getName() == players.get(k).getName()) {
                            onCrease.get(0).setOut(true);
                            onCrease.get(0).setPlaying(false);
                            players.set(k, onCrease.get(0));
                            onCrease.set(0, players.get(index));
                            index++;
                        }
                    }
                }
                else{
                    Commentary.alloutMatchSummary(required);
                    Commentary.printPlayerScores(players);
                    break;
                }
            }


            else{
                onCrease=updatePlayerScore(onCrease,playerPosition,run);

                required = updateRequiredScore(required,run);
            }
            if(required.getNumberOfRunsRequired()<=0){
                Commentary.matchSummary(required,ballsCompleted);
                Commentary.printPlayerScores(players);
                break;
            }

        }
    }

    public static List<Player> overCompleted(List<Player> players){
        Player temp = players.get(0);
        players.set(0,players.get(1));
        players.set(1,temp);
        return players;
    }

    /*update the required score and balls*/
    public static Required updateRequiredScore(Required required,int runsScored){
        int prevReqScore = required.getNumberOfRunsRequired();
        required.setNumberOfRunsRequired(prevReqScore-runsScored);

        return required;
    }

    /*update the score of the invidual player and balls played*/
    public static List<Player> updatePlayerScore(List<Player> players,int playerPosition,int runsScored){
        Player playertobeUpdated = players.get(playerPosition);
        int prevPlayerScore = playertobeUpdated.getNumberOfRunsScored();
        int prevPlayedBalls = playertobeUpdated.getNumberofBallsPlayed();
        playertobeUpdated.setNumberofBallsPlayed(prevPlayedBalls+1);
        playertobeUpdated.setNumberOfRunsScored(prevPlayerScore+runsScored);
        players.set(playerPosition,playertobeUpdated);
        return players;
    }

    public static Required updateWickets(Required required){
        int prevWickets = required.getWicketsLeft();
        required.setWicketsLeft(prevWickets-1);
        return required;
    }
}
