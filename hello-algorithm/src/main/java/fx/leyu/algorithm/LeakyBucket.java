package fx.leyu.algorithm;

// TODO
public class LeakyBucket {
    private double total = 0;
    private double limit = 1000;
    private double rate = 1;
    private double startTime;

    public LeakyBucket() {
        startTime = System.currentTimeMillis();
    }

    public boolean filter() {
        return false;
    }
}
