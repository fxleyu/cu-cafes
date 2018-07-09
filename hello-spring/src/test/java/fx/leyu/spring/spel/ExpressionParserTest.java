package fx.leyu.spring.spel;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.List;
import java.util.regex.Matcher;

public class ExpressionParserTest {
    static ExpressionParser parser = new SpelExpressionParser();

    @Test
    public void testString() {
        Expression expression = parser.parseExpression("'Hello world!'");
        String value = expression.getValue(String.class);
        Assert.assertEquals("Hello world!", value);
    }

    @Test
    public void testStringWithDifferentPrefixAndSuffix() {
        Expression expression = parser.parseExpression("_'Hello world!'_",
                new TemplateParserContext("_", "_"));
        String value = expression.getValue(String.class);
        Assert.assertEquals("Hello world!", value);
    }

    @Test
    public void testMethod() {
        Expression expression = parser.parseExpression("'Hello world!'.toUpperCase()");
        String value = expression.getValue(String.class);
        Assert.assertEquals("HELLO WORLD!", value);
    }

    @Test
    public void testConstructor() {
        Expression expression = parser.parseExpression("new String('Hello world!')");
        String value = expression.getValue(String.class);
        Assert.assertEquals("Hello world!", value);
    }

    @Test
    public void testStaticMethod() {
        Expression expression = parser.parseExpression("T(java.lang.Math).PI");
        double pi = expression.getValue(double.class);
        Assert.assertEquals(Math.PI, pi, 0.00000001);
    }

    @Test
    public void testVariableRegister() {
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setVariable("message", "Hello world!");
        String value = parser.parseExpression("#message").getValue(context, String.class);
        Assert.assertEquals("Hello world!", value);
    }

    @Test
    public void testRootVariableRegister() {
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setRootObject(new MyBean());
        Assert.assertEquals(MyBean.class,
                parser.parseExpression("#root").getValue(context).getClass());
    }

    @Test
    public void testSystemProperties() {
        GenericApplicationContext context = new GenericApplicationContext();
        //Assert.assertEquals("cn",
        //        parser.parseExpression("@systemProperties['user.language']").getValue());
    }

    @Test
    public void testList() {
        List<Integer> list = parser.parseExpression("{1,2,3}").getValue(List.class);
        List<List<Integer>> lists = parser.parseExpression("{{1,2},{3,4},{5,6}}").getValue(List.class);
        Assert.assertEquals(list.size(), lists.size());
    }

    @Test
    public void testFunctionRegistered() throws NoSuchMethodException {
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.registerFunction("capitalize",
                StringUtils.class.getDeclaredMethod("capitalize", new Class[]{String.class}));

        String value = parser.parseExpression("#capitalize('hello')").getValue(context, String.class);
        Assert.assertEquals("Hello", value);
    }

    @Test
    public void testRelationalOperator() {
        Assert.assertTrue(parser.parseExpression("1 <2").getValue(Boolean.class));
        Assert.assertTrue(parser.parseExpression("1 lt 2").getValue(Boolean.class));
        Assert.assertTrue(parser.parseExpression("1 ne 3").getValue(Boolean.class));
    }

    @Test
    public void testArithmeticOperator() {
        Assert.assertEquals((Integer)3, parser.parseExpression("1 +2").getValue(Integer.class));
        Assert.assertEquals((Integer)1, parser.parseExpression("3 % 2").getValue(Integer.class));
    }

    @Test
    public void testLogicalOperator() {
        Assert.assertTrue(parser.parseExpression("true && true").getValue(Boolean.class));
        Assert.assertTrue(parser.parseExpression("true || false").getValue(Boolean.class));
        Assert.assertTrue(parser.parseExpression("true or false").getValue(Boolean.class));
        Assert.assertTrue(parser.parseExpression("3 between {2,4}").getValue(Boolean.class));
        Assert.assertTrue(parser.parseExpression("'WORLD' instanceof T(String)").getValue(Boolean.class));

        Assert.assertFalse(parser.parseExpression("5 between {2,4}").getValue(Boolean.class));
    }

    @Test
    public void testMatchesOperator() {
        Assert.assertTrue(parser.parseExpression("'world' matches '[a-z]{5}'").getValue(Boolean.class));
    }
}
