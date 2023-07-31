package bassclass;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.URL;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Listeners(bassclass.Listner.class)


public class BaseClass {
    public static AndroidDriver driver;
    public static AppiumDriverLocalService service;
    
    @BeforeClass
    public void lunchserver() {
        /*Map<String,String>evn=new HashMap<String,String>(System.getenv());
        System.setProperty("ANDROID_HOME","/home/maria/Android/Sdk");
        System.setProperty("ANDROID_SDK_ROOT","/home/maria/Android/Sdk");*/
        System.setProperty("JAVA_HOME", "/usr/lib/jvm/java-11-openjdk-amd64");
        
        service = new AppiumServiceBuilder().withIPAddress("127.0.0.1").usingPort(4724)
                          .withEnvironment(Map.of("ANDROID_HOME", "/home/maria/Android/Sdk", "ANDROID_SDK_ROOT", "/home/maria/Android/Sdk"))
                          .build();
        service.start();
    }
    
    @BeforeMethod
    public void lunchApp() throws InterruptedException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13");
        cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        cap.setCapability("appPackage", "com.exathought.vikray.mobile.customer.stage");
        cap.setCapability("appActivity", "com.exathought.vikray.mobile.customer.stage.MainActivity");
        cap.setCapability("noReset", true);
        
        
        try {
            driver = new AndroidDriver(new URL("http://localhost:4724/wd/hub/"), cap);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        Thread.sleep(2000);
        //  AppiumDriverManager.getAppiumDriver().manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
/*

        boolean isAppInstalled = driver.isAppInstalled("com.carparts.app");
        if (isAppInstalled) {
            driver.startActivity(new Activity("com.carparts.app", "com.carparts.app.MainActivity"));
        } else {
            String apkPath = System.getProperty("user.dir") + "/APK/base.apk";
            driver.installApp(apkPath);
        }

*/
    }
    
    
    @AfterMethod
    public void Appose() {
        System.out.println("Application is closed successfully");
        driver.closeApp();
        
    }
    
    @AfterClass
    public void StopappiumServer() {
        try {
            service.stop();
        } catch (Exception e) {
            
            e.printStackTrace();
        } finally {
            
            System.out.println("Server close sucessfully");
        }
        
        
    }
}