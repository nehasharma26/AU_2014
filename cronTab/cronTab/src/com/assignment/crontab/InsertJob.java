package com.assignment.crontab;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.TimerTask;

/**
 * This class inserts the time and job read from file into data structure
 *
 */

public class InsertJob extends TimerTask implements Runnable {
	@Override
	public void run() {
		File file = new File("C:\\Users\\Accolite\\workspaceAssgn\\cron.txt");
		if (file.exists() && !file.isDirectory()) {
			BufferedReader in = null;
			InputStream fin;
			try {
				fin = new FileInputStream(file);
				in = new BufferedReader(new InputStreamReader(fin));
				String readLine;
				String[] splitTimeJob;
				while ((readLine = in.readLine()) != null) {
					splitTimeJob = readLine.split("\t");// split time and job by
														// tab
					String job = splitTimeJob[1];
					int time = Integer.parseInt(splitTimeJob[0].replaceAll(
							"[\\D]", ""));
					int t1 = time / 100;
					int t2 = time - t1 * 100;
					time = t1 * 60 + t2;
					CrontabMainClass.tm.put(time, job);// inserting time and job in tree map
				}
				in.close();
				fin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				//deleting the entries that have been read from cron.txt
				PrintWriter pw = null;
				try {
					pw = new PrintWriter("C:\\Users\\Accolite\\workspaceAssgn\\cron.txt");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				pw.close();
				
			}

		}
		
	}

}
