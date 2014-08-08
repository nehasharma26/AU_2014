package com.assignment.crontab;

import java.util.concurrent.Callable;

public class Job implements Callable{
	String job;
	int utilSleepTime;
	public Job(int time,String job){
		this.job=job;
		this.utilSleepTime=time;
		
	}

	@Override
	public String call() throws Exception {
		System.out.println("executed "+job);
		Thread.sleep(this.utilSleepTime);		
		return "success";
	}

}
