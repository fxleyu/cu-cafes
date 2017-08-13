package fx.leyu.leetcode.contest.weeklycontest4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Problem399 {

    public static void main(String[] args) {
        String[][] equations ={ {"a", "b"}, {"b", "c"} };
        double[] values = {2.0, 3.0};
        String[][] query = { {"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"} };
        double[] value = new Problem399().calcEquation(equations, values, query);
        for (double x : value) {
            System.out.println(x);
        }

    }
    
    public double[] calcEquation(String[][] equations, double[] values, String[][] query) {
        Map<String, Map<String, Double>> map = init(equations, values);
        double[] result = new double[query.length];
        for (int i = 0; i < query.length; i++) {
            result[i] = queryValue(query[i], map);
        }
        return result;
    }

    private Map<String, Map<String, Double>> init(String[][] equations, double[] values) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for(int i = 0; i< values.length; i++) {
            mapStringToMap(map, equations[i][1], equations[i][0], 1 / values[i]);
            mapStringToMap(map, equations[i][0], equations[i][1], values[i]);
        }
        return map;
    }

    private void mapStringToMap(Map<String, Map<String, Double>> map, String key, String string, double d) {
        if (map.containsKey(key)) {
            Map<String, Double> value = map.get(key);
            value.put(string, d);
        } else {
            Map<String, Double> value = new HashMap<>();
            value.put(string, d);
            map.put(key, value);
        }
    }


    private double queryValue(String[] strings, Map<String, Map<String, Double>> map) {
        String start = strings[0];
        String end = strings[1];
        
        Queue<Pair> queue = initQueue(start, map); 
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if (pair.string.equals(end)) {
                return pair.d;
            }
            
            addQueue(queue, pair, map);
        } 
        
        return -1.0;
    }

    private void addQueue(Queue<Pair> queue, Pair pair, Map<String, Map<String, Double>> map) {
        if (!map.containsKey(pair.string)) {
            return;
        }
        
        Map<String, Double> value = map.get(pair.string);
        for (String key : value.keySet()) {
            if (!pair.set.contains(key)) {
                Pair temp = new Pair(key, value.get(key)*pair.d);
                temp.set = new HashSet<>();
                temp.set.addAll(pair.set);
                temp.set.add(key);
                queue.add(temp);
            }
        }
    }

    private Queue<Pair> initQueue(String start, Map<String, Map<String, Double>> map) {
        Queue<Pair> queue =new LinkedList<>();
        if (!map.containsKey(start)) {
            return queue;
        }

        Map<String, Double> value = map.get(start);
        for (String key : value.keySet()) {
            queue.add(new Pair(key, value.get(key)));
        }
        return queue;
    }

    class Pair {
        public double d;
        public String string;
        public Set<String> set = new HashSet<>();
        
        public Pair(String s, double d) {
            string = s;
            this.d = d;
        }

        public Object set() {
            // TODO Auto-generated method stub
            return null;
        }
    }

}
