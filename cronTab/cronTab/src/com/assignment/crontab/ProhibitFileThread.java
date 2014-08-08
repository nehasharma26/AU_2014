package com.assignment.crontab;

import java.io.FileInputStream;
import java.io.IOException;

public class ProhibitFileThread implements Runnable{
	String fileName;
	public ProhibitFileThread(String fileName){
		this.fileName=fileName;
	}
	/**
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 * 
	 * prohibit() applies lock on the file
	 */
	public void prohibit() throws IOException, InterruptedException{
		FileInputStream in = new FileInputStream(fileName);
		try {
		    @SuppressWarnings("unused")
			java.nio.channels.FileLock lock = in.getChannel().lock();
		    while(true){
		    	Thread.sleep(10);
		    }
		} finally {
		    in.close();
		}
		
	}

	@Override
	public void run(){
		try {
			prohibit();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		
	}
		
		
	}


