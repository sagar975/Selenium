package Reports;

import org.testng.annotations.Test;


import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import junit.framework.Assert;

import com.aventstack.extentreports.*;

public class ExtentReportTests {

	private static ExtentHtmlReporter reporter;

	@Test
	public void reporConfiguration() {

		reporter = new ExtentHtmlReporter("E://sagar//ExtentReport//result.html");

		ExtentReports extent = new ExtentReports();

		extent.attachReporter(reporter);	

		ExtentTest logger = extent.createTest("test practise");

		logger.log(Status.INFO, "verifying broken links on page");

		extent.flush();

	}

}
