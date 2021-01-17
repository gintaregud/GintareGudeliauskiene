package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utils.CommonUtils;
public class CommonPage {
    WebDriver driver;
    public CommonPage(WebDriver driver) {
        this.driver = driver;
    }
    //-------------Locators----------------
    By myAccountLink = By.xpath(".header-user.collapse");
    By loginLink = By.cssSelector("a[href$='login']");
    By miniCart = By.id(".header-user.collapse");
    By productNameInMiniCart = By.cssSelector("");
    By messageBlock = By.cssSelector("");
    public By getLinkTextLocator(String linkText) {
        return By.linkText(linkText);
    }



    //------------Methods------------------
    public void openLoginPage() {
        driver.findElement(myAccountLink).click();
        driver.findElement(loginLink).click();
    }
    public void openMiniCart() {
        driver.findElement(miniCart).click();
    }
    public String getProductNameInMiniCart() {
        return driver.findElement(productNameInMiniCart).getText();
    }
    public String getMessageText() {
        return driver.findElement(messageBlock).getText();
    }
    public void expandMainCategory(String categoryToOpen) {
        //CommonUtils.hoverOverElement(driver, getLinkTextLocator(categoryToOpen));
    }
    public void openSubCategory(String subCategoryToOpen) {
        driver.findElement(By.linkText(subCategoryToOpen)).click();
    }
}
