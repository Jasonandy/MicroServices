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
package cn.ucaner.microservice.ms.activemq.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
* @Package：cn.ucaner.microservice.ms.activemq.listener   
* @ClassName：ListenerOne   
* @Description：   <p> 消息的监听者</p>
* @Author： - DaoDou   
* @CreatTime：2018年1月28日 上午10:19:55   
* @Modify By：   
* @ModifyTime：  2018年1月28日
* @Modify marker：   
* @version    V1.0
 */
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
