package nz.ac.auckland.se281.aiModes;

import java.util.ArrayList;

import nz.ac.auckland.se281.AI;
import nz.ac.auckland.se281.Strategy;
import nz.ac.auckland.se281.strategies.AverageStrategy;
import nz.ac.auckland.se281.strategies.RandomStrategy;
import nz.ac.auckland.se281.strategies.TopStrategy;

public class MasterAI extends AI{

    private Strategy[] alternatingStrategies = new Strategy[2];

    public MasterAI(String name, ArrayList<ArrayList<Integer>> history) {
        super(name);
        this.humanHistory = history.get(0);
    }

    @Override
    protected void checkStrategy() {
        if (this.count == 1) {
            this.strategy = new RandomStrategy();
        } else if (this.count == 4){

            this.strategy = new AverageStrategy(humanHistory);
            this.alternatingStrategies[0] = this.strategy;
        } else if (this.count == 5){

            this.strategy = new TopStrategy(humanHistory);
            this.alternatingStrategies[1] = this.strategy;
        } else if (this.count > 5){
            this.strategy = this.alternatingStrategies[this.count % 2];
        }
    }
    
}
