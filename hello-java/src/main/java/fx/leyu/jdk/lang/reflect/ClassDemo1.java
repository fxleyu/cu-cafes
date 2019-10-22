package fx.leyu.jdk.lang.reflect;

public class ClassDemo1 {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Foo foo1 = new Foo();
        
        Class<Foo> c1 = Foo.class;
        Class c2 = foo1.getClass();
        Class c3 = Class.forName("fx.leyu.lang.reflect.Foo"); // throw Exception
        System.out.println(c1 == c2); // true
        System.out.println(c1 == c3); // true
        
        // 被用于动态加载
        Foo foo2 = c1.newInstance();//newInstance(); // throw Exception
        foo2.print();
    }

}

class Foo {
    void print() {
        System.out.println("Foo print");
    }
}
