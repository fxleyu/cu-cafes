package fx.leyu.leetcode.top0101to0150.problem146;

import java.util.*;

class LRUCache {
    private final Map<Integer, Integer> map;
    private final LinkedList<Integer> accessList;
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
        if (map.containsKey(key)) {
            accessList.remove(Integer.valueOf(key));
        } else if (capacity <= map.size()) {
            map.remove(accessList.removeLast());
        }

        map.put(key, value);
        accessList.addFirst(key);
    }
}