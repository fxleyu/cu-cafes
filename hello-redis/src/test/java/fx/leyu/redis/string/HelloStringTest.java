package fx.leyu.redis.string;

import org.junit.Assert;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class HelloStringTest {
    @Test
    public void testSetAndGet() {
        String key = "hello";
        String value = "world";
        try (JedisPool pool = new JedisPool(new JedisPoolConfig(), "192.168.0.101")) {
            try (Jedis jedis = pool.getResource()) {
                long start = System.nanoTime();
                jedis.set(key, value);
                long end = System.nanoTime();
                System.out.println("Redis String set " + (end - start) / 1000000);
            }
            try (Jedis jedis = pool.getResource()) {
                long start = System.nanoTime();
                String actualValue = jedis.get(key);
                long end = System.nanoTime();
                System.out.println("Redis String get " + (end - start) / 1000000);
                Assert.assertEquals(value, actualValue);
            }
        }
    }
}
