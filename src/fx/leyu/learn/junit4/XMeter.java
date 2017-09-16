package fx.leyu.learn.junit4;

public class XMeter {
    private final MeterType type;
    private final long value;
    private final long baseValue;

    public XMeter(MeterType type, long value) {
        this.type = type;
        this.value = value;
        this.baseValue = type.getBase() * value;
    }

    public boolean lengthEquals(XMeter other) {
        if (other == null) {
            return false;
        }
        
        return this.baseValue == other.baseValue;
    }

}
