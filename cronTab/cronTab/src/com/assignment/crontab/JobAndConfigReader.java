package com.assignment.crontab;

import java.util.Timer;
/**
 * 
 * This class schedules the reading of conf.txt and calls InsertJob class after every 5 mins
 *
 */

public class JobAndConfigReader implements Runnable {

	@Override
	public void run() {
			Timer time=new Timer();
			time.schedule(new InsertJob() , 0, 5*60*1000);

	}
}
