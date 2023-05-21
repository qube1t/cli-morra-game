package nz.ac.auckland.se281.aimodes;

import nz.ac.auckland.se281.Ai;
import nz.ac.auckland.se281.strategies.RandomStrategy;

public class EasyAi extends Ai {

  public EasyAi(String name) {
    super(name);
  }

  @Override
  protected void checkStrategy() {
    if (this.round == 1)
      // strategy set to random strategy at first round
      setStrategy(new RandomStrategy());
  }

}
