package nz.ac.auckland.se281.aiModes;

import java.util.ArrayList;

import nz.ac.auckland.se281.AI;
import nz.ac.auckland.se281.strategies.RandomStrategy;

public class EasyAI extends AI{

    public EasyAI(String name) {
        super(name);
    }

    @Override
    protected void checkStrategy(ArrayList<ArrayList<Integer>> reg) {
        if (this.count == 1)
            this.strategy = new RandomStrategy();
    }
    
}
