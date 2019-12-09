package fx.leyu.log;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fxleyu
 */
public class LogTest {
    private static Logger LOGGER = LoggerFactory.getLogger(LogTest.class);

    @Test
    public void testLog() {
        LOGGER.info("hello world");
    }
}
