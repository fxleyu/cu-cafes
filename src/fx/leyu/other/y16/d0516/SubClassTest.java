package fx.leyu.other.y16.d0516;

class SubClassTest {
    public static void main(String[] args) {
        new SubClassTest().father.doSomething();
    }
    Father father = new Father() {  
        @Override
        public void doSomething() {
            getName();
        }
    };
    public void getName() {
        System.out.println("SubClassTest");
    }
}
abstract class Father {
    abstract public void doSomething();
    public void getName(){
        System.out.println("Father");
    }
}
