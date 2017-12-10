package fx.leyu.learn.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Listener {
    private static String user = ActiveMQConnection.DEFAULT_USER;  
    private static String password =ActiveMQConnection.DEFAULT_PASSWORD;  
    private static String url =  "tcp://localhost:61616";  

    public static void main(String[] args) throws JMSException {
        ConnectionFactory factory = new ActiveMQConnectionFactory(user,password,url);
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(Boolean.TRUE,Session.AUTO_ACKNOWLEDGE);
        Destination dest = session.createQueue("queue-fxleyu-test");
        session.createConsumer(dest).setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message arg0) {
                System.out.println("message = " + arg0);
            }
        });
    }

}
