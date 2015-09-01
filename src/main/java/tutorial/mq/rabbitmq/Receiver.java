package tutorial.mq.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

public class Receiver {
	private final static String QUEUE_NAME = "hello";
	private final static String EXCHANGE_NAME="exc";
	
	private static final String routing_KEY="";

	public static void main(String[] argv) throws Exception {

		ConnectionFactory factory = new ConnectionFactory();
	    factory.setHost("10.59.94.164");
	    factory.setPort(8888);
	    factory.setPassword("hrpass");
	    factory.setUsername("hr");
	    factory.setVirtualHost("/hrsystem");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		channel.exchangeDeclare(EXCHANGE_NAME ,"direct");
		channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, routing_KEY);
		
		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

		QueueingConsumer consumer = new QueueingConsumer(channel);
		channel.basicConsume(QUEUE_NAME, true, consumer);

		while (true) {
			QueueingConsumer.Delivery delivery = consumer.nextDelivery();
			String message = new String(delivery.getBody(), "UTF-8");
			String routingKey = delivery.getEnvelope().getRoutingKey();
			System.out.println("[X] "+routingKey+ "Received '" + message + "'");
		}
		
	}
}
