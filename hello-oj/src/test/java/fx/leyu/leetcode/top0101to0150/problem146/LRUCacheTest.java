package fx.leyu.leetcode.top0101to0150.problem146;

import org.junit.Assert;
import org.junit.Test;

public class LRUCacheTest {
    @Test
    public void test() {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

        cache.put(1, 1);
        cache.put(2, 2);
        Assert.assertEquals(1, cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        Assert.assertEquals(-1, cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        Assert.assertEquals(-1, cache.get(1));       // 返回 -1 (未找到)
        Assert.assertEquals(3, cache.get(3));       // 返回  3
        Assert.assertEquals(4, cache.get(4));       // 返回  4
    }
}
