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
package cn.ucaner.microservice.ms.activemq.consumer;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
* @Package：cn.ucaner.microservice.ms.activemq.consumer   
* @ClassName：ConsumerOne   
* @Description：   <p> 消息的服务者</p>
* @Author： - DaoDou   
* @CreatTime：2018年1月28日 上午10:20:19   
* @Modify By：   
* @ModifyTime：  2018年1月28日
* @Modify marker：   
* @version    V1.0
 */
public class ConsumerOne {


    private static final String USERNAME= ActiveMQConnection.DEFAULT_USER;//默认用户
    private static final String PASSWORD=ActiveMQConnection.DEFAULT_PASSWORD;//默认密码
    private static final String BROKEURL=ActiveMQConnection.DEFAULT_BROKER_URL;

    public static void main(String[] args) {
    	
    	/**
    	 * 连接工厂
    	 */
        ConnectionFactory connectionFactory;
        /**
         * 连接
         */
        Connection connection = null;
        /**
         * 会话
         */
        Session session;
        Destination destination;
        /**
         * 消息消费者
         */
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
