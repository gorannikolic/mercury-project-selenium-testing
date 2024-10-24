package commonLibs.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    public static void waitForSeconds(int timeoutInSeconds) throws Exception {
        Thread.sleep(timeoutInSeconds * 1000);
    }

    public static void waitTillAlertIsPresent(WebDriver driver, Duration timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public static void waitTillElementVisible(WebDriver driver, WebElement element, Duration timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitTillElementSelectable(WebDriver driver, WebElement element, Duration timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeSelected(element));
    }

}
