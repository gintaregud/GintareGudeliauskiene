package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //------------Locators---------------------
    By loginForm = By.cssSelector(".header-user.collapse");
    By continueButton = By.cssSelector(".header-user.collapse");
    By emailInputField = By.id("input-email");
    By passwordInputField = By.name("password");
    By loginButton = By.xpath("//input[@value='Login']");
    public boolean newCustomerBlockVisible() {
        return driver.findElement(continueButton).isDisplayed();
    }
    public boolean returningCustomerBlockVisible() {
        return driver.findElement(loginForm).isDisplayed();
    }
    public void loginWithCredentials(String email, String password) {
        enterEmailAddress(email);
        enterPassword(password);
        clickLoginButton();
    }
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
    public void enterEmailAddress(String email) {
        driver.findElement(emailInputField).sendKeys(email);
    }
    public void enterPassword(String password) {
        driver.findElement(passwordInputField).sendKeys(password);
    }
}