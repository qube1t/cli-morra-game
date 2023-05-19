package nz.ac.auckland.se281.aiModes;

import java.util.ArrayList;

import nz.ac.auckland.se281.AI;
import nz.ac.auckland.se281.strategies.RandomStrategy;
import nz.ac.auckland.se281.strategies.TopStrategy;

public class HardAI extends AI {

  public HardAI(String name, ArrayList<ArrayList<Integer>> history) {
    super(name);
    this.humanHistory = history.get(0);
  }

  @Override
  protected void checkStrategy() {
    if (this.round == 1) {
      this.strategy = new RandomStrategy();
    } else if (this.round == 4) {
      ArrayList<Integer> humanInputs = humanHistory;
      this.strategy = new TopStrategy(humanInputs);
    }
  }

}
