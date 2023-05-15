package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.aiModes.easyAI;

public class AIModesFactory {
    public static AI getAIMode(Difficulty mode){
        String nameAI = "Jarvis";
        switch (mode) {
            case EASY:
                return new easyAI(nameAI);
            // case "medium":
            //     return new mediumAI();
            // case "hard":
            //     return new hardAI();
            // case "master":
            //     return new masterAI();
            default:
                return null;
        }
    }
}
