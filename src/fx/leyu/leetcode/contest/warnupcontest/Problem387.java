package fx.leyu.leetcode.contest.warnupcontest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem387 {

    public static void main(String[] args) {
        System.out.println(new Problem387().firstUniqChar("loveleetcode"));
        System.out.println(new Problem387().firstUniqChar("leetcode"));
    }
    
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i< s.length(); i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        
        for(int i=0; i< s.length(); i++) {
            char ch = s.charAt(i);
            if (map.get(ch).equals(1)) {
                return i;
            }
        }
        return -1;
    }
}
