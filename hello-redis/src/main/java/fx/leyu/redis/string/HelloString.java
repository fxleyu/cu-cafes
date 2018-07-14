package fx.leyu.redis.string;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class HelloString {
    public static void main(String[] args) {
        JedisPool pool = new JedisPool(new JedisPoolConfig(), "192.168.199.120");
        try (Jedis jedis = pool.getResource()) {
            jedis.set("hello", "world");
        }
    }
}
