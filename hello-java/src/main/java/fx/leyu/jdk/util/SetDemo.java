package fx.leyu.jdk.util;

import java.util.HashSet;

public class SetDemo {

    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            set.add(i);
        }

        HashSet<Integer> removeSet = new HashSet<>();
        for (int i = 0; i < 10; i += 2) {
            removeSet.add(i);
        }

        set.removeAll(removeSet);

        for (int key : set) {
            System.out.println(key);
        }
    }

}
