package bassclass;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;

public class AppiumDriverManager {

    private static ThreadLocal<AppiumDriver> appiumDriverThreadLocal = new ThreadLocal<>();

    public static WebDriver getAppiumDriver() {
        return appiumDriverThreadLocal.get();
    }

    public static void setAppiumDriver(WebDriver Driver) {
        appiumDriverThreadLocal.set((AppiumDriver) Driver);
    }
}
