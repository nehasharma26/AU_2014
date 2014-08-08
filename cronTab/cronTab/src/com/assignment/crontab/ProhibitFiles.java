package com.assignment.crontab;

import java.io.IOException;

/**
 * 
 * This class creates threads for prohibition of files whose name are read from
 * utilConfig.txt
 * 
 */

public class ProhibitFiles {
	/**
	 * 
	 * @param fileName
	 *            : the filename of the file on which we want to apply lock
	 * @throws IOException
	 */
	public static void prohibitFiles(String fileName) throws IOException {
		ProhibitFileThread prohibitFileThread = new ProhibitFileThread(fileName);
		Thread creatingProhibitedFileThread = new Thread(prohibitFileThread);
		creatingProhibitedFileThread.start();
	}
}
