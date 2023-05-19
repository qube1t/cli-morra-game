package nz.ac.auckland.se281.aiModes;

import java.util.ArrayList;

import nz.ac.auckland.se281.AI;
import nz.ac.auckland.se281.strategies.AverageStrategy;
import nz.ac.auckland.se281.strategies.RandomStrategy;

public class MediumAI extends AI{

    public MediumAI(String name, ArrayList<ArrayList<Integer>> history) {
        super(name);
        this.humanHistory = history.get(0);
    }

    @Override
    protected void checkStrategy() {
        if (this.round == 1) {
            // set random strategy at first round 
            this.strategy = new RandomStrategy();
        } else if (this.round == 4){
            // set average strategy at fourth round
            this.strategy = new AverageStrategy(humanHistory);
        }
    }
    
}
