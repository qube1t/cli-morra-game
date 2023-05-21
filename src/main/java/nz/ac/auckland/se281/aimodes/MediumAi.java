package nz.ac.auckland.se281.aimodes;

import java.util.ArrayList;

import nz.ac.auckland.se281.Ai;
import nz.ac.auckland.se281.strategies.AverageStrategy;
import nz.ac.auckland.se281.strategies.RandomStrategy;

public class MediumAi extends Ai {

  public MediumAi(String name, ArrayList<ArrayList<Integer>> history) {
    super(name);
    this.humanHistory = history.get(0);
  }

  @Override
  protected void checkStrategy() {
    if (this.round == 1) {
      // set random strategy at first round
      setStrategy(new RandomStrategy());
    } else if (this.round == 4) {
      // set average strategy at fourth round
      setStrategy(new AverageStrategy(humanHistory));
    }
  }

}
