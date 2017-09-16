package fx.leyu.learn.junit4;

public enum MeterType {
    METER(100),
    CENTIMETER(1);
    
    private final long base;
    
    private MeterType(long base) {
        this.base = base;
    }

    public long getBase() {
        return base;
    }

}
