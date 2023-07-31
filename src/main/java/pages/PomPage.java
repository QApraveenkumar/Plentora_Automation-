package pages;

import bassclass.AppiumDriverManager;
import bassclass.MobileInteraction;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public  class PomPage {
    public AndroidDriver driver;
    MobileInteraction action=new MobileInteraction();
    public PomPage(AndroidDriver driver)

    {
           this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


}
