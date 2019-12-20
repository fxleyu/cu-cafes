package fx.leyu.junit4.easymock;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author fxleyu
 */
public class HelloServiceMock {
    private HelloServe helloServe;

    @Before
    public void setUp() {
        helloServe = EasyMock.createMock("helloServeMock", HelloServe.class);
    }

    @Test
    public void test() {
        EasyMock.expect(helloServe.sayHello()).andReturn("Hello");

        EasyMock.replay(helloServe);

        Assert.assertEquals("Hello", helloServe.sayHello());
    }
}
