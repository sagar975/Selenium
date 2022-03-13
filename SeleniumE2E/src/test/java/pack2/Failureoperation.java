package pack2;

import java.io.File;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Failureoperation implements ITestListener {

	public static WebDriver driver;
	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;

	@BeforeTest
	public static void initializeExtentReport() {

		reporter = new ExtentHtmlReporter("E://sagar//ExtentReport//result.html");
		extent = new ExtentReports();

	}

	public void onTestFailure(ITestResult result) {

		// put the result in HTML reports

		// reporter = new ExtentHtmlReporter("E://sagar//ExtentReport//result.html");

		// ExtentReports extent = new ExtentReports();

		extent.attachReporter(reporter);

		ExtentTest logger = extent.createTest(result.getName());

		logger.log(Status.FAIL, result.getName() + " " + "is Failed");

		extent.flush();

	}

	public void onTestSuccess(ITestResult result) {

		// reporter = new ExtentHtmlReporter("E://sagar//ExtentReport//result.html");

		// ExtentReports extent = new ExtentReports();

		extent.attachReporter(reporter);

		ExtentTest logger = extent.createTest(result.getName());

		logger.log(Status.PASS, result.getName() + " " + "is Passed");

		extent.flush();

	}

}
