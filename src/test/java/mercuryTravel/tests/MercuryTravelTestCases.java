package mercuryTravel.tests;


import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestDataProvider;

public class MercuryTravelTestCases extends BaseTest {

    @Test
    public void verifyLoginWithCorrectCredentials() throws Exception {

        extentTest = extent.createTest("TC-001 - Verify User Login with correct credentials");

        String username = configProperties.getProperty("userEmailId");
        extentTest.log(Status.INFO, "User Email ID is " + username);
        String password = configProperties.getProperty("userPassword");
        extentTest.log(Status.INFO, "User password is " + password);

        homepage.userLogin(username, password);

        String expectedWelcomeText = configProperties.getProperty("expectedWelcomeText");
        String actualWelcomeText = homepage.getWelcomeMessage();
        Assert.assertEquals(actualWelcomeText, expectedWelcomeText);
        extentTest.log(Status.INFO, "User Login Successful");

        homepage.LogOut();
    }

    @Test(dataProvider = "getUserData", dataProviderClass = TestDataProvider.class)
    public void verifyLoginWithCorrectCredentials(String username, String password, String expectedWelcomeText) throws Exception {

        extentTest = extent.createTest("TC-001 - Verify User Login with correct credentials" + username + password);

        extentTest.log(Status.INFO, "User Email ID is " + username);
        extentTest.log(Status.INFO, "User password is " + password);

        homepage.userLogin(username, password);

        String actualWelcomeText = homepage.getWelcomeMessage();
        Assert.assertEquals(actualWelcomeText, expectedWelcomeText);
        extentTest.log(Status.INFO, "User Login Successful");

        homepage.LogOut();

    }

//    @Test
//    public void verifyUserRegisterWithCorrectData() throws Exception {
//        extentTest = extent.createTest("TC-002 - Verify User Registration with correct credentials");
//
//        String firstName = configProperties.getProperty("firstName");
//        String lastName = configProperties.getProperty("lastName");
//        String emailAddress = configProperties.getProperty("userEmailAddress");
//        String userPassword = configProperties.getProperty("registerUserPassword");
//        String confirmPassword = configProperties.getProperty("confirmPassword");
//        String countryCode = configProperties.getProperty("countryCode");
//        String mobileNumber = configProperties.getProperty("mobileNumber");
//
//        homepage.registerUser(firstName,lastName, emailAddress, userPassword,confirmPassword,countryCode,mobileNumber);
//
//        String expectedRegistrationText = configProperties.getProperty("expectedSuccesfullRegistrationText");
//        String actualRegistrationText = homepage.getSuccessfulRegistrationMessage();
//        Assert.assertEquals(actualRegistrationText, expectedRegistrationText);
//        extentTest.log(Status.INFO, "User Login Successful");
//    }
}
