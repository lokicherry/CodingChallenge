package Methods;

import beans.Player;

import java.util.List;

public class PlayBall {
    public static int playBall(Player player){
        List<Integer> probabiityList = player.getPlayerProbability();
        int randomnumber = (int) (Math.random()*100);
        int runs=0;
        for(int i=0;i<probabiityList.size();i++){
            if(randomnumber-probabiityList.get(i)<=0){
                runs=i;
                break;
            }
            randomnumber=randomnumber-probabiityList.get(i);
        }
        System.out.println("returning "+runs);
        return runs;
    }
}
