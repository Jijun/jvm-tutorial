package tutorial.mq.activemq;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class ConsumerTest {

	public static void main(String[] args) throws JMSException {

		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(
				ActiveMQConnectionFactory.DEFAULT_USER,
				ActiveMQConnectionFactory.DEFAULT_PASSWORD,"tcp://127.0.0.1:61616");

		Connection conn = factory.createConnection();
		conn.start();
		Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

		Destination dest = session.createQueue("Test");

		MessageConsumer consumer = session.createConsumer(dest);
		consumer.setMessageListener(e -> {
			TextMessage tm = (TextMessage) e;

			try {
				System.out.println(tm.getText());
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		});

	}
}
