package com.utilsLayer;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentSetUp {
	public static ExtentReports extentReports;
	
	public static ExtentReports extentsetup() {
//		SimpleDateFormat date=new SimpleDateFormat("ddMMyyyy_HHmmss");
//		String a = date.format(new Date());
		
		String a =new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
		
		
		
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(
				System.getProperty("user.dir")+"//Report//"+a+".html");
		
		extentReports=new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		return extentReports;
				
	}
}
