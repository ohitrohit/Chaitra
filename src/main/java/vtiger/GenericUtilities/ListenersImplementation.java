package vtiger.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * this class contain implementation for ItestListeners interface of testng
 * @author rohit
 *
 */
public class ListenersImplementation implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
	    System.out.println(methodName+"-----Execution started");
	    
	    test = report.createTest(methodName);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
	    
	    test.log(Status.PASS,methodName+"-----Pass" );
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		JavaUtility jUtil = new JavaUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		String methodName = result.getMethod().getMethodName();
	    test.log(Status.FAIL, methodName+"-----Fail");
	    test.log(Status.INFO, result.getThrowable());
	    
	    String ScreenshotName = methodName+"_"+jUtil.getSystemDateInFormat();
	    
	    try {
	    	String path = wUtil.takeScreenShot(BaseClass.sDriver, ScreenshotName);
	    	test.addScreenCaptureFromPath(path);
	    }catch(IOException e) {
	    	e.printStackTrace();
	    }
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
	    test.log(Status.SKIP, methodName+"-----Skip");
	    test.log(Status.INFO, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("suite start");
		
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("Vtiger Execution Reports");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("VTIGER EXECUTION REPORT");
		
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Reporter Name", "ROHIT");
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	    System.out.println("suite finish");
	    
	    report.flush();
	}

	
	
	
}
