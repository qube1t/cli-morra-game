package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  private int round;
  private String playerName;
  private AI ai;

  public Morra() {
    round = -1;
  }

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    System.out.println("Welcome " + options[0] + "!");
    playerName = options[0];
    ai = AIModesFactory.getAIMode(difficulty);
    round = 0;
  }

  public void play() {
    if (round == -1) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    this.round++;
    MessageCli.START_ROUND.printMessage(Integer.toString(round));
    MessageCli.ASK_INPUT.printMessage();

    int fingers = 0;
    int sum = 0;
    int trySuccess = 0;
    do {
      String input = Utils.scanner.nextLine();
      String[] inputArray = input.split(" ");

      try{
        fingers = Integer.parseInt(inputArray[0]);
        sum = Integer.parseInt(inputArray[1]);

        if (fingers >= 1 && fingers <= 5 && sum >= 1 && sum <= 10)
          trySuccess = 1;
          else
            MessageCli.INVALID_INPUT.printMessage();
      } catch (Exception e) {
        MessageCli.INVALID_INPUT.printMessage();
      }
    } while (trySuccess == 0);

    MessageCli.PRINT_INFO_HAND.printMessage(playerName, Integer.toString(fingers), Integer.toString(sum));
    
    int[] aiPlay = ai.play();

    int aiFingers = aiPlay[0];
    int aiSum = aiPlay[1];
    MessageCli.PRINT_INFO_HAND.printMessage("Jarvis", Integer.toString(aiFingers), Integer.toString(aiSum));

    if (fingers + aiFingers == sum) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
    } else if (fingers + aiFingers == aiSum) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    }

  }

  public void showStats() {}
}
