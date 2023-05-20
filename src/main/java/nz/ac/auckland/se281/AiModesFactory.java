package nz.ac.auckland.se281;

import java.util.ArrayList;

import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.aiModes.EasyAI;
import nz.ac.auckland.se281.aiModes.HardAI;
import nz.ac.auckland.se281.aiModes.MasterAI;
import nz.ac.auckland.se281.aiModes.MediumAI;

public class AIModesFactory {
  public static AI getAIMode(String nameAI, Difficulty mode, ArrayList<ArrayList<Integer>> humanHistory) {

    // return different AI mode according to the difficulty
    switch (mode) {
      case EASY:
        return new EasyAI(nameAI);
      case MEDIUM:
        return new MediumAI(nameAI, humanHistory);
      case HARD:
        return new HardAI(nameAI, humanHistory);
      case MASTER:
        return new MasterAI(nameAI, humanHistory);
      default:
        return null;
    }
  }
}
