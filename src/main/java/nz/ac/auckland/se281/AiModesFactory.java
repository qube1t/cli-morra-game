package nz.ac.auckland.se281;

import java.util.ArrayList;

import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.aimodes.EasyAi;
import nz.ac.auckland.se281.aimodes.HardAi;
import nz.ac.auckland.se281.aimodes.MasterAi;
import nz.ac.auckland.se281.aimodes.MediumAi;

public class AiModesFactory {
  public static Ai getAiMode(String nameAI, Difficulty mode, ArrayList<ArrayList<Integer>> humanHistory) {

    // return different AI mode according to the difficulty
    switch (mode) {
      case EASY:
        return new EasyAi(nameAI);
      case MEDIUM:
        return new MediumAi(nameAI, humanHistory);
      case HARD:
        return new HardAi(nameAI, humanHistory);
      case MASTER:
        return new MasterAi(nameAI, humanHistory);
      default:
        return null;
    }
  }
}
