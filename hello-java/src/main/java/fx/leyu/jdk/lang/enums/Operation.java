package fx.leyu.jdk.lang.enums;

public enum Operation {
    PLUS {
        long apply(long x, long y) {
            return x + y;
        }
    },
    MINUS {
        long apply(long x, long y) {
            return x - y;
        }
    },
    TIMES {
        long apply(long x, long y) {
            return x * y;
        }
    },
    DIVIDE {
        long apply(long x, long y) {
            return x / y;
        }
    };

    abstract long apply(long x, long y);

    @Override
    public String toString() {
        return "Operation{}";
    }
}
