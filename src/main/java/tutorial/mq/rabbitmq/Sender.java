package tutorial.mq.rabbitmq;


import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP.Exchange;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Sender {
		private final static String QUEUE_NAME = "hello";
		private final static String EXCHANGE_NAME="exc";
		
		private static final String routing_KEY="";

	 
	 public static void main(String[] args) throws IOException, TimeoutException {
		
		 
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
			channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, QUEUE_NAME);
		    String message = "Hello World2222!";
		    
		    int i=0;
		    while(i<100) {
		    	channel.basicPublish(EXCHANGE_NAME, QUEUE_NAME, null, message.getBytes("UTF-8"));
		    	i++;
		    }
		    System.out.println(" [x] Sent '" + message + "'");

		    channel.close();
		    connection.close();
	}
}
