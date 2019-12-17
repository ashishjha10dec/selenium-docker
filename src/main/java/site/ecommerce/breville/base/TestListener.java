package site.ecommerce.breville.base;

import java.io.FileWriter;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

	Logger log;
	String testName;
	String testMethodName;

	@Override
	public void onTestStart(ITestResult result) {
		this.testMethodName = result.getMethod().getMethodName();
		System.out.println("[Starting " + testMethodName + "]");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("[Test " + testMethodName + " passed]");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("[Test " + testMethodName + " failed]");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		this.testName = context.getCurrentXmlTest().getName();
		this.log = LogManager.getLogger(testName);
		System.out.println("[TEST " + testName + " STARTED]");
	}

	@SuppressWarnings("null")
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("[ALL " + testName + " FINISHED]");
		System.out.println("Start of get All results");
		System.out.println(context.getPassedTests().getAllResults());
		System.out.println("End of get passed tests results\n -----------------------------------------");
		System.out.println("Start of get get failed tests results");
		System.out.println(context.getFailedTests().getAllResults());
		System.out.println("End of get passed tests results\n -----------------------------------------");
		
		if (context.getFailedTests() == null) {
			try {
	            FileWriter writer = new FileWriter("MyFile.txt", true);
	            writer.write("Smote Tests Passed");
	            writer.write("\r\n");   // write new line
	            writer.write("Good Bye!");
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}else {
			try {
	            FileWriter writer = new FileWriter("MyFile.txt", true);
	            writer.write("Smote Tests Failed");
	            writer.write("\r\n");   // write new line
	            writer.write("Good Bye!");
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			
			
		}
	}

}