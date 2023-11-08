package genericLibraries;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.TestResult;

	public class ListenerImplemetation implements ITestListener{
		
		public void onTestStart(TestResult result) {
			System.out.println(result.getMethod().getMethodName()+"execution starts");
		}
		@Override
		public void onTestSuccess(ITestResult result)
		{
			System.out.println(result.getMethod().getMethodName()+"Passed");
	}

		@Override
		public void onTestFailure(ITestResult result) {
			System.out.println(result.getMethod().getMethodName()+"Failed");
			System.out.println("Failure Occured due to:"+result.getThrowable());
			WebDriverUtility web = new WebDriverUtility();
			web.takeScreenshot(BaseClass.sdriver, result.getMethod().getMethodName(), BaseClass.sjutil);
		}
		@Override
		public void onTestSkipped(ITestResult result) {
			System.out.println(result.getMethod().getMethodName()+"skipped");
			System.out.println("skipped due to :"+result.getThrowable());
		}
		@Override
		public void onStart(ITestContext context) {
			System.out.println("Suite execution starts");
		}
		public void onFinish(ITestContext context) {
			System.out.println();
		}
}
