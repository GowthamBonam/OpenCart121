package utilites;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener {
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repName;
	
	public void onStart(ITestContext testContext) {
		
		/*SimpleDateFormat df = SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		 * Date dt = new Date();
		 * String currentdatetimestamp = df.format(dt);
		 */
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName = "Test-Report-"  + timeStamp + ".html";
		sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);//Specify location of the file
		sparkReporter.config().setDocumentTitle("opencart Automation Report");//TItle of report
		sparkReporter.config().setReportName("Opencart Functional Testing");
		sparkReporter.config().setTheme(Theme.DARK);
	
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "opencart");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub Module", "Customers");
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environement", "QA");
		
		
		String os = testContext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System", os);
		
		String browser = testContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);
		
		List<String> includeGroups = testContext.getCurrentXmlTest().getIncludedGroups();
		if(!includeGroups.isEmpty()) {
			extent.setSystemInfo("Groups", includeGroups.toString());	
		}
	}
	
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups()); //to display groups in report
		test.log(Status.PASS,result.getName() + "got Successfully Executed");
	}
	
	public void onTestFailure(ITestResult result) {
		
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		
		test.log(Status.FAIL,result.getName() + "got Failed");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
		try {
			String imgPath =  new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);
			
		} catch (IOException e1) {
			e1.printStackTrace();
		
		}
	}
	
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName()+"got skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
	}
	
	
	public void onFinish(ITestContext testContext) {
		
		extent.flush();
		
		
		String pathofExtentReport = System.getProperty("user.dir") + "\\reports\\" + repName;
		File extentReport = new File(pathofExtentReport);
		
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		/*try {
			URL url = new URL("file:///+"System.getProperty("user.dir") +"\\reports\\"+repName);
		
		//Create the Email message
			ImageHtmlEmail email = new ImageHtmlEmail();
			email.setDataSourceResolver (new DataSourceResolver(url));
			email.setHostName("stmp.googleemail.com");
			email.setSmstport(465);
			email.setAuthenticator(new DefaultAuthenticator("Gowtham.bonam5@gmail.com", "Password"));
			email.setSSLOnConnect(true);
			email.setFrom("Gowthambonam5@gmail.com");
			email.setSubject("Test Results");
			email.setMsg("Please find the Attached Report ...");
			email.addTo("gowthamroyality143@gmail.com");//Receiver
			email.attach(url,"extent Report", "Please check report");
			email.send();
		}
		catch (Exception e) {
			e.printStackTrace();		
		}
	}*/
	}
}
	


