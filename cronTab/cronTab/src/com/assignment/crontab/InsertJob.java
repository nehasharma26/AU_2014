package com.assignment.crontab;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InsertJob extends CrontabMainClass {

	public static void insert() {
		File file = new File("C:\\Users\\Accolite\\workspaceAssgn\\cron.txt");
		BufferedReader in = null;
		InputStream fin;
		try {
			fin = new FileInputStream(file);
			in = new BufferedReader(new InputStreamReader(fin));
			String readLine;
			String[] splitTimeJob;
			while ((readLine = in.readLine()) != null) {
				splitTimeJob = readLine.split("\t");//split time and job by tab
				String job = splitTimeJob[1];
				int time = Integer.parseInt(splitTimeJob[0].replaceAll("[\\D]", ""));
				int t1 = time / 100;
				int t2 = time - t1 * 100;
				time = t1 * 60 + t2;
				tm.put(time, job);//inserting time and job in tree map
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
