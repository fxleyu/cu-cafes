package fx.leyu.leetcode.top101to150.problem146;

import java.util.*;

class LRUCache {
    private Map<Integer, Integer> map;
    private LinkedList<Integer> accessList;
    private final int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        accessList = new LinkedList<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer value = map.get(key);
        if (value == null) {
            return -1;
        }

        accessList.remove(Integer.valueOf(key));
        accessList.addFirst(key);
        return value;
    }

    public void put(int key, int value) {
        if (capacity <= map.size() && !map.containsKey(key)) {
            map.remove(accessList.removeLast());
        }

        if (map.containsKey(key)) {
            accessList.remove(Integer.valueOf(key));
        }

        map.put(key, value);
        accessList.addFirst(key);
    }
}