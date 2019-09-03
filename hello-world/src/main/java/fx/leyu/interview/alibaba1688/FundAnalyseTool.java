package fx.leyu.interview.alibaba1688;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;

/**
 * 基金分析工具类
 */
public class FundAnalyseTool {
    // TODO 实现最大回撤计算，返回百分比
    public static BigDecimal analyse(List<FundNetValue> netValues) {
        checkArgs(netValues);

        // max(1 - vj/vi) => 1 - min(vj/vi)
        BigDecimal min = BigDecimal.ONE; // only one FundNetValue case
        BigDecimal maxDenominator = netValues.get(0).getNetValue();
        for (FundNetValue fundNetValue : netValues) {
            maxDenominator = maxDenominator.max(fundNetValue.getNetValue());
            // TODO scale mode
            BigDecimal tempMin = fundNetValue.getNetValue().divide(maxDenominator, 10, RoundingMode.HALF_UP); // min(vj/vi)
            min = min.min(tempMin); // day(j)
        }

        return BigDecimal.ONE.subtract(min);
    }

    private static void checkArgs(List<FundNetValue> netValues) {
        if (Objects.isNull(netValues) || netValues.size() == 0) {
            throw new IllegalArgumentException("netValues cannot empty");
        }

        FundNetValue pre = null;
        for (FundNetValue fundNetValue : netValues) {
            if (Objects.isNull(fundNetValue)
                    || Objects.isNull(fundNetValue.getNetValue())
                    || Objects.isNull(fundNetValue.getNetValueDate())) {
                throw new IllegalArgumentException("netValue and netValue's field cannot empty");
            }
            if (pre != null && pre.getNetValueDate().getTime() >= fundNetValue.getNetValueDate().getTime()) {
                throw new IllegalArgumentException("netValues should be ordered");
            }
            pre = fundNetValue;
        }
    }
}