package fx.leyu.jdk.function;

public abstract class PredicateForJdk7 {
    public abstract boolean test();

    public PredicateForJdk7 negate() {
        return new PredicateForJdk7() {
            @Override
            public boolean test() {
                return !PredicateForJdk7.this.test();
            }
        };
    }
}
