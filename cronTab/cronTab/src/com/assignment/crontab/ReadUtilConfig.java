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
		if (file.exists() && !file.isDirectory()) {
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
	}

	/**
	 * @param time
	 *            : time in utilConfig.txt for sleeping
	 */

	public static void readUtilSleepTime(int time) {
		utilSleepTime = time;
	}

	/**
	 * 
	 * @param fileNames
	 *            : list of files in utilConfig.txt
	 * @throws IOException
	 */
	public static void creatLockOnFile(String fileNames) throws IOException {
		fileNames = fileNames.substring(fileNames.indexOf(':') + 1);
		String fileName[] = fileNames.split(",");
		for (int i = 0; i < fileName.length; i++) {
			File file = new File(fileName[i]);
			if (file.exists() && !file.isDirectory()) {
				ProhibitFiles.prohibitFiles(fileName[i]);
			}
		}
	}

}
