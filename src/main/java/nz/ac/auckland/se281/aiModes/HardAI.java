package nz.ac.auckland.se281.aiModes;

import java.util.ArrayList;

import nz.ac.auckland.se281.AI;
import nz.ac.auckland.se281.strategies.RandomStrategy;
import nz.ac.auckland.se281.strategies.TopStrategy;

public class HardAI extends AI{

    public HardAI(String name) {
        super(name);
    }

    @Override
    protected void checkStrategy(ArrayList<ArrayList<Integer>> reg) {
        if (this.count == 1) {
            this.strategy = new RandomStrategy();
        } else if (this.count == 4){
            ArrayList<Integer> humanInputs = reg.get(0);
            this.strategy = new TopStrategy(humanInputs);
        }
    }
    
}
