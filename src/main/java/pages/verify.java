package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.Set;

public class verify extends PomPage {

    // Window{1b7bd21 u0 com.heytap.browser/com.android.browser.BrowserActivity}

    @FindBy(xpath = "//android.widget.Button[@content-desc='LOGIN']")
    private WebElement logInpage;
    @FindBy(className = "android.widget.EditText")
    private WebElement phonenume;
    @FindBy(className = "android.widget.CheckBox")
    private WebElement checkbox;
    @FindBy(className = "android.widget.Button")
    private WebElement login;

    public verify(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public void Chromeapp() throws InterruptedException {

        driver.activateApp("com.android.chrome");
        Set<String> availableContexts = driver.getContextHandles();
      /*  for (String context : availableContexts) {
            if (context.startsWith("WEBVIEW")) {
                driver.context(context);
            }
        }
        // navigate to some url
        driver.findElement(MobileBy.id("com.android.chrome:id/url_bar")).
                setValue("http://topotp.exathought.com.s3-website.ap-south-1.amazonaws.com");
        Thread.sleep(5000);
        KeyEvent enterKey = new KeyEvent(AndroidKey.ENTER);
        ((AndroidDriver<MobileElement>) driver).pressKey(enterKey);
       // driver.get("http://topotp.exathought.com.s3-website.ap-south-1.amazonaws.com");
       // driver.findElement(By.xpath("//input[@name='q']")).sendKeys("http://topotp.exathought.com.s3-website.ap-south-1.amazonaws.com");
        driver.navigate().back();
        login.click();
*/
}
    public void openChromeNavigatedTo(String URL) throws IOException {
        String command = String.format("adb shell am start -n com.android.chrome/com.google.android.apps.chrome.Main -d '%s'", URL);
        Process process = new ProcessBuilder(command).start();
    }
    public void closeChrome() {
        driver.terminateApp("com.android.chrome");
    }
public void entrnum() throws InterruptedException {
    logInpage.click();
    phonenume.click();
    phonenume.sendKeys("8989898988");
Thread.sleep(5000);
checkbox.click();
}
public void loginButton() throws InterruptedException {

    Thread.sleep(4000);

    Set<String> contextHandles = driver.getContextHandles();
    for (String context : contextHandles) {
        if (context.contains("WEBVIEW_chrome")) {
            try {
                driver.context(context);
                System.out.println("Switched to WEBVIEW_chrome context");
            } catch (Exception e) {
                System.err.println("Error switching to WEBVIEW_chrome context: " + e.getMessage());
            }
            break;
          //  driver.context(context);
        }
        }

            driver.get("http://topotp.exathought.com.s3-website.ap-south-1.amazonaws.com/");
     // MobileElement ph = driver.findElement(By.className("flt-text-editing transparentTextEditing"));
     // ph.click();
     // ph.sendKeys("+918989898988");
            // driver.activateApp("com.android.chrome"); //activating the chrome app
            // driver.getContextHandles(); // getting available contexts
            //  driver.context("WEBVIEW_chrome"); //switching to webview_chorome content
            Thread.sleep(15000);
        driver.context("NATIVE_APP");
            login.click();
        }
    }

