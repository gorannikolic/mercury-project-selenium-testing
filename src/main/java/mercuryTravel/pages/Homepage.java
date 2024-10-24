package mercuryTravel.pages;

import commonLibs.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends BasePage {

    @FindBy(linkText = "International Holidays")
    private WebElement internationalHolidaysLink;

    @FindBy(linkText = " Indian Holidays")
    private WebElement indianHolidaysLink;

    @FindBy(linkText = "Luxury Rails")
    private WebElement luxuryRailsLink;

    @FindBy(linkText = "Preferred Holidays")
    private WebElement preferredHolidaysLink;

    @FindBy(linkText = "Mice")
    private WebElement miceLink;

    @FindBy(linkText = "Flights")
    private WebElement flightsLink;

    @FindBy(linkText = "Hotels")
    private WebElement hotelsLink;

    @FindBy(linkText = "Foreign Exchange")
    private WebElement foreignExchangeLink;

    @FindBy(linkText = "Insurance")
    private WebElement insuranceLink;

    @FindBy(linkText = "Customer Login")
    private WebElement customerLogin;

    @FindBy(linkText = "User Login")
    private WebElement userLogin;

    @FindBy(linkText = "Register")
    private WebElement register;

    @FindBy(id = "sign_user_email")
    private WebElement userId;

    @FindBy(id = "sign_user_password")
    private WebElement userPassword;

    @FindBy(xpath = "//button[text()='Log in']")
    private WebElement loginButton;

    @FindBy(id = "acc_first_name")
    private WebElement registerFirstName;

    @FindBy(id = "acc_last_name")
    private WebElement registerLastName;

    @FindBy(id = "acc_user_email")
    private WebElement registerUserEmail;

    @FindBy(id = "acc_user_password")
    private WebElement registerUserPassword;

    @FindBy(id = "acc_user_passconf")
    private WebElement confirmUserPassword;

    @FindBy(name = "countrycode")
    private WebElement userCountryCode;

    @FindBy(id = "acc_mobile_no")
    private WebElement registerMobileNumber;

    @FindBy(xpath = "//button[text()='Register']")
    private WebElement registerButton;

    @FindBy(partialLinkText = "Welcome,")
    private WebElement welcomeText;

    @FindBy(id="myModalLabel")
    private WebElement successfulRegistrationMessage;

    @FindBy(partialLinkText = "Log Out")
    private WebElement logOut;

    public Homepage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void userLogin(String username, String password) throws Exception {
        mouseControl.moveToElement(customerLogin);
        mouseControl.moveToElementAndClick(userLogin);
        WaitUtils.waitForSeconds(3);
        elementControl.setText(userId, username);
        WaitUtils.waitForSeconds(3);
        elementControl.setText(userPassword, password);
        elementControl.clickElement(loginButton);
    }

    //if login successful then we got "welcome" message
    public String getWelcomeMessage() throws Exception {
        return elementControl.getText(welcomeText);
    }

    public void LogOut() throws Exception {
        mouseControl.moveToElement(welcomeText);
        mouseControl.moveToElementAndClick(logOut);
    }

    public void registerUser(String firstName, String lastName, String emailAddress, String userPassword, String confirmPassword, String countryCode, String mobileNumber) throws Exception {
        mouseControl.moveToElement(customerLogin);
        mouseControl.moveToElementAndClick(register);
        elementControl.setText(registerFirstName, firstName);
        elementControl.setText(registerLastName, lastName);
        elementControl.setText(registerUserEmail, emailAddress);
        elementControl.setText(registerUserPassword, userPassword);
        elementControl.setText(confirmUserPassword, confirmPassword);
        dropdownControl.selectViaVisibleText(userCountryCode, countryCode);
        elementControl.setText(registerMobileNumber, mobileNumber);
        elementControl.clickElement(registerButton);
    }

    public String getSuccessfulRegistrationMessage() throws Exception {
        return elementControl.getText(successfulRegistrationMessage);
    }
}
