package com.assignment.crontab;

import java.io.IOException;

public class ProhibitFiles {
	public static void prohibitFiles(String fileName) throws IOException {
		ProhibitFileThread prohibitFileThread = new ProhibitFileThread(fileName);
		Thread pft=new Thread(prohibitFileThread);
		pft.start();
	}
}
