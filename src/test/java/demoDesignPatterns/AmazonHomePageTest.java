package demoDesignPatterns;

import DesignPatterns.AmazonHomepage;
import commonLibs.implementation.CommonDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AmazonHomePageTest {

    CommonDriver cmnDriver;
    String url = "https://www.amazon.de/-/en/ref=nav_logo";

    WebDriver driver;
    AmazonHomepage homepage;

    @BeforeClass
    public void invokeBrowser() throws Exception {
        cmnDriver = new CommonDriver("chrome");
        cmnDriver.setPageLoadTimeout(60);
        cmnDriver.setElementDetectionTimeout(10);
        cmnDriver.navigateToFirstUrl(url);
        driver = cmnDriver.getDriver();
        homepage = new AmazonHomepage(driver);
    }

    @Test
    public void searchProduct() throws Exception {
        String product = "iPhone";
        String category = "Electronics & Photo";

        homepage.searchProduct(product, category);
    }

    @AfterClass
    public void closeBrowser() throws Exception {
        cmnDriver.closeAllBrowsers();
    }

}
