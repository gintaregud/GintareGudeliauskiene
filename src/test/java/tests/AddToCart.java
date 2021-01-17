package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.CommonPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static utils.WaitUtils.waitMiliseconds;

public class AddToCart extends BaseTest {

    @Test(dataProvider = "products")
    public void AddToCart(String productToAdd) {
        CommonPage commonPage = new CommonPage(driver);
        CategoryPage categoryPage = new CategoryPage(driver);
        String categoryToOpen = "Nereceptiniai vaistai";
        String expectedMessage = "Success: You have added " + productToAdd + " to your shopping cart!";
        commonPage.expandMainCategory(categoryToOpen);
        assertEquals(categoryPage.getCategoryName(), categoryToOpen, "Wrong category opened");
        categoryPage.changeToListView();
        categoryPage.addProductToBasket(productToAdd);
        waitMiliseconds(1000);
        assertTrue(commonPage.getMessageText().contains(expectedMessage), "Message was different than expected");
        commonPage.openMiniCart();
        assertEquals(commonPage.getProductNameInMiniCart(), productToAdd, "Wrong product has been added to cart");
    }

    private void waitMiliseconds(int i) {
    }

    @DataProvider(name = "products")
    public Object[][] products() {
        return new Object[][]{
                {"Gripex, plėvele dengtos tabletės, N12 "},
                {"Gripex, plėvele dengtos tabletės, N24 "}

        };
    }
}
