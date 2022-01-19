package fx.leyu.jdk.lang;


//店铺 A 可以的优惠券组合为[A1、A2、A3]、[A1、A2]、[A2、A3]、[A3]
//    店铺 B 可以的优惠券组合为[B1、B2]、[B1]、[B2]
//    店铺 C 可以的优惠券组合为[C1、C2、C3]、[C1、C2]、[C2]
//    店铺 D 可以的优惠券组合为[D1、D2、D3、D4]、[D1、D2]、[D3、D4]
//    店铺 E 可以的优惠券组合为[E1、E2、E3]、[E3、E4]、[ E2、E3]、[E3]
//
//    每种券至少含有 selectedId、discountAmount 两个字段。selectedId 标识唯一券、discountAmount 表示 券优惠金额
//    求：TOP 5 的最佳优惠券组合的优惠金额、不满 5 中求全部组合的优惠金额
//
//    例如：
//    店铺 A 的优惠券组合 [A1 - 6、A2 - 6、A3 - 4]、[A1 - 6 、A2 - 6]、[A2 - 6、A3 - 4]、[A3 - 4]
//    店铺 B 可以的优惠券组合为[B1- 100、B2 - 100]、[B1 - 100]、[B2 - 100]
//    其中 A1 - 6  表示  selectedId 是 A1，discountAmount 是 6。
//
//    如果只有这两个店铺，那么 TOP 5 最佳组合是
//    [A1、A2、A3、B1、B2]（优惠216）、 [A1、A2、B1、B2]（优惠212）、
//    [A2、A3、B1、B2]（优惠210）、[A3、B1、B2]（优惠204）、
//    [A1、A2、A3、B1]（优惠116）或者 [A1、A2、A3、B2]（优惠116）
//    其输出为 216、212、210、204、116。

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class SelectBestCoupons {

    static class Shop {
        private String selectedId;
        private BigDecimal discountAmount;

        public Shop(String selectedId, BigDecimal discountAmount) {
            this.selectedId = selectedId;
            this.discountAmount = discountAmount;
        }
    }

    static class Coupons {
        private List<Shop> shopList;
        private BigDecimal couponsTotalAmount;

        public Coupons(List<Shop> shopList, BigDecimal couponsTotalAmount) {
            this.shopList = shopList;
            this.couponsTotalAmount = couponsTotalAmount;
        }
    }

    static class FinalResult {
        private List<Coupons> couponsList;
        private BigDecimal discountAmount;

        public BigDecimal getDiscountAmount() {
            return discountAmount;
        }

        public void setDiscountAmount(BigDecimal discountAmount) {
            this.discountAmount = discountAmount;
        }

        public List<Coupons> getCouponsList() {
            return couponsList;
        }

        public void setCouponsList(List<Coupons> couponsList) {
            this.couponsList = couponsList;
        }
    }

    public static void main(String[] args) {
        Shop shopA1 = new Shop("A1", new BigDecimal(6));
        Shop shopA2 = new Shop("A2", new BigDecimal(6));
        Shop shopA3 = new Shop("A3", new BigDecimal(4));

        List<Shop> csA1 = new ArrayList<>();
        csA1.add(shopA1);
        csA1.add(shopA2);
        csA1.add(shopA3);
        BigDecimal couponsTotalAmountA1 = shopA1.discountAmount.add(shopA2.discountAmount).add(shopA3.discountAmount);
        Coupons couponsShopA1 = new Coupons(csA1, couponsTotalAmountA1);

        List<Shop> csA2 = new ArrayList<>();
        csA2.add(shopA1);
        csA2.add(shopA2);
        BigDecimal couponsTotalAmountA2 = shopA1.discountAmount.add(shopA2.discountAmount);
        Coupons couponsShopA2 = new Coupons(csA2, couponsTotalAmountA2);

        List<Shop> csA3 = new ArrayList<>();
        csA3.add(shopA2);
        csA3.add(shopA3);
        BigDecimal couponsTotalAmountA3 = shopA2.discountAmount.add(shopA3.discountAmount);
        Coupons couponsShopA3 = new Coupons(csA3, couponsTotalAmountA3);

        List<Shop> csA4 = new ArrayList<>();
        csA4.add(shopA3);
        Coupons couponsShopA4 = new Coupons(csA4, shopA3.discountAmount);

        Shop shopB1 = new Shop("B1", new BigDecimal(100));
        Shop shopB2 = new Shop("shopB2", new BigDecimal(100));

        List<Shop> csB1 = new ArrayList<>();
        csB1.add(shopB1);
        csB1.add(shopB2);
        BigDecimal couponsTotalAmountB1 = shopB1.discountAmount.add(shopB2.discountAmount);
        Coupons couponsShopB1 = new Coupons(csB1, couponsTotalAmountB1);

        List<Shop> csB2 = new ArrayList<>();
        csB2.add(shopB1);
        Coupons couponsShopB2 = new Coupons(csB2, shopB1.discountAmount);

        List<Shop> csB3 = new ArrayList<>();
        csB3.add(shopB2);
        Coupons couponsShopB3 = new Coupons(csB3, shopB2.discountAmount);

        List<Coupons> couponsAList = new ArrayList<>();
        couponsAList.add(couponsShopA1);
        couponsAList.add(couponsShopA2);
        couponsAList.add(couponsShopA3);
        couponsAList.add(couponsShopA4);

        List<Coupons> couponsBList = new ArrayList<>();
        couponsBList.add(couponsShopB1);
        couponsBList.add(couponsShopB2);
        couponsBList.add(couponsShopB3);
        List<FinalResult> finalResultList = calculate(couponsAList, couponsBList);
        for(FinalResult finalResult: finalResultList){
            System.out.println(finalResult.getDiscountAmount());
        }
    }

    public static List<FinalResult> calculate(List<Coupons> couponsAList, List<Coupons> couponsBList) {
        if (null == couponsAList || couponsAList.size() <= 0) {
            return new ArrayList<>();
        }

        List<FinalResult> finalResultList = new ArrayList<>();
        for (Coupons couponsA: couponsAList) {
            for (Coupons couponsB: couponsBList) {
                FinalResult finalResult = new FinalResult();
                List<Coupons> coupons = new ArrayList<>();
                finalResult.setCouponsList(coupons);
                coupons.add(couponsA);
                coupons.add(couponsB);
                BigDecimal amount = couponsA.couponsTotalAmount.add(couponsB.couponsTotalAmount);
                finalResult.setDiscountAmount(amount);
                finalResultList.add(finalResult);
            }
        }
        finalResultList.sort(Comparator.comparing(FinalResult::getDiscountAmount).reversed());
        return finalResultList;
    }

}
