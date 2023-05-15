package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;
import java.util.ArrayList;

public class Morra {

  private int round;
  private AI ai;
  private Human human;
  private ArrayList<ArrayList<Integer>> registry;

  public Morra() {
    round = -1;
    registry = new ArrayList<ArrayList<Integer>>();
  }

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    System.out.println("Welcome " + options[0] + "!");
    human = new Human(options[0]);
    ai = AIModesFactory.getAIMode(difficulty);

    registry.add(new ArrayList<Integer>());
    registry.add(new ArrayList<Integer>());

    round = 0;
  }

  private int[] conductPlayerTurn(Player player) {
    int[] play = player.play(registry);
    int fingers = play[0];
    int sum = play[1];


    // 0 is player; 1 is ai
    int index = player instanceof Human ? 0 : 1;
    registry.get(index).add(fingers);
    MessageCli.PRINT_INFO_HAND.printMessage(player.getName(), Integer.toString(fingers), Integer.toString(sum));

    return play;
  }

  public void play() {
    if (round == -1) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    this.round++;
    MessageCli.START_ROUND.printMessage(Integer.toString(round));
    MessageCli.ASK_INPUT.printMessage();

    int[] humanResult = this.conductPlayerTurn(human);
    int humanFingers = humanResult[0];
    int humanSum = humanResult[1];
    
    int[] aiResult = this.conductPlayerTurn(ai);
    int aiFingers = aiResult[0];
    int aiSum = aiResult[1];

    if (humanFingers + aiFingers == humanSum) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
    } else if (humanFingers + aiFingers == aiSum) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    }

  }

  public void showStats() {}
}
