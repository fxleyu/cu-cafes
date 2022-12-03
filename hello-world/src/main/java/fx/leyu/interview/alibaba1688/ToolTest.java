package fx.leyu.interview.alibaba1688;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ToolTest {
    @Test
    public void test() {
        List<FundNetValue> input = new ArrayList<>();
        //12,12,21,15,27,16,21,22,25,20,16,17
        input.add(new FundNetValue(new Date(1L), new BigDecimal("12")));
        input.add(new FundNetValue(new Date(2L), new BigDecimal("12")));
        input.add(new FundNetValue(new Date(12L), new BigDecimal("21")));
        input.add(new FundNetValue(new Date(13L), new BigDecimal("15")));
        input.add(new FundNetValue(new Date(14L), new BigDecimal("27")));
        input.add(new FundNetValue(new Date(15L), new BigDecimal("16")));
        input.add(new FundNetValue(new Date(16L), new BigDecimal("21")));
        input.add(new FundNetValue(new Date(17L), new BigDecimal("22")));
        input.add(new FundNetValue(new Date(18L), new BigDecimal("25")));
        input.add(new FundNetValue(new Date(21L), new BigDecimal("20")));
        input.add(new FundNetValue(new Date(31L), new BigDecimal("16")));
        input.add(new FundNetValue(new Date(41L), new BigDecimal("17")));
        System.out.println(FundAnalyseTool.analyse(input));
    }
}
