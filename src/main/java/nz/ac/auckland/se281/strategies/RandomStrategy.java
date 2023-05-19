package nz.ac.auckland.se281.strategies;

import nz.ac.auckland.se281.Strategy;
import nz.ac.auckland.se281.Utils;

public class RandomStrategy implements Strategy {

  @Override
  public int[] engage() {
    // produce random number of fingers and sum
    int fingers = Utils.getRandomNumber(1, 5);
    int sum = Utils.getRandomNumber(fingers + 1, fingers + 5);

    return new int[] { fingers, sum };
  }

}
