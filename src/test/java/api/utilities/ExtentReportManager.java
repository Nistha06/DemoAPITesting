//package api.utilities;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterSuite;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//
//public class ExtentReportManager  implements ITestListener
//{
//	public ExtentSparkReporter sparkReporter;
//	public ExtentReports extent;
//	public ExtentTest test;
//	String repName;
//	public void onStart(ITestContext textContext)
//	{
//		String timeStamp=new SimpleDateFormat("yyyy.mm.ss.HH.mm.ss").format(new Date());
//		repName="Test-Report-"+timeStamp+".html";
//		sparkReporter =new ExtentSparkReporter("\\reports\\"+repName);
//		sparkReporter.config().setDocumentTitle("RestAssuredAutomationProject");
//		sparkReporter.config().setReportName("Pet Store User API");
//		sparkReporter.config().setTheme(Theme.DARK);
//		extent =new ExtentReports();
//		extent.attachReporter(sparkReporter);
//		extent.setSystemInfo("Application", "Pet Store User API");
//		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
//		extent.setSystemInfo("User name", System.getProperty("user name"));
//		extent.setSystemInfo("Environment", "QA");
//		extent.setSystemInfo("user", "Nistha");
//		}
//	@AfterSuite
//    public void onFinish() {
//        extent.flush();
//    }
//
//    @AfterMethod
//    public void getResult(ITestResult result) {
//        if (result.getStatus() == ITestResult.FAILURE) {
//            test.log(Status.FAIL, "Test Case FAILED is " + result.getName()); // to add name in extent report
//            test.log(Status.FAIL, "Test Case FAILED due to " + result.getThrowable()); // to add error/exception in extent report
//        } else if (result.getStatus() == ITestResult.SUCCESS) {
//            test.log(Status.PASS, "Test Case PASSED is " + result.getName());
//        } else if (result.getStatus() == ITestResult.SKIP) {
//            test.log(Status.SKIP, "Test Case SKIPPED is " + result.getName());
//        }
//    }
//
//    public void createTest(String testName) {
//        test = extent.createTest(testName);
//    }
//	
//}
package api.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;

public class ExtentReportManager implements ITestListener {
    private ExtentReports extent;
    private ExtentSparkReporter sparkReporter;

    @Override
    public void onStart(ITestContext context) {
        String repName = "TestReport.html"; // You can customize the report name
        String reportPath = System.getProperty("user.dir") + "\\reports\\" + repName;
        sparkReporter = new ExtentSparkReporter(reportPath);
        
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        
        // Additional configuration for the reporter (optional)
        sparkReporter.config().setReportName("API Test Report");
        sparkReporter.config().setDocumentTitle("API Testing");
    }

    @Override
    public void onTestStart(ITestResult result) {
        extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extent.createTest(result.getMethod().getMethodName()).pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extent.createTest(result.getMethod().getMethodName()).fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extent.createTest(result.getMethod().getMethodName()).skip("Test Skipped");
    }
    @Override
    public void onFinish(ITestContext context) {
    	 extent.flush();
    }
}