package fx.leyu.learn.activemq;

import java.util.Enumeration;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Publisher {
    private static String user = ActiveMQConnection.DEFAULT_USER;  
    private static String password =ActiveMQConnection.DEFAULT_PASSWORD;  
    private static String url =  "tcp://localhost:61616";  

    public static void main(String[] args) throws JMSException {
        ConnectionFactory factory = new ActiveMQConnectionFactory(user,password,url);
        Connection connection = factory.createConnection();
        Session session = connection.createSession(Boolean.TRUE,Session.AUTO_ACKNOWLEDGE);
        
        Destination dest = session.createQueue("queue-fxleyu-test");
        MessageProducer producer = session.createProducer(dest);
        for (int i =0 ; i < 10; i++) {
            System.out.println("start send message ... " + i);
            TextMessage message = session.createTextMessage("Hello World! - " + i);
            producer.send(message);
        }
        session.commit();
        connection.close();
    }
}
