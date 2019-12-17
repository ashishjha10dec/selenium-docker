package site.ecommerce.breville.base;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;

public class CustomReporter implements IReporter {
	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		int failedTCsCount = 0;
		int TotalFailedTCsCount =0;
		// Iterating over each suite included in the test
		for (ISuite suite : suites) {
			// Following code gets the suite name
			//String suiteName = suite.getName();
			// Getting the results for the said suite
			Map<String, ISuiteResult> suiteResults = suite.getResults();
			for (ISuiteResult sr : suiteResults.values()) {
				ITestContext tc = sr.getTestContext();

				/*
				 * System.out.println( "Passed tests for suite '" + suiteName + "' is:" +
				 * tc.getPassedTests().getAllResults().size());
				 * 
				 * 
				 * System.out.println( "Failed tests for suite '" + suiteName + "' is:" +
				 * tc.getFailedTests().getAllResults().size());
				 * System.out.println("Skipped tests for suite '" + suiteName + "' is:" +
				 * tc.getSkippedTests().getAllResults().size());
				 */
				failedTCsCount = tc.getFailedTests().getAllResults().size();
				TotalFailedTCsCount = TotalFailedTCsCount+failedTCsCount ;
								//System.out.println("failed tcs count" +failedTCsCount);


			}
			System.out.println("Total failed tcs count is : "+TotalFailedTCsCount);
			if (TotalFailedTCsCount == 0) {

				try {
					FileWriter writer = new FileWriter("SmokeTestsStatus.txt", true);
					writer.write("Smoke Tests Passed");
					writer.write("\r\n"); // write new line
					writer.flush();
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			} else {

				try {
					FileWriter writer = new FileWriter("SmokeTestsStatus.txt", true);
					writer.write("Smoke Tests Failed");
				    writer.write("\r\n"); // write new line
					writer.flush();
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}
	}
}