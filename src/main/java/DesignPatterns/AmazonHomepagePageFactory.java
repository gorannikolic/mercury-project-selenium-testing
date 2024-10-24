package DesignPatterns;

import commonLibs.implementation.CommonElement;
import commonLibs.implementation.DropdownControl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

public class AmazonHomepagePageFactory {
    @CacheLookup
    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;
    @CacheLookup
    @FindBy(id = "searchDropdownBox")
    private WebElement searchCategory;
    @CacheLookup
    @FindBy(id = "nav-search-submit-button")
    private WebElement searchButton;
    @FindBy(xpath="//span[contains(text(),'results for')]")
    private WebElement searchResult;

    private CommonElement elementControl;
    private DropdownControl dropdownControl;

    public AmazonHomepagePageFactory(WebDriver driver) {
        PageFactory.initElements(driver, this);
        elementControl = new CommonElement();
        dropdownControl = new DropdownControl();
    }

    //search logic
    public void searchProduct(String product, String category) throws Exception {
        elementControl.setText(searchBox, product);                                      //set text in search box
        dropdownControl.selectViaVisibleText(searchCategory, category);                 //select category from dropdown
        elementControl.clickElement(searchButton);                                     //click on search button
        System.out.println(elementControl.getText(searchResult));
    }
}
