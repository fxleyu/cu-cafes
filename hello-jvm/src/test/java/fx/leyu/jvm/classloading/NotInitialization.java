package fx.leyu.jvm.classloading;

import org.junit.Test;

public class NotInitialization {
    @Test
    public void test() {
        /**
         * 被动使用类字段演示一：
         * 通过子类引用父类的静态字段，不会导致类初始化
         */
        System.out.println(SubClass.value);
    }

    @Test
    public void test2() {
        /**
         * 被动使用类字段演示二：
         * 通过数组定义来引用类，不会触发此类的初始化
         */
        SuperClass[] sca = new SuperClass[10];  // 导致 SuperClass 加载，未有初始化
    }

    @Test
    public void test3() {
        /**
         * 被动使用类字段演示三：
         * 常量在编译阶段会存入调用类的常量池中，本质上并没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化
         */
        System.out.println(ConstClass.HELLO_WORLD); // ConstClass 不会被加载
    }
}
