package testScript;

import bassclass.BaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;
import pages.OtpVerifyPage;
import pages.homepage;
import pages.verify;

import java.io.IOException;

public class TestScript2 extends BaseClass{

    @Test
    public void VerfiyOTP() throws InterruptedException {
        OtpVerifyPage otp=new OtpVerifyPage(driver);
        otp.validate_otp();
        otp.getotp();


    }
    @Test
    public void test3() throws InterruptedException, IOException {
        verify vr=new verify(BaseClass.driver);
        vr.entrnum();
        //  vr.openChromeNavigatedTo("http://topotp.exathought.com.s3-website.ap-south-1.amazonaws.com/#/");
        //   vr.closeChrome();
        vr.Chromeapp();

    }
    @Test
    public void Scrool_select() throws InterruptedException {
        homepage home =new homepage(driver);
        home.catagories();
        home.veriy_sunflower();
        Thread.sleep(7000);
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().accessibilityId(\"Masala Powders\").instance(0))").click();
       // driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(resourceId(\"Sunflower\"))");
      //  testclass ts=new testclass(driver);
      //  By elementLocator = By.xpath("//android.widget.ImageView[@content-desc='Sunflower Oil']");
     //   WebElement oil = driver.findElementByXPath("//android.widget.ImageView[@content-desc='Sunflower Oil']");
       // driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(accessibilityId(\"Masala Powders\"))");
       //  testclass.scrollUpToElement(driver,elementLocator);


    }

}
