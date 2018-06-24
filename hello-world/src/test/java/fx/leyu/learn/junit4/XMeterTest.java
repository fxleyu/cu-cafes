package fx.leyu.learn.junit4;

import org.junit.Assert;
import org.junit.Test;

public class XMeterTest {
    
    @Test
    public void testLengthForMeter() {
        XMeter one = new XMeter(MeterType.METER, 1);
        XMeter other = new XMeter(MeterType.METER, 1);
        XMeter another = new XMeter(MeterType.METER, 2);
        Assert.assertTrue(one.equalsXMeter(other));
        Assert.assertFalse(one.equalsXMeter(another));
    }
    
    @Test
    public void testLengthForCentimeter() {
        XMeter one = new XMeter(MeterType.CENTIMETER, 1);
        XMeter other = new XMeter(MeterType.CENTIMETER, 1);
        XMeter another = new XMeter(MeterType.CENTIMETER, 2);
        Assert.assertTrue(one.equalsXMeter(other));
        Assert.assertFalse(one.equalsXMeter(another));
    }
    
    @Test
    public void testLengthForCentimeterAndMeter() {
        XMeter one = new XMeter(MeterType.METER, 1);
        XMeter other = new XMeter(MeterType.CENTIMETER, 100);
        XMeter another = new XMeter(MeterType.CENTIMETER, 200);
        Assert.assertTrue(one.equalsXMeter(other));
        Assert.assertFalse(one.equalsXMeter(another));
    }
    
    @Test
    public void testLengthStringForMeter() {
        XMeter one = new XMeter(MeterType.METER, 1);
        Assert.assertTrue(one.equalsString("1m"));
    }
    
    @Test
    public void testLengthStringForCentimeterAndMeter() {
        XMeter one = new XMeter(MeterType.CENTIMETER, 100);
        Assert.assertTrue(one.equalsString("1m"));
        Assert.assertFalse(one.equalsString("100cm"));
    }

}
