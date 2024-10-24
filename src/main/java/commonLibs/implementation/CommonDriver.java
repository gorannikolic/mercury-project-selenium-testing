package commonLibs.implementation;

import commonLibs.contracts.IDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class CommonDriver implements IDriver {

    private WebDriver driver;
    private int pageLoadTimeout;
    private int elementDetectionTimeout;
    private String currentWorkingDirectory = System.getProperty("user.dir");


    public CommonDriver(String browserType) throws Exception {

        pageLoadTimeout = 60;
        elementDetectionTimeout = 10;

        if (browserType.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chromedriver", currentWorkingDirectory + "/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.msedgedriver", currentWorkingDirectory + "/drivers/msedgedriver.exe");
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("Invalid Browser Type");
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setPageLoadTimeout(int pageLoadTimeout) {
        this.pageLoadTimeout = pageLoadTimeout;
    }
    public void setElementDetectionTimeout(int elementDetectionTimeout) {
        this.elementDetectionTimeout = elementDetectionTimeout;
    }

    @Override
    public void navigateToFirstUrl(String url) throws Exception {
        driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(elementDetectionTimeout, TimeUnit.SECONDS);
        url = url.trim();
        driver.get(url);
    }

    @Override
    public String getTitle() throws Exception {
        return driver.getTitle();
    }

    @Override
    public String getCurrentUrl() throws Exception {
        return driver.getCurrentUrl();
    }

    @Override
    public String getPageSource() throws Exception {
        return driver.getPageSource();
    }

    @Override
    public void navigateUrl(String url) throws Exception {
        url = url.trim();
        driver.navigate().to(url);

    }

    @Override
    public void navigateForward() throws Exception {
        driver.navigate().forward();
    }

    @Override
    public void navigateBackward() throws Exception {
        driver.navigate().back();
    }

    @Override
    public void refresh() throws Exception {
        driver.navigate().refresh();
    }

    @Override
    public void closeBrowser() throws Exception {
        if (driver != null) {
            driver.close();
        }
    }

    @Override
    public void closeAllBrowsers() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }
}
