package commonLibs.contracts;

import org.openqa.selenium.WebElement;

import java.util.List;

public interface IDropdown {

    public void selectViaVisibleText (WebElement element, String visibleText) throws Exception;
    public void selectViaValue (WebElement element, String value) throws Exception;
    public void selectViaIndex (WebElement element, int index) throws Exception;
    public List<WebElement> getAllOptions (WebElement element);

}
