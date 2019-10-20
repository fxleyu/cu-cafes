package fx.leyu.jdk.lang.enums;

/**
 * @author fxleyu
 */
public enum Operation {
    PLUS {
        @Override
        long apply(long x, long y) {
            return x + y;
        }
    },
    MINUS {
        @Override
        long apply(long x, long y) {
            return x - y;
        }
    },
    TIMES {
        @Override
        long apply(long x, long y) {
            return x * y;
        }
    },
    DIVIDE {
        @Override
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
