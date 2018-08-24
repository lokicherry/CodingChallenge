package Commentary;

import beans.Player;
import beans.Required;

import java.util.List;

public class Commentary {

    public static void matchSummary(Required required, int ballsCompleted) {
        System.out.println();
        System.out.println("*******************************");
        System.out.println("\tMatch Summary:");
        System.out.println("\tBengaluru won the match");
        int wickets = required.getWicketsLeft() - 2;
        int ballsleft = required.getBallsLeft() - ballsCompleted;
        System.out.println("Bengaluru won by" + wickets + " wickets and " + ballsleft + " balls remaining");
    }

    public static void writeOverCommentary(Required required, int ballsCompleted) {
        System.out.println();
        int oversleft = 4 - (ballsCompleted / 6);
        System.out.println(oversleft + " overs left. " + required.getNumberOfRunsRequired() + " runs to win");
    }

    public static void printPlayerScores(List<Player> players) {
        System.out.println();
        Player currentPlayer;
        for (int i = 0; i < players.size(); i++) {
            System.out.println("\t"+players.get(i).getName()+" - "+players.get(i).getNumberOfRunsScored()+"("+players.get(i).getNumberofBallsPlayed()+")");
        }
    }

    public static void alloutMatchSummary(Required required) {
        System.out.println();
        System.out.println("*******************************");
        System.out.println("\tMatch Summary:");
        System.out.println("Bengaluru lost the match");
        System.out.println("Chennai won by" + required.getNumberOfRunsRequired()+" runs");
    }

    public static void ballbyballcommentary(int ballsCompleted, Player player, int runs) {
        int overs = ballsCompleted / 6;
        int balls = ballsCompleted % 6;
        String name = player.getName();
        if (runs == 7) {
            System.out.println(" " + overs + "." + balls + ":\t" + name + " \"OUT\"");
        } else System.out.println(" " + overs + "." + balls + ":\t" + name + " scores " + runs + " runs");
    }
}
