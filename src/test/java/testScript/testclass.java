package testScript;
import bassclass.BaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;
import pages.PomPage;

import java.time.Duration;
public class testclass extends PomPage {
    public testclass(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public static void scrollUpToElement(AndroidDriver<AndroidElement> driver, By elementLocator) {
        boolean isElementVisible = false;
        int maxScrollAttempts = 5;
        int attempts = 0;

        while (!isElementVisible && attempts < maxScrollAttempts) {
            try {
                MobileElement element = driver.findElement(elementLocator);
                if (element.isDisplayed()) {
                    isElementVisible = true;
                }
            } catch (org.openqa.selenium.NoSuchElementException e) {
                // Scroll up
                scrollUp(driver);
            }
            attempts++;
        }

        if (!isElementVisible) {
            throw new org.openqa.selenium.NoSuchElementException("Element not found after scrolling " + maxScrollAttempts + " times.");
        }
    }

    private static void scrollUp(AndroidDriver<AndroidElement> driver) {
        // Get the device screen dimensions
        Dimension size = driver.manage().window().getSize();

        // Set the start and end coordinates for the scroll action
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);

        // Perform the scroll action from the start coordinates to the end coordinates
        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
                .moveTo(PointOption.point(startX, endY))
                .release()
                .perform();
    }

}




