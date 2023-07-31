package bassclass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import pages.PomPage;

import java.io.IOException;

public class Listner implements ITestListener {
    
    public void onStart(ITestContext arg) {
        System.out.println("Start test execution......" + arg.getName());
    }
    
    public void onFinish(ITestContext arg) {
        System.out.println("Finish test execution......" + arg.getName());
    }
    
    public void onTestStart(ITestResult arg0) {
        System.out.println("Start test......" + arg0.getName());
    }
    
    public void onTestFailure(ITestResult result) {
        String screenshotname = result.getMethod().getMethodName();
        
        MobileInteraction Action = new MobileInteraction();
        try {
            Action.takeScreenShot(BaseClass.driver, screenshotname);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("failed test ......" + result.getName());
        
    }
    
    public void onTestSuccess(ITestResult arg) {
        System.out.println("Passed test execution......" + arg.getName());
    }
    
    public void onTestSkipped(ITestResult arg) {
        System.out.println("Skipped test ......" + arg.getName());
    }
    
}
