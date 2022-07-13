package com.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ExtentListenerClass implements ITestListener  {

	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	
	ReadConfig readConfig = new ReadConfig();
	
	public void configureReport() {
		
		String timeStamp =  new SimpleDateFormat("dd.mm.yyyy.hh.mm.ss").format(new Date());
		String reportName = "DB Support Login Test Report" + timeStamp + ".html";
		htmlReporter = new ExtentSparkReporter("C:\\Users\\INDRAJIT\\eclipse-workspace\\com.db_support\\Reports\\LoginTestReport.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		reports.setSystemInfo("OS","Windows 11");
		reports.setSystemInfo("browser", readConfig.getBrowser());
		
		
		htmlReporter.config().setDocumentTitle("DB Support Report");
		htmlReporter.config().setReportName("Login Test Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		
	}
	
	public void onStart(ITestContext Result) {
		
		configureReport();
		
	}
	
	public void onFinish(ITestContext Result) {
		
		reports.flush();
	}
	
	public void onTestFaliure(ITestResult Result) {
		
		test = reports.createTest(Result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is " +Result.getName(), ExtentColor.RED));
	}
	
	public void onTestSkipped(ITestResult Result) {
		
		test = reports.createTest(Result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skip test case is " +Result.getName(), ExtentColor.YELLOW));
	}
	
	public void onTestSuccess(ITestResult Result) {
		
		test = reports.createTest(Result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the pass test case is " +Result.getName(), ExtentColor.GREEN));
	}
	
	public void onTestFailNutWithinSuccessPercentage(ITestResult Result) {
		
	}
}

