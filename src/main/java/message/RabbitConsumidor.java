package message;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class RabbitConsumidor {
    private final static String QUEUE_NAME = "Fila-de-produtos";

    public static void main(String[] args) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        while (true) {
            try (Connection connection = factory.newConnection();
            Channel channel = connection.createChannel()) {

                channel.queueDeclare(QUEUE_NAME, true, false, false, null);

                DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                    String mensagem = new String(delivery.getBody(),"UTF-8");
                    System.out.println("Mensagem recebida: '"+ mensagem + "'" );
                };

                channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {
                });

                System.out.println("Aguardando mensagens ...");

                Thread.sleep(Long.MAX_VALUE);


            }
        }

    }
}
