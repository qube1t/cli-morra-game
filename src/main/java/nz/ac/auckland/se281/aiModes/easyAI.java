package nz.ac.auckland.se281.aiModes;

import java.util.ArrayList;

import nz.ac.auckland.se281.AI;
import nz.ac.auckland.se281.strategies.RandomStrategy;

public class easyAI extends AI{

    public easyAI(String name) {
        super(name);
    }

    @Override
    protected void checkStrategy(ArrayList<ArrayList<Integer>> reg) {
        this.strategy = new RandomStrategy();
    }
    
}
