package com.demo.tasktime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/***
 * 定时器
 * @author Administrator
 *
 */
@Component
public class CmmiMiddleNslTime {

	
	@Scheduled(cron = "0/3 * * * * ?")
	public void doSomethingWithCron() {
		System.out.println(" -------------datasny |||||  datasny---------------");
	}
}
