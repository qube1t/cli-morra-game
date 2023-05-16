package nz.ac.auckland.se281.aiModes;

import java.util.ArrayList;

import nz.ac.auckland.se281.AI;
import nz.ac.auckland.se281.Strategy;
import nz.ac.auckland.se281.strategies.AverageStrategy;
import nz.ac.auckland.se281.strategies.RandomStrategy;
import nz.ac.auckland.se281.strategies.TopStrategy;

public class MasterAI extends AI{

    private Strategy[] alternatingStrategies = new Strategy[2];

    public MasterAI(String name) {
        super(name);
        //TODO Auto-generated constructor stub
    }

    @Override
    protected void checkStrategy(ArrayList<ArrayList<Integer>> reg) {
        if (this.count == 1) {
            this.strategy = new RandomStrategy();
        } else if (this.count == 4){
            ArrayList<Integer> humanInputs = reg.get(0);
            this.strategy = new AverageStrategy(humanInputs);
            this.alternatingStrategies[0] = this.strategy;
        } else if (this.count == 5){
            ArrayList<Integer> humanInputs = reg.get(0);
            this.strategy = new TopStrategy(humanInputs);
            this.alternatingStrategies[1] = this.strategy;
        } else if (this.count > 5){
            this.strategy = this.alternatingStrategies[this.count % 2];
        }
    }
    
}
