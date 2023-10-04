package com.paladin.account.core.tasks;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

/**
 * @author: paladin
 * @Description:
 * @date: created in 2020/8/28 0:08
 */
@EnableScheduling
public class ScheduleTask {

	@Scheduled(fixedRate = 5000)
	public void job1() {
		System.out.println("定时任务1" + new Date());
	}

	@Scheduled(cron = "0/5 * * * * ?")
	public void job2() {
		System.out.println("定时任务2" + new Date());
	}
}
