package SeleniumTests;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersExample implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test case is going to execute");

    }
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test case is passed");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("Test case is failed");
    }

    public void onTestSkipped(ITestResult result) {
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }

    public void onStart(ITestContext context) {
        System.out.println("Before everything");
    }

    public void onFinish(ITestContext context) {
        System.out.println("After everything");
    }


}