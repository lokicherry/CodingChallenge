package beans;

public class Required {
    private int numberOfRunsRequired;
    private int wicketsLeft;
    private int ballsLeft;
    public Required(int numberOfRunsRequired,int ballsLeft,int wicketsLeft){
        this.numberOfRunsRequired=numberOfRunsRequired;
        this.wicketsLeft=wicketsLeft;
        this.ballsLeft=ballsLeft;
    }

    public void setNumberOfRunsRequired(int numberOfRunsRequired) {
        this.numberOfRunsRequired = numberOfRunsRequired;
    }

    public int getNumberOfRunsRequired() {
        return numberOfRunsRequired;
    }

    public void setWicketsLeft(int wicketsLeft) {
        this.wicketsLeft = wicketsLeft;
    }

    public int getWicketsLeft() {
        return wicketsLeft;
    }

    public void setBallsLeft(int ballsLeft) {
        this.ballsLeft = ballsLeft;
    }

    public int getBallsLeft() {
        return ballsLeft;
    }
}
