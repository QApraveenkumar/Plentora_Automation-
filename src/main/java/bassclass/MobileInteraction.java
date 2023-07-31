package bassclass;

import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;


public class MobileInteraction {
    public WebDriver driver;
    
    public boolean waitForPageToLoad(WebElement ele) {
        driver = AppiumDriverManager.getAppiumDriver();
        try {
            WebDriverWait wait = new WebDriverWait(driver, (3000));
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(ele)));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean isElementPresent(WebElement ele) {
        try {
            WebDriverWait wait = new WebDriverWait(BaseClass.driver, (2000));
            wait.until(ExpectedConditions.visibilityOf(ele));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    
    //Scrool Method
 /*  public void scrollAndClick(String visibleText) {
driver1.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Engine & Drivetrain\"))");

        AppiumDriverManager.getAppiumDriver().findElementByAndroidUIAutomator
                ("new UiScrollable(new UiSelector().scrollable(true).
                        instance(0)).scrollIntoView(
                new UiSelector().textContains(\""+visibleText+
                        "\").instance(0))").click();
    }


    public void Scrooltoele(WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) AppiumDriverManager.getAppiumDriver();
            js.executeScript("arguments[0].scrollIntoView();", element);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
*/
    
    public void scrollUp() {
        // Get the device screen dimensions
        Dimension size = driver.manage().window().getSize();
        
        // Set the start and end coordinates for the swipe action
        int startX = (int) (size.width * 0.5);
        int startY = (int) (size.height * 0.7);
        int endX = startX;
        int endY = (int) (size.height * 0.2);
        
        // Perform the swipe action from the start coordinates to the end coordinates
        TouchAction action = new TouchAction((PerformsTouchActions) driver);
        action.press(point(startX, startY)).waitAction(WaitOptions.waitOptions(ofMillis(2000)))
                .moveTo(point(endX, endY)).release().perform();
        
    }
    
    
    public String takeScreenShot(AndroidDriver driver, String screenshotName) throws IOException {
        TakesScreenshot ts = driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File("./screenshots/" + screenshotName + ".png");
        FileUtils.copyFile(src, dest);
        return screenshotName;
    }
    
    public void swipeUp(int no_ofSwipe) {
        swipeUp(no_ofSwipe, 1000);
        
        
    }
    
    public boolean swipeUp(int no_ofSwipe, int milli_second) {
        Dimension windowSize = BaseClass.driver.manage().window().getSize();
        int Starty = (int) (windowSize.height * 0.8);
        int Endy = (int) (windowSize.height * 0.2);
        int X = (int) (windowSize.width * 0.5);
        for (int i = 1; i <= no_ofSwipe; i++) {
            swipe(X, Starty, X, Endy, milli_second);
            /*
            boolean elementAppear=isElementPresent(element);
            if (elementAppear){
                return true;
            }
            else {
                swipe(X,Starty,X,Endy,milli_second);
                }
         */
        }
        return false;
    }
    
    public void swipe(int fromX, int fromY, int toX, int toY, int Milli_second) {
        
        TouchAction action = new TouchAction(BaseClass.driver);
        action.press(PointOption.point(fromX, fromY))
                .waitAction(new WaitOptions().withDuration(Duration.ofMillis(3000))) //you can change wait durations as per your requirement
                .moveTo(PointOption.point(toX, toY))
                .release()
                .perform();
    }
    
    public void Scrolltoelement(String visibleText) {
        BaseClass.driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\" visibleText\"))");
        
        
    }
}