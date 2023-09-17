package com.testproject.core.dataops;

import java.io.File;

import org.apache.log4j.Logger;

import com.testproject.core.constants.Constants;
import com.testproject.core.utils.ClasspathUtils;

public class FileIO {
	
	private static final Logger log = Logger.getLogger(FileIO.class);
	
	
	public static String getReportPath() {
		String reportPath;
		
		if(System.getProperty("ReportFolderPath")!=null && !System.getProperty("ReportFolderPath").equalsIgnoreCase("")) {
			
		}
		
		else {
			reportPath=Constants.AUTOMATION_REPORT_PATH;
			createDirs(reportPath);
			
			reportPath= System.getProperty("ReportFolderPath");
			
			createDirs(reportPath);
			log.info(reportPath);
		}
		
		return "Hello";
		
	}
	
	
	
	public static void createDirs(String directory) {
		File files = new File(directory);
		if(!files.exists()) {
		
		if(files.mkdirs()) {
		log.info(files.getAbsolutePath());	
		}
		log.info(files.getAbsolutePath());		
		}
		
		
	}

}
