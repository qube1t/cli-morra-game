package nz.ac.auckland.se281.aiModes;

import java.util.ArrayList;

import nz.ac.auckland.se281.AI;
import nz.ac.auckland.se281.strategies.AverageStrategy;
import nz.ac.auckland.se281.strategies.RandomStrategy;

public class mediumAI extends AI{

    public mediumAI(String name) {
        super(name);
    }



    @Override
    protected void checkStrategy(ArrayList<ArrayList<Integer>> reg) {
        if (this.count == 1) {
            this.strategy = new RandomStrategy();
        } else if (this.count == 4){
            ArrayList<Integer> humanInputs = reg.get(0);
            this.strategy = new AverageStrategy(humanInputs);
        }
    }
    
}
