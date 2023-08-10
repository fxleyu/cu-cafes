package fx.leyu.jdk.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * @author zhuzhihui
 */
public class VersionUtils {
    public static boolean aBiggerThanB(String aVersion, String bVersion) {
        if (StringUtils.isBlank(aVersion) || StringUtils.isBlank(bVersion)) {
            return false;
        }
        String[] aVersionNums = StringUtils.split(aVersion, ".");
        String[] bVersionNums = StringUtils.split(bVersion, ".");
        int min = NumberUtils.min(aVersionNums.length, bVersionNums.length);
        for (int i = 0; i < min; i++) {
            int a = NumberUtils.toInt(aVersionNums[0]);
            int b = NumberUtils.toInt(bVersionNums[0]);
            if (a == b) {
                continue;
            }
            return a > b;
        }
        return aVersionNums.length > bVersionNums.length;
    }

}
