package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.IExpectedExceptionsHolder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Login {

    private Object WebElement;

    @Test
    public void login() throws InterruptedException {
        String email = "testas@testas.com";
        String password = "Testauskas10";
        String passwordText ="Pakartokite slaptazodi";

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(10000);
        driver.get("https://www.eurovaistine.lt/");



        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        driver.findElement(By.cssSelector("a[href$='login']")).click();



        boolean newLoginFormVisible = driver.findElement(By.cssSelector("a[href$='login']")).isDisplayed();
        boolean returningRegistrationFormVisible = driver.findElement(By.cssSelector(".header-user.collapse")).isDisplayed();
        assertTrue("Prisijungimo forma nera matoma", newLoginFormVisible);
        assertTrue("Registracijos forma nera matoma", returningRegistrationFormVisible);


        
        driver.findElement(By.id("_username")).sendKeys(email);
        driver.findElement(By.id("_password")).sendKeys(password);
        WebElement = driver.findElement(By.id("_password"));
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        org.openqa.selenium.WebElement cbox;
        WebElement = cbox = driver.findElement(By.id("customer_registration_marketing_generalOffers"));
        cbox.click();
        WebElement = cbox = driver.findElement(By.id("customer_registration_marketing_personalOffers"));
        cbox.click();
        driver.findElement(By.id("auth_login")).sendKeys("username");
        driver.findElement(By.id("auth_login_password")).sendKeys("password");



        driver.quit();
    }
}
