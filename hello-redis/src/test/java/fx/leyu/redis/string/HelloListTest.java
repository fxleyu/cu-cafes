package fx.leyu.redis.string;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author fxleyu
 */
public class HelloListTest {
    @Test
    public void testSetAndGet() {
        String key = "L_key";
        String value = "world";
        try (JedisPool pool = new JedisPool(new JedisPoolConfig(), "192.168.0.101")) {
            try (Jedis jedis = pool.getResource()) {
                long start = System.nanoTime();
                jedis.lpush(key, value, "tesk");
                long end = System.nanoTime();
                System.out.println("Redis List set " + (end - start) / 1000000);
            }
            try (Jedis jedis = pool.getResource()) {
                long start = System.nanoTime();
                String actualValue = jedis.lpop(key);
                long end = System.nanoTime();
                System.out.println("Redis List get " + (end - start) / 1000000);
            }
        }
    }
}
