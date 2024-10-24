package commonLibs.implementation;

import commonLibs.contracts.IAlert;
import commonLibs.utils.WaitUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class AlertControl implements IAlert {

    private WebDriver driver;

    public AlertControl(WebDriver driver) {
        this.driver = driver;
    }

    private Alert getAlert() {
        return driver.switchTo().alert();
    }

    @Override
    public void acceptAlert() throws Exception {
        getAlert().accept();
    }

    @Override
    public void rejectAlert() throws Exception {
        getAlert().dismiss();

    }

    @Override
    public String getMessageFromAlert() throws Exception {
        return getAlert().getText();
    }

    @Override
    public boolean checkAlertPresent(Duration timeoutInSecond) throws Exception {
        try {
            WaitUtils.waitTillAlertIsPresent(driver, timeoutInSecond);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
