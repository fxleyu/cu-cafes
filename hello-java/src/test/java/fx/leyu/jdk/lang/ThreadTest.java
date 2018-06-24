package fx.leyu.jdk.lang;

import org.junit.Test;

public class ThreadTest {

    @Test
    public void testJoin() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread start");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("Thread stop!");
            }
        });
        thread.start();
        try {
            System.out.println("Join before");
            thread.join();
            System.out.println("Join end");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    /*
     * OUT: 
     * Join before
     * Thread start
     * Join end
     * Thread stop!
     */
    public static void main(String[] args) throws InterruptedException {
        new ThreadTest().testJoinWithArgs();
    }
    
    
    /*
     * OUT: 
     * Join before
     * Thread start
     * Join end
     */
    @Test
    public void testJoinWithArgs() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread start");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                    e.printStackTrace();
                } catch(Exception e) {
                    System.out.println(e);
                    e.printStackTrace();
                }
                System.out.println("Thread stop!");
            }
        });
        thread.start();
        try {
            System.out.println("Join before");
            thread.join(500);
            System.out.println("Join end");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testStop() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread start");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                    e.printStackTrace();
                } catch(Exception e) {
                    System.out.println(e);
                    e.printStackTrace();
                }
                System.out.println("Thread stop!");
            }
        });
        thread.start();
        try {
            System.out.println("Join before");
            thread.join(500);
            System.out.println("Join end");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        thread.stop();
    }
    
    @Test
    public void testInterrupt() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread start");
                try {
                    while(true) {
                        System.out.println("test .... ");
                        
                    }
                } catch(Exception e) {
                    System.out.println(e);
                    e.printStackTrace();
                }
                System.out.println("Thread stop!");
            }
        });
        thread.start();
        try {
            System.out.println("Join before");
            thread.join(500);
            System.out.println("Join end");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
