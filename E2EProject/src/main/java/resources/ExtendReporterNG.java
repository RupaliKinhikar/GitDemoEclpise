package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReporterNG {
	static ExtentReports extent;
	public static ExtentReports getReportObject()
	{
		//ExtentReports, ExtentSparkReporter are two classes use
		//reports-index.html folder is created at local project
		String path= System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		
		//set the name of report
		reporter.config().setReportName("Web Automation Result");
		
		//set document title
		reporter.config().setDocumentTitle("Test Results");
		
		// ExtentReports driver the report executions
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		//set the tester name
		extent.setSystemInfo("Tester", "Rupali");
		
		return extent;
	
	}

}
