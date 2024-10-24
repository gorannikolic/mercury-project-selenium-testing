package DesignPatterns;

import commonLibs.implementation.CommonElement;
import commonLibs.implementation.DropdownControl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonHomepage {

    private WebElement searchBox;
    private WebElement searchCategory;
    private WebElement searchButton;

    private CommonElement elementControl;
    private DropdownControl dropdownControl;

    public AmazonHomepage(WebDriver driver) {
        searchBox = driver.findElement(By.id("twotabsearchtextbox"));                   // find elements
        searchCategory = driver.findElement(By.id("searchDropdownBox"));
        searchButton = driver.findElement(By.id("nav-search-submit-button"));
        elementControl = new CommonElement();
        dropdownControl= new DropdownControl();
    }
     //search logic
    public void searchProduct(String product, String category) throws Exception {
        elementControl.setText(searchBox, product);                                      //set text in search box
        dropdownControl.selectViaVisibleText(searchCategory, category);                 //select category from dropdown
        elementControl.clickElement(searchButton);                                     //click on search button
    }
}
