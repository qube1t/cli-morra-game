package nz.ac.auckland.se281.strategies;

import java.util.ArrayList;

import nz.ac.auckland.se281.Strategy;
import nz.ac.auckland.se281.Utils;

public class TopStrategy implements Strategy{
    private ArrayList<Integer> humanHistory;

    public TopStrategy(ArrayList<Integer> reg){
        this.humanHistory = reg;
    }

    private int getMode() {
        int mode = humanHistory.get(0);
        int maxCount = 0;
        for (int i = 0; i < humanHistory.size(); i++) {
            int value = humanHistory.get(i);
            int count = 1;
            for (int j = 0; j < humanHistory.size(); j++) {
                if (humanHistory.get(j) == value)
                    count++;
                }
            if (count > maxCount) {
                mode = value;
                maxCount = count;
            }
        }
        return mode;
    }

    @Override
    public int[] engage() {
        int fingers = Utils.getRandomNumber(1, 5);
        int sum = fingers + (int) getMode();

        return new int[]{fingers, sum};
    }

    
}
