package tutorial.mq.activemq;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Producer {
	public static void main(String[] args) throws JMSException, InterruptedException {

		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(
				ActiveMQConnectionFactory.DEFAULT_USER,
				ActiveMQConnectionFactory.DEFAULT_PASSWORD,"tcp://127.0.0.1:61616");

		Connection conn = factory.createConnection();

		conn.start();
		Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

		Destination dest = session.createQueue("Test");
		
		MessageProducer producer = session.createProducer(dest);
		
		TextMessage msg = session.createTextMessage();
		
		for(int i=0;i<100;i++) {
			Thread.sleep(1000);
			msg.setText("我发中文了 " + i);
			producer.send(msg);
		}
		conn.close();
	}
}
