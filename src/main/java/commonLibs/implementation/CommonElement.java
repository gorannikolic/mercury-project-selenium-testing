package commonLibs.implementation;

import commonLibs.contracts.ICommonElement;
import org.openqa.selenium.WebElement;

public class CommonElement implements ICommonElement {

    @Override
    public String getText(WebElement element) throws Exception {
        return element.getText();
    }

    @Override
    public void clickElement(WebElement element) throws Exception {
        element.click();
    }

    @Override
    public String getAttribute(WebElement element, String attribute) throws Exception {
        return element.getAttribute(attribute);
    }

    @Override
    public String getCssValue(WebElement element, String cssPropertyName) throws Exception {
        return element.getCssValue(cssPropertyName);
    }

    @Override
    public boolean isElementEnabled(WebElement element) throws Exception {
        return element.isEnabled();
    }

    @Override
    public boolean isElementVisible(WebElement element) throws Exception {
        return element.isDisplayed();
    }

    @Override
    public boolean isElementSelected(WebElement element) throws Exception {
        return element.isSelected();
    }

    @Override
    public void setText(WebElement element, String textToWrite) throws Exception {
        element.sendKeys(textToWrite);
    }

    @Override
    public void clearText(WebElement element) throws Exception {
        element.clear();
    }

    @Override
    public void changeCheckboxStatus(WebElement element, boolean expectedStatus) throws Exception {
        boolean currentStatus = element.isSelected();
        if (currentStatus!=expectedStatus){
            element.click();
        }
    }

    @Override
    public int getXlocation(WebElement element) throws Exception {
        return element.getLocation().x;
    }

    @Override
    public int getYlocation(WebElement element) throws Exception {
        return element.getLocation().y;
    }
}
