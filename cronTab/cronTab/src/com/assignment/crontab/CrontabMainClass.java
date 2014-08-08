package com.assignment.crontab;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class CrontabMainClass {
	public static TreeMap<Integer, String> tm;
	public static int utilSleepTime;

	public static void crontabMainClass() {
		tm = new TreeMap();
		JobAndConfigReader jobAndConfigReader = new JobAndConfigReader();

	}

	public static void readUtilConfig() {
		File file = new File(
				"C:\\Users\\Accolite\\workspaceAssgn\\configUtils.txt");
		BufferedReader in = null;
		InputStream fin;
		try {
			fin = new FileInputStream(file);
			in = new BufferedReader(new InputStreamReader(fin));
			readUtilSleepTime(Integer.parseInt(in.readLine()));
			creatLockOnFile(in.readLine());

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void readUtilSleepTime(int time) {
		utilSleepTime = time;
	}

	public static void creatLockOnFile(String fileNames) throws IOException {
		fileNames = fileNames.substring(fileNames.indexOf(':') + 1);
		String fileName[] = fileNames.split(",");
		for (int i = 0; i < fileName.length; i++) {
			ProhibitFiles.prohibitFiles(fileName[i]);
		}
	}

	public static void main(String args[]) {
		crontabMainClass();
		readUtilConfig();
		JobAndConfigReader jobAndConfigReader = new JobAndConfigReader();
		Thread jobAndConfigReaderThread = new Thread(jobAndConfigReader);
		jobAndConfigReaderThread.start();
		JobSchedular jobSchedular = new JobSchedular();
		Thread jobSchedularThread = new Thread(jobSchedular);
		jobSchedularThread.start();

	}

}
