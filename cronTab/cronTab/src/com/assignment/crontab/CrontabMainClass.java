package com.assignment.crontab;

import java.util.TreeMap;

public class CrontabMainClass {
	public static TreeMap<Integer, String> tm;
	public static int utilSleepTime;

	public static void crontabMainClass() {
		tm = new TreeMap();
	}

	public static void main(String args[]) {
		crontabMainClass();
		JobAndConfigReader jobAndConfigReader = new JobAndConfigReader();
		Thread jobAndConfigReaderThread = new Thread(jobAndConfigReader);
		jobAndConfigReaderThread.start();
		JobSchedular jobSchedular = new JobSchedular();
		Thread jobSchedularThread = new Thread(jobSchedular);
		jobSchedularThread.start();

	}

}
