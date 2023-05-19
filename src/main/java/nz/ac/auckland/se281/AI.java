package nz.ac.auckland.se281;

import java.util.ArrayList;

public abstract class AI extends Player {
  public Strategy strategy;
  protected ArrayList<Integer> humanHistory;

  public AI(String name) {
    super(name);
  }

  protected abstract void checkStrategy();

  @Override
  public int[] play() {
    // round increased for checkStrategy
    round++;
    checkStrategy();
    return this.strategy.engage();
  }

}