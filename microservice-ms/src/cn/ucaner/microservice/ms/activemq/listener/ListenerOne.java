package cn.ucaner.microservice.ms.activemq.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class ListenerOne implements MessageListener {


    @Override
    public void onMessage(Message message) {

        try {
            System.out.println("监听到的消息为："+((TextMessage)message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
