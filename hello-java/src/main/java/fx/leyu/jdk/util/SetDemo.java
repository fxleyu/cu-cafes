package fx.leyu.jdk.util;

import org.apache.commons.lang3.RandomUtils;

import java.util.HashSet;
import java.util.Random;

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

        //灰度跳转
        Integer ratio = 100;
        Random rand = new Random(System.currentTimeMillis()%100);//随机数种子
        int time = rand.nextInt(100); //随机数
        if (ratio <= time) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        int random = RandomUtils.nextInt(1, 101);
        int percentage = 100;
        System.out.println( random <= percentage);

        int percent = 100;
        double num = Math.random() * 100;
        System.out.println(num < percent);
    }

}
