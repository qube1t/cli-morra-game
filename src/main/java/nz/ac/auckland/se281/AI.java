package nz.ac.auckland.se281;

import java.util.ArrayList;

public abstract class AI extends Player{
    public Strategy strategy;
    protected int count;

    public AI(String name) {
        super(name);
    }

    protected abstract void checkStrategy(ArrayList<ArrayList<Integer>> reg);

    @Override
    public int[] play(ArrayList<ArrayList<Integer>> reg) {
        count++;
        checkStrategy(reg);
        return this.strategy.engage();
    }

}