package nz.ac.auckland.se281;

public abstract class AI extends Player{
    public Strategy strategy;
    protected int count;

    public AI(String name) {
        super(name);
    }

    protected abstract void setStrategy();

    @Override
    public int[] play() {
        return this.strategy.engage();
    }

}