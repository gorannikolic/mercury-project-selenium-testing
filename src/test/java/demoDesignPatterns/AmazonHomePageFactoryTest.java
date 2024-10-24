package demoDesignPatterns;

import DesignPatterns.AmazonHomepagePageFactory;
import commonLibs.implementation.CommonDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AmazonHomePageFactoryTest {

    CommonDriver cmnDriver;
    String url = "https://www.amazon.in/";

    WebDriver driver;
    AmazonHomepagePageFactory homepageFactory;

    @BeforeClass
    public void invokeBrowser() throws Exception {
        cmnDriver = new CommonDriver("chrome");
        cmnDriver.setPageLoadTimeout(60);
        cmnDriver.setElementDetectionTimeout(10);
        cmnDriver.navigateToFirstUrl(url);
        driver = cmnDriver.getDriver();
        homepageFactory = new AmazonHomepagePageFactory(driver);
    }

    @Test
    public void searchProduct() throws Exception {
        String product = "iPhone";
        String category = "Electronics";

        homepageFactory.searchProduct(product, category);
    }

    @AfterClass
    public void closeBrowser() throws Exception {
        cmnDriver.closeAllBrowsers();
    }

}
