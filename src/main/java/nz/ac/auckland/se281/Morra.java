package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;
import java.util.ArrayList;

public class Morra {

  private int roundState;
  private AI ai;
  private Human human;
  private ArrayList<ArrayList<Integer>> history;
  private int pointsToWin;

  public Morra() {
    roundState = -1;
    history = new ArrayList<ArrayList<Integer>>();
  }

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    System.out.println("Welcome " + options[0] + "!");
    human = new Human(options[0]);
    ai = AIModesFactory.getAIMode(difficulty);
    this.pointsToWin = pointsToWin;

    history.add(new ArrayList<Integer>());
    history.add(new ArrayList<Integer>());

    roundState = 0;
  }

  private int[] conductPlayerRound(Player player) {
    int[] play = player.play(history);
    int fingers = play[0];
    int sum = play[1];

    MessageCli.PRINT_INFO_HAND.printMessage(player.getName(), Integer.toString(fingers), Integer.toString(sum));

    return play;
  }

  private void getRoundResult(int[] humanResult, int[] aiResult) {
    int humanFingers = humanResult[0];
    int humanSum = humanResult[1];
    int aiFingers = aiResult[0];
    int aiSum = aiResult[1];

    if (humanFingers + aiFingers == humanSum && humanSum != aiSum) {
      human.addScore();
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
    } else if (humanFingers + aiFingers == aiSum && humanSum != aiSum) {
      ai.addScore();
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    }
  }

  private void setRegistry(int[] humanResult, int[] aiResult) {
    int humanFingers = humanResult[0];
    int aiFingers = aiResult[0];
    int[] fingers = {humanFingers, aiFingers};

    for (int i= 0; i<=1; i++){
      history.get(i).add(fingers[i]);
    }
  }

  public void play() {
    if (roundState == -1) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
    // while (round <)
    this.roundState++;
    MessageCli.START_ROUND.printMessage(Integer.toString(roundState));
    MessageCli.ASK_INPUT.printMessage();

    int[] humanResult = this.conductPlayerRound(human);
    
    int[] aiResult = this.conductPlayerRound(ai);
    
    getRoundResult(humanResult, aiResult);
    setRegistry(humanResult, aiResult);
    checkGameResult();

  }

  private void checkGameResult() {
    if (human.getScore() == pointsToWin) {
      MessageCli.END_GAME.printMessage(human.getName(), Integer.toString(roundState));
      roundState = -1;
    } else if (ai.getScore() == pointsToWin) {
      MessageCli.END_GAME.printMessage(ai.getName(), Integer.toString(roundState));
      roundState = -1;
    }
  }

  public void showStats() {
    if (roundState == -1) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
    MessageCli.PRINT_PLAYER_WINS.printMessage(human.getName(), Integer.toString(human.getScore()), Integer.toString(pointsToWin- human.getScore()));
    MessageCli.PRINT_PLAYER_WINS.printMessage(ai.getName(), Integer.toString(ai.getScore()), Integer.toString(pointsToWin- ai.getScore()));
  }
}
