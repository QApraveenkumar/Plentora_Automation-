package bassclass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import io.appium.java_client.android.nativekey.KeyEvent;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Tryalclass {
    AndroidDriver driver1;
    
    @Test
    public void startApp() throws MalformedURLException, InterruptedException {
        
        DesiredCapabilities cap = new DesiredCapabilities();
        
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13");
        cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        cap.setCapability("appPackage", "com.carparts.app");
        cap.setCapability("appActivity", "com.carparts.app.MainActivity");
        cap.setCapability("noReset", true);
        // cap.setCapability("resetKeyboard", true);
        
        // cap.setCapability("unicodeKeyboard", true);
        URL url = new URL("http://localhost:4723/wd/hub");
        
        driver1 = new AndroidDriver(url, cap);
        driver1.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
        WebElement serch = driver1.findElementByXPath("//android.widget.EditText[@resource-id='searchBox-mobile']");
        Thread.sleep(3000);
        
        driver1.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(resourceId(\"\"))");
        Thread.sleep(3000);
        // WebElement element = driver1.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(resourceId(\"subCat1-2\"))");
        //  element.click();
        driver1.quit();
        
        
    }
}


