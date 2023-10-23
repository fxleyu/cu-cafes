package fx.leyu.leetcode.contest.weeklycontest4;

import java.util.LinkedList;
import java.util.Queue;

public class Problem397 {

    public static void main(String[] args) {
        System.out.println(new Problem397().integerReplacement(7));
        System.out.println(new Problem397().integerReplacement(8));
        System.out.println(new Problem397().integerReplacement(2147483647));
        System.out.println(new Problem397().integerReplacement(1023));
        System.out.println(new Problem397().integerReplacement(1022));
        System.out.println(new Problem397().integerReplacement(1025));
    }
    
    
    public int integerReplacement(int n) {
        if (n < 0) {
            return -1;
        }
                
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(n, 0));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if (pair.value == 1) {
                return pair.sum;
            }
            addQueue(queue, pair);
        }
        
        return -1;
    }
    
    private void addQueue(Queue<Pair> queue, Pair pair) {
        if (pair.value % 2 == 0) {
            queue.add(new Pair((pair.value)/2, pair.sum+1));
        } else {
            queue.add(new Pair(pair.value - 1, pair.sum+1));
            queue.add(new Pair(pair.value + 1, pair.sum+1));
        }
        
    }

    class Pair {
        public long value;
        public int sum;
        
        public Pair(long n, int i) {
            value = n;
            sum = i;
        }
    } 
}
