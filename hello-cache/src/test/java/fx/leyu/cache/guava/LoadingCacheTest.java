package fx.leyu.cache.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.concurrent.ExecutionException;

public class LoadingCacheTest {
    @Test
    public void test() throws ExecutionException {
        LoadingCache<String, String> loadingCache = CacheBuilder.newBuilder().build(new CacheLoader<String, String>() {
            @Override
            @ParametersAreNonnullByDefault
            public String load(String key) throws Exception {
                return key + "'s value is missing";
            }
        });

        String value = loadingCache.get("key");
        Assert.assertEquals("key's value is missing", value);
    }
}
