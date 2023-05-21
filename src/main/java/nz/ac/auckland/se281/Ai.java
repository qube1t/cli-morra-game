package nz.ac.auckland.se281;

import java.util.ArrayList;

public abstract class Ai extends Player {
  protected Strategy strategy;
  protected ArrayList<Integer> humanHistory;

  public Ai(String name) {
    super(name);
  }

  protected abstract void checkStrategy();

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  @Override
  public int[] play() {
    // round increased for checkStrategy
    round++;

    // check if strategy needs to be changed
    checkStrategy();

    // return the fingers and sum from the strategy
    return this.strategy.engage();
  }

}
