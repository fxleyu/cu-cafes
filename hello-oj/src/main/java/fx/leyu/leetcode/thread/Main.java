package fx.leyu.leetcode.thread;

import fx.leyu.leetcode.thread.problem1114.Foo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author fxleyu
 */
public class Main {
    public static void main(String[] args) {
        final Foo foo = new Foo();
        Runnable first = () ->  {
            try {
                foo.first(()-> System.out.print("first"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable second = () ->  {
            try {
                foo.second(()-> System.out.print("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable third = () ->  {
            try {
                foo.third(()-> System.out.print("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Map<Integer, Runnable> map = new HashMap<>();
        map.put(1, first);
        map.put(2, second);
        map.put(3, third);

        print(new int[]{1,2,3}, map);
        System.out.println();
        print(new int[]{2,1,3}, map);
        System.out.println();
        print(new int[]{3,2,1}, map);
    }

    private static void print(int[] ints, Map<Integer, Runnable> map) {
        for (int i : ints) {
            Runnable runnable = map.get(i);
            if (Objects.nonNull(runnable)) {
                new Thread(runnable).start();
            }
        }
    }
}
