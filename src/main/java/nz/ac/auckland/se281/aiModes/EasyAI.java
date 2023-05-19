package nz.ac.auckland.se281.aiModes;

import nz.ac.auckland.se281.AI;
import nz.ac.auckland.se281.strategies.RandomStrategy;

public class EasyAI extends AI {

  public EasyAI(String name) {
    super(name);
  }

  @Override
  protected void checkStrategy() {
    if (this.round == 1)
      // strategy set to random strategy at first round
      this.strategy = new RandomStrategy();
  }

}
