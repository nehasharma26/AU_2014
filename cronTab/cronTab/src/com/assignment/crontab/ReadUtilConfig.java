package com.assignment.crontab;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadUtilConfig extends CrontabMainClass {
	public ReadUtilConfig() {
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


}
