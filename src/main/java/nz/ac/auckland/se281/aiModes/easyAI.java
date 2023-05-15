package nz.ac.auckland.se281.aiModes;

import nz.ac.auckland.se281.AI;
import nz.ac.auckland.se281.strategies.RandomStrategy;

public class easyAI extends AI{

    public easyAI(String name) {
        super(name);
        this.setStrategy();
    }

    @Override
    protected void setStrategy() {
        this.strategy = new RandomStrategy();
    }
    
}
