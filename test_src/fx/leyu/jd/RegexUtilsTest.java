package fx.leyu.jd;

import org.junit.Assert;
import org.junit.Test;

public class RegexUtilsTest {

    @Test
    public void isABPatternTestForTrue() {
        Assert.assertTrue(RegexUtils.isABPattern("abc-bac"));
    }
    
    @Test
    public void isABPatternTestForFalse() {
        Assert.assertFalse(RegexUtils.isABPattern("abcbac-"));
        Assert.assertTrue(RegexUtils.isABPattern("-ab-cbac-"));
    }
    
    @Test
    public void isABPatternTestOtherForTrue() {
        Assert.assertTrue(RegexUtils.isABPatternOther("a-b"));
        Assert.assertTrue(RegexUtils.isABPatternOther("a-bac"));
        Assert.assertTrue(RegexUtils.isABPatternOther("da-b"));
        Assert.assertTrue(RegexUtils.isABPatternOther("ddda-bdd"));
        Assert.assertTrue(RegexUtils.isABPatternOther("---"));
    }
    
    @Test
    public void isABPatternTestOtherForFalse() {
        Assert.assertFalse(RegexUtils.isABPatternOther("-"));
        Assert.assertFalse(RegexUtils.isABPatternOther("a-"));
        Assert.assertFalse(RegexUtils.isABPatternOther("-c"));
        Assert.assertFalse(RegexUtils.isABPatternOther("abcbac-"));
        Assert.assertTrue(RegexUtils.isABPatternOther("-abcbac"));
    }
    
    

}
