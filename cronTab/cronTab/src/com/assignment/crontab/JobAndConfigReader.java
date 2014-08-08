package com.assignment.crontab;

public class JobAndConfigReader extends CrontabMainClass implements Runnable {
	public JobAndConfigReader() {

	}

	@Override
	public void run() {
		while (true) {
			InsertJob.insert();
			try {
				/*
				 * wait for 5 minutes after reading from file
				 */
				Thread.sleep(1000 * 60 * 5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}
}
