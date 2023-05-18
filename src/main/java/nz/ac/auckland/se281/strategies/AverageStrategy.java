package nz.ac.auckland.se281.strategies;

import java.util.ArrayList;

import nz.ac.auckland.se281.Strategy;
import nz.ac.auckland.se281.Utils;

public class AverageStrategy implements Strategy {
    private ArrayList<Integer> humanHistory;

    public AverageStrategy(ArrayList<Integer> reg){
        this.humanHistory = reg;
    }

    private int getAverage(){
        int sum = 0;
        for (int i = 0; i < humanHistory.size(); i++) {
            sum += humanHistory.get(i);
        }

        // return the average with rounding
        return Math.round((float)sum / humanHistory.size());
    }

    @Override
    public int[] engage() {
        // get a random number of fingers and get sum with average
        int fingers = Utils.getRandomNumber(1, 5);
        int sum = fingers + (int) getAverage();

        return new int[]{fingers, sum}; 
        
    }

}
