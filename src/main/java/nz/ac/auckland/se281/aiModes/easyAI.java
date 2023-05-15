package nz.ac.auckland.se281.aiModes;

import nz.ac.auckland.se281.AI;
import nz.ac.auckland.se281.Utils;

public class easyAI implements AI{

    @Override
    public int[] play() {
        int fingers = Utils.getRandomNumber(1, 5);
        int sum = Utils.getRandomNumber(fingers + 1, 10);

        return new int[]{fingers, sum};
    }
    
}
