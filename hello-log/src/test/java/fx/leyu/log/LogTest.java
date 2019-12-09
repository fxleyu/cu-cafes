package fx.leyu.log;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fxleyu
 */
public class LogTest {
    private static Logger LOGGER;

    @BeforeClass
    public static void test() {
        System.setProperty("log4j.configurationFile", "log4j2-test.xml");
        LOGGER = LoggerFactory.getLogger(LogTest.class);
    }

    @Test
    public void testLog() {
        LOGGER.info("hello world");
    }
}
