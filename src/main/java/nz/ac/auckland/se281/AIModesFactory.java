package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.aiModes.EasyAI;
import nz.ac.auckland.se281.aiModes.HardAI;
import nz.ac.auckland.se281.aiModes.MediumAI;

public class AIModesFactory {
    public static AI getAIMode(Difficulty mode){
        String nameAI = "Jarvis";
        switch (mode) {
            case EASY:
                return new EasyAI(nameAI);
            case MEDIUM:
                return new MediumAI(nameAI);
            case HARD:
                return new HardAI(nameAI);
            // case "master":
            //     return new masterAI();
            default:
                return null;
        }
    }
}
