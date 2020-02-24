package com.PgeFactoryExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {
	
	ExtentHtmlReporter htmlreporter  = new ExtentHtmlReporter(System.getProperty("user.dir")+"/ExtentReport.html");
	ExtentReports extent = new ExtentReports();
//	extent.attachReporter(htmlreporter);

}
