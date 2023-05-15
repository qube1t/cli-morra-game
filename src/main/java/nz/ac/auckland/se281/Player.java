package nz.ac.auckland.se281;

import java.util.ArrayList;

public abstract class Player {
    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
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

    public abstract int[] play(ArrayList<ArrayList<Integer>> reg);
}
