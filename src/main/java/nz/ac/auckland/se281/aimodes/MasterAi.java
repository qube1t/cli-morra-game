package nz.ac.auckland.se281.aimodes;

import java.util.ArrayList;

import nz.ac.auckland.se281.Ai;
import nz.ac.auckland.se281.Strategy;
import nz.ac.auckland.se281.strategies.AverageStrategy;
import nz.ac.auckland.se281.strategies.RandomStrategy;
import nz.ac.auckland.se281.strategies.TopStrategy;

public class MasterAi extends Ai {

  private Strategy[] alternatingStrategies = new Strategy[2];

  public MasterAi(String name, ArrayList<ArrayList<Integer>> history) {
    super(name);
    this.humanHistory = history.get(0);
  }

  @Override
  protected void checkStrategy() {
    Strategy strat;

    if (this.round == 1) {
      // set random strategy at first round
      // strat = new RandomStrategy();
      setStrategy(new RandomStrategy());
    } else if (this.round == 4) {
      // set average strategy at fourth round
      strat = new AverageStrategy(humanHistory);
      setStrategy(strat);
      // add this strategy to the alternating strategies to be used later
      this.alternatingStrategies[0] = strat;
    } else if (this.round == 5) {
      // set top strategy at fifth round
      strat = new TopStrategy(humanHistory);
      setStrategy(strat);
      // add this strategy to the alternating strategies to be used later
      this.alternatingStrategies[1] = strat;
    } else if (this.round > 5) {
      // set alternating strategies from sixth round
      strat = this.alternatingStrategies[this.round % 2];
      setStrategy(strat);
    }
  }

}
