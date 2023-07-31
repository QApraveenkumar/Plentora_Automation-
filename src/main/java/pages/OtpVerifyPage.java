package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class OtpVerifyPage extends PomPage {

    @FindBy(xpath = "//android.widget.Button[@content-desc='LOGIN']")
    private WebElement logInpage;
    @FindBy(className = "android.widget.EditText")
    private WebElement phonenume;
    @FindBy(className = "android.widget.CheckBox")
    private WebElement checkbox;
    @FindBy(className = "android.widget.Button")
    private WebElement login;


    public OtpVerifyPage(AndroidDriver driver) {
        super(driver);
    }

    public void validate_otp() {
        logInpage.click();
        phonenume.click();
        phonenume.sendKeys("8073477504");
        checkbox.click();
        login.click();

    }

    public void getotp() throws InterruptedException {
        driver.runAppInBackground(Duration.ofMillis(6000));
        driver.activateApp("com.google.android.apps.messaging");
        Thread.sleep(4000);
        // Adjust the XPath to correctly identify the element with the OTP text
        String otpText = driver.findElement(By.xpath("(//android.widget.TextView[@resource-id='com.google.android.apps.messaging:id/conversation_snippet'])[1]")).getText();
        String otp = otpText.split("is:")[1].trim(); // Extract only the numeric OTP value after "is:" and trim any leading/trailing spaces
        driver.navigate().back();
        System.out.println("OTP: *******" + otp);


         Thread.sleep(8000);

     List<MobileElement> Gotp = driver.findElements(By.xpath("//android.view.View[@content-desc='Did not get OTP?']/preceding-sibling::android.view.View[1]"));
     for (int i=0;i<otp.length();i++){
         Gotp.get(i).sendKeys(otp.charAt(i) +"");
     }
  // Gotp.sendKeys(otp);

       /* Actions actions = new Actions(driver);
        for (int i = 0; i < otp.length(); i++) {
            actions.sendKeys(otp.charAt(i) + "");
        }
        actions.build().perform();

*/
    }

}
