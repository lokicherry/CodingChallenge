package beans;

import java.util.List;

public class Player {
    private String name;
    private List<Integer> playerProbability;
    private int numberOfRunsScored;
    private int numberofBallsPlayed;
    public boolean isOut;
    public boolean isPlaying;
    public Player(String name, List<Integer> playerProbability,int numberofBallsPlayed,int numberOfRunsScored,boolean isOut,boolean isPlaying){
        this.name = name;
        this.playerProbability=playerProbability;
        this.numberofBallsPlayed=numberofBallsPlayed;
        this.numberOfRunsScored=numberOfRunsScored;
        this.isOut=isOut;
        this.isPlaying=isPlaying;
    }

    public List<Integer> getPlayerProbability() {
        return playerProbability;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlayerProbability(List<Integer> playerProbability) {
        this.playerProbability = playerProbability;
    }

    public String getName() {
        return name;
    }

    public void setNumberofBallsPlayed(int numberofBallsPlayed) {
        this.numberofBallsPlayed = numberofBallsPlayed;
    }

    public int getNumberofBallsPlayed() {
        return numberofBallsPlayed;
    }

    public int getNumberOfRunsScored() {
        return numberOfRunsScored;
    }

    public void setNumberOfRunsScored(int numberOfRunsScored) {
        this.numberOfRunsScored = numberOfRunsScored;
    }

    public void setOut(boolean out) {
        isOut = out;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }
}