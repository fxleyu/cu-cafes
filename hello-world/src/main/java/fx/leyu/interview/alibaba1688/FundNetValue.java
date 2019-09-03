package fx.leyu.interview.alibaba1688;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 基金净值对象
 */
public class FundNetValue {
    /**
     * 净值日期
     */
    private Date netValueDate;
    /**
     * 净值
     */
    private BigDecimal netValue;

    /**
     * 构造函数
     */
    public FundNetValue(Date netValueDate, BigDecimal netValue) {
        this.netValueDate = netValueDate;
        this.netValue = netValue;
    }

    /**
     * getter for netValueDate
     */
    public Date getNetValueDate() {
        return this.netValueDate;
    }

    /**
     * setter for netValueDate
     */
    public void setNetValueDate(Date netValueDate) {
        this.netValueDate = netValueDate;
    }

    /**
     * getter for netValue
     */
    public BigDecimal getNetValue() {
        return this.netValue;
    }

    /**
     * setter for netValue
     */
    public void setNetValue(BigDecimal netValue) {
        this.netValue = netValue;
    }
}
