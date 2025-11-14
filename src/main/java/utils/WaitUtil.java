package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class WaitUtil {

    private AndroidDriver<MobileElement> driver;
    private WebDriverWait wait;

    public WaitUtil(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public MobileElement waitForVisible(By locator) {
        return (MobileElement) wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
    }

    public MobileElement waitForClickable(By locator) {
        return (MobileElement) wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        );
    }
}
