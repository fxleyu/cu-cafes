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
        // https://www.logicbig.com/tutorials/misc/java-logging/slf4j-with-log4j2.html 参考
        LOGGER.info("hello world");
    }
}
