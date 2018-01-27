package cn.ucaner.microservice.ms.activemq.consumer;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class ConsumerOne {


    private static final String USERNAME= ActiveMQConnection.DEFAULT_USER;
    private static final String PASSWORD=ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String BROKEURL=ActiveMQConnection.DEFAULT_BROKER_URL;

    public static void main(String[] args) {
        ConnectionFactory connectionFactory;
        Connection connection = null;
        Session session;
        Destination destination;
        MessageConsumer messageConsumer;


        connectionFactory=new ActiveMQConnectionFactory(ConsumerOne.USERNAME, ConsumerOne.PASSWORD, ConsumerOne.BROKEURL);

        try {
            connection=connectionFactory.createConnection();
            connection.start();
            session=connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
            destination=session.createQueue("FirstQueue1");
            messageConsumer=session.createConsumer(destination);
            while(true){
                TextMessage textMessage=(TextMessage)messageConsumer.receive(100000);
                if(textMessage!=null){
                    System.out.println("收到消息"+textMessage.getText());
                }else{
                    break;
                }
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
