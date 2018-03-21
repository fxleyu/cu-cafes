package fx.leyu.learn.junit4;

public enum MeterType {
    METER(100, "m"),
    DECIMETER(10, "dm"),
    CENTIMETER(1, "cm");
    
    private final long base;
    private final String description;
    
    MeterType(long base, String description) {
        this.base = base;
        this.description = description;
    }

    public long getBase() {
        return base;
    }

    public String getString() {
        return description;
    }

    public static String getDescription(long baseValue) {
        StringBuilder result = new StringBuilder();
        for(MeterType type : MeterType.values()) {
            long value = baseValue / type.base;
            baseValue %= type.base;
            if (value != 0L) {
                result.append(value).append(type.description);
            }
        }
        return result.toString();
    }

}
