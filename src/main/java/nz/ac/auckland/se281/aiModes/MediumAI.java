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
        if (this.count == 1) {
            this.strategy = new RandomStrategy();
        } else if (this.count == 4){
            this.strategy = new AverageStrategy(humanHistory);
        }
    }
    
}
