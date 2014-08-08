package com.assignment.crontab;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class JobSchedular extends CrontabMainClass implements Runnable {
	public int getCurrentTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String timeString = sdf.format(new Date());
		String splitTime[];
		splitTime = timeString.split(":");// split time
		int time = Integer.parseInt(splitTime[0] + splitTime[1]);
		int t1 = time / 100;
		int t2 = time - t1 * 100;
		time = t1 * 60 + t2;
		return time;
	}

	@Override
	public void run() {
		while (true) {
			ExecutorService pool = Executors.newFixedThreadPool(20);
			List<Future<String>> futures = new ArrayList<Future<String>>(20);
			int currentTime = getCurrentTime();
			boolean blnExists = tm.containsValue(currentTime);
			if (blnExists) {
				pool.submit(new Job(utilSleepTime, tm.get(currentTime)));
				tm.remove(currentTime);
			}

			for (Future<String> future : futures) {
				String result = null;
				try {
					result = future.get();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
				System.out.println(result);
			}

		}

	}

}
