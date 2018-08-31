package fx.leyu.jdk.util.concurrent.atomic;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {
    private static class User{
        private String name;
        private int age;
        public User(String name, int age) {
            this.age = age;
            this.name = name;
        }

        public String getName() {
            return name;
        }
        public int getAge() {
            return age;
        }
    }

    private static final AtomicReference<User> ATOMIC_REFERENCE = new AtomicReference<>();

    @Test
    public void testCompareAndSet() {
        User user = new User("fxleyu", 21);
        ATOMIC_REFERENCE.set(user);
        User update = new User("fxyuer", 18);
        ATOMIC_REFERENCE.compareAndSet(user, update);
        Assert.assertEquals("fxyuer", ATOMIC_REFERENCE.get().getName());
    }
}
