package fx.leyu.other.y16.d0516;

class SubClassTest {
    public static void main(String[] args) {
        new SubClassTest().father.doSomething();
    }

    BaseFather father = new BaseFather() {
        @Override
        public void doSomething() {
            getName();
        }
    };
    public void getName() {
        System.out.println("SubClassTest");
    }
}

abstract class BaseFather {
    abstract public void doSomething();
    public void getName(){
        System.out.println("Father");
    }
}
