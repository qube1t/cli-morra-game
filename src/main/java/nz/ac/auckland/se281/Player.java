package nz.ac.auckland.se281;

public abstract class Player {
  private String name;
  private int score;
  protected int round;

  public Player(String name) {
    this.name = name;
    this.score = 0;
    this.round = 0;
  }

  public String getName() {
    return this.name;
  }

  public int getScore() {
    return this.score;
  }

  public void addScore() {
    this.score++;
  }

  public abstract int[] play();
}
