package fx.leyu.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Supplier;

/**
 * @author fxleyu
 */
public class LogUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger("LOGGER");

    // 禁止初始化
    private LogUtils() {
    }

    public static void info(String format, Supplier<String> refer) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(format, refer.get());
        }
    }
}
