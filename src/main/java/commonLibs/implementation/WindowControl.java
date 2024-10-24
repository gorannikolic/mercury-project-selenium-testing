package commonLibs.implementation;

import commonLibs.contracts.IWindowHandle;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowControl implements IWindowHandle {

    private WebDriver driver;

    public WindowControl(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void switchToAnyWindow(String windowHandle) throws Exception {
        driver.switchTo().window(windowHandle);

    }

    @Override
    public void switchToAnyWindow(int childWindowIndex) throws Exception {
        String childWindowHandle = driver.getWindowHandles().toArray()[childWindowIndex].toString();
        driver.switchTo().window(childWindowHandle);

    }

    @Override
    public String getWindowHandle() throws Exception {
        return driver.getWindowHandle();
    }

    @Override
    public Set<String> getWindowHandles() throws Exception {
        return driver.getWindowHandles();
    }
}
