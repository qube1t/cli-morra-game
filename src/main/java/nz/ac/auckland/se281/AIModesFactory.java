package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.aiModes.easyAI;
import nz.ac.auckland.se281.aiModes.mediumAI;

public class AIModesFactory {
    public static AI getAIMode(Difficulty mode){
        String nameAI = "Jarvis";
        switch (mode) {
            case EASY:
                return new easyAI(nameAI);
            case MEDIUM:
                return new mediumAI(nameAI);
            // case "hard":
            //     return new hardAI();
            // case "master":
            //     return new masterAI();
            default:
                return null;
        }
    }
}
