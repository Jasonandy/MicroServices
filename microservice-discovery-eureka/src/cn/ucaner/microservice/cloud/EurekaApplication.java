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
package cn.ucaner.microservice.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


/**
* @Package：cn.ucaner.microservice.cloud   
* @ClassName：EurekaApplication   
* @Description：   <p> EurekaApplication</p>
* @Author： - DaoDou
* @CreatTime：2018年1月28日 上午10:18:01   
* @Modify By：   
* @ModifyTime：  2018年1月28日
* @Modify marker：   
* @version    V1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
  public static void main(String[] args) {
    SpringApplication.run(EurekaApplication.class, args);
  }

}
