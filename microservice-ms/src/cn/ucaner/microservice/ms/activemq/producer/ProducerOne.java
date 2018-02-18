/**
 * <html>
 * <body>
 *  <P> Copyright 1994-2018 JasonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 2018年</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.microservice.ms.activemq.producer;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
* @Package：cn.ucaner.microservice.ms.activemq.producer   
* @ClassName：ProducerOne   
* @Description：   <p> 消息的生产者</p>
* @Author： - DaoDou   
* @CreatTime：2018年1月28日 上午10:19:36   
* @Modify By：   
* @ModifyTime：  2018年1月28日
* @Modify marker：   
* @version    V1.0
 */
public class ProducerOne {

    private static final String USERNAME= ActiveMQConnection.DEFAULT_USER;
    private static final String PASSWORD=ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String BROKEURL=ActiveMQConnection.DEFAULT_BROKER_URL;
    private static final int SENDNUM=10;

    public static void main(String[] args) {

        ConnectionFactory connectionFactory;
        Connection connection = null;
        Session session;
        Destination destination;
        MessageProducer messageProducer;

        connectionFactory=new ActiveMQConnectionFactory(ProducerOne.USERNAME, ProducerOne.PASSWORD, ProducerOne.BROKEURL);

        try {
            connection=connectionFactory.createConnection();
            connection.start();
            session=connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            destination=session.createQueue("FirstQueue1");
            messageProducer=session.createProducer(destination);
            sendMessage(session, messageProducer);//发送 消息
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if(connection!=null){
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void sendMessage(Session session,MessageProducer messageProducer)throws Exception{
        for(int i=0;i<ProducerOne.SENDNUM;i++){
            TextMessage message=session.createTextMessage("ActiveMQ发送消息"+i);
            System.out.println("收到"+"发送的消息"+i);
            messageProducer.send(message);
        }
    }
}
