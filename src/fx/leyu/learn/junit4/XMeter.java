package fx.leyu.learn.junit4;

public class XMeter {
    private final MeterType type;
    private final long value;
    private final long baseValue;
    private final String description;

    public XMeter(MeterType type, long value) {
        this.type = type;
        this.value = value;
        this.baseValue = type.getBase() * value;
        this.description = MeterType.getDescription(this.baseValue);
    }

    public boolean equalsXMeter(XMeter other) {
        if (other == null) {
            return false;
        }
        
        return this.baseValue == other.baseValue;
    }
    
    public boolean equalsString(String description) {
        return this.description.equals(description);
    }
    
    @Override
    public String toString() {
        return value + type.getString();
    }

}
