package fx.leyu.jdk.lang.reflect;

public class MethodTestClass {
    public String publicString;
    private String privateString;
    
    public void print(int a, int b) {
        System.out.println("public void print " + (a+b));
    }
    
    private void print(int a, int b, int c) {
        System.out.println("private void print " + (a + b + c));
    }

}
