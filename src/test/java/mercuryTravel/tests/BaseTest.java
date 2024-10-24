package mercuryTravel.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import commonLibs.implementation.CommonDriver;
import commonLibs.implementation.ScreenshotControl;
import commonLibs.utils.ConfigFilesUtils;
import commonLibs.utils.DateUtils;
import mercuryTravel.pages.Homepage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.Properties;

public class BaseTest {

    CommonDriver cmnDriver;
    WebDriver driver;
    String baseUrl;
    String browserType;
    Homepage homepage;
    int pageLoadTimeout;
    int elementDetectionTimeout;

    static String configFileName;
    static Properties configProperties;
    static String currentWorkingDirectory;
    static String executionStartDate;
    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;
    ExtentTest extentTest;
    String reportFileName;

    String screenshotFilename;
    ScreenshotControl screenshotControl;


    // executed first when class loaded and read config.properties file
    static {
        try {
            currentWorkingDirectory = System.getProperty("user.dir");
            executionStartDate = DateUtils.getCurrentDateAndTime();
            configFileName = currentWorkingDirectory + "/config/config.properties";
            configProperties = ConfigFilesUtils.readProperties(configFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //create report file
    @BeforeSuite
    public void preSetup() {
        initilizeReports();
    }

    @BeforeClass
    public void setup() throws Exception {
        invokeBrowser();
        getDriverInstance();
        initializeApplicationPages();
        initilizeScreenshotVariable();
    }

    @AfterClass
    public void cleanUp() throws Exception {
       closeAllBrowserInstances();
    }

    @AfterSuite
    public void postCleanUp() {
        extent.flush();
    }

    //taking screenshots if test fails
    @AfterMethod
    public void afterMethod(ITestResult result) throws Exception {
        String testcaseName = result.getName();
        String screenshotFilename = String.format("%s/screenshot/%s-%s.jpeg", currentWorkingDirectory, testcaseName, executionStartDate); // add path o screenshot directory

        if (result.getStatus() == ITestResult.SUCCESS) {
            extentTest.log(Status.PASS, "Test case pass -" + testcaseName);
        } else if (result.getStatus() == ITestResult.FAILURE) {
            extentTest.log(Status.FAIL, "Test case fail -" + testcaseName);

            screenshotControl.captureAndSaveScreenshot(screenshotFilename);  //screenshot capture and save
            extentTest.addScreenCaptureFromPath(screenshotFilename);        //add screenshot to report
        } else {
            extentTest.log(Status.SKIP, "Test case skiped -" + testcaseName);
        }
    }

    private void getDriverInstance() {
        driver = cmnDriver.getDriver();
    }

    private void invokeBrowser() throws Exception {
        extentTest = extent.createTest("Setup - Set up the pre-requisit to run automated test cases");  //add test case

        browserType = configProperties.getProperty("browserType");
        extentTest.log(Status.INFO, "Browser invoked is " + browserType); //add logs

        cmnDriver = new CommonDriver(browserType);

        pageLoadTimeout = Integer.parseInt(configProperties.getProperty("pageLoadTimeout"));
        extentTest.log(Status.INFO, "Page load timeout set is - " + pageLoadTimeout); //add logs

        elementDetectionTimeout = Integer.parseInt(configProperties.getProperty("elementDetectionTimeout"));
        extentTest.log(Status.INFO, "Element Detection timeoput set is - " + elementDetectionTimeout); //add logs

        cmnDriver.setPageLoadTimeout(pageLoadTimeout);
        cmnDriver.setElementDetectionTimeout(elementDetectionTimeout);

        baseUrl = configProperties.getProperty("baseUrl");
        extentTest.log(Status.INFO, "Base URL where browser navigates to - " + baseUrl); //add logs
        cmnDriver.navigateToFirstUrl(baseUrl);
    }

    private void initializeApplicationPages() {
        extentTest.log(Status.INFO, "Initilizing all pages "); //add logs
        homepage = new Homepage(driver);
    }

    private void initilizeScreenshotVariable() {
        screenshotControl = new ScreenshotControl(driver);
    }

    private void initilizeReports() {
        reportFileName = String.format("%s/reports/MercuryTravelTestReport-%s.html", currentWorkingDirectory, executionStartDate);
        htmlReporter = new ExtentHtmlReporter(reportFileName);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }
    private void closeAllBrowserInstances() throws Exception{
        cmnDriver.closeAllBrowsers();
        extentTest = extent.createTest("Clean up - Clean process"); //add test case
        extentTest.log(Status.INFO, "Closing all browser instances " + baseUrl); //add logs
    }
}
