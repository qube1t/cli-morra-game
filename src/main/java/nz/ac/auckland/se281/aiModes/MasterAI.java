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
        if (this.round == 1) {
            // set random strategy at first round
            this.strategy = new RandomStrategy();
        } else if (this.round == 4){
            // set average strategy at fourth round
            this.strategy = new AverageStrategy(humanHistory);
            // add this strategy to the alternating strategies to be used later
            this.alternatingStrategies[0] = this.strategy;
        } else if (this.round == 5){
            // set top strategy at fifth round
            this.strategy = new TopStrategy(humanHistory);
            // add this strategy to the alternating strategies to be used later
            this.alternatingStrategies[1] = this.strategy;
        } else if (this.round > 5){
            // set alternating strategies from sixth round
            this.strategy = this.alternatingStrategies[this.round % 2];
        }
    }
    
}
