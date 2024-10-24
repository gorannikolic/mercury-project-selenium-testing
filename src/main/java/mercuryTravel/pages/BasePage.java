package mercuryTravel.pages;

import commonLibs.implementation.*;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected AlertControl alertControl;
    protected CommonElement elementControl;
    protected DropdownControl dropdownControl;
    protected MouseControl mouseControl;
    protected FrameControl frameControl;
    protected ScreenshotControl screenshotControl;
    protected WindowControl windowControl;

    public BasePage(WebDriver driver) {
        alertControl = new AlertControl(driver);
        elementControl = new CommonElement();
        mouseControl = new MouseControl(driver);
        dropdownControl = new DropdownControl();
        frameControl = new FrameControl(driver);
        screenshotControl = new ScreenshotControl(driver);
        windowControl = new WindowControl(driver);
    }
}
