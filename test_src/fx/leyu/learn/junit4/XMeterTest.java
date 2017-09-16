package fx.leyu.learn.junit4;

import org.junit.Assert;
import org.junit.Test;

public class XMeterTest {
    
    @Test
    public void testLengthForMeter() {
        XMeter one = new XMeter(MeterType.METER, 1);
        XMeter other = new XMeter(MeterType.METER, 1);
        XMeter another = new XMeter(MeterType.METER, 2);
        Assert.assertTrue(one.lengthEquals(other));
        Assert.assertFalse(one.lengthEquals(another));
    }
    
    @Test
    public void testLengthForCentimeter() {
        XMeter one = new XMeter(MeterType.CENTIMETER, 1);
        XMeter other = new XMeter(MeterType.CENTIMETER, 1);
        XMeter another = new XMeter(MeterType.CENTIMETER, 2);
        Assert.assertTrue(one.lengthEquals(other));
        Assert.assertFalse(one.lengthEquals(another));
    }
    
    @Test
    public void testLengthForCentimeterAndMeter() {
        XMeter one = new XMeter(MeterType.METER, 1);
        XMeter other = new XMeter(MeterType.CENTIMETER, 100);
        XMeter another = new XMeter(MeterType.CENTIMETER, 200);
        Assert.assertTrue(one.lengthEquals(other));
        Assert.assertFalse(one.lengthEquals(another));
    }

}
