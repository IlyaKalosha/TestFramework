package Tests;

import Pages.MainPage;
import Pages.ProductPage;
import Service.ItemCreator;
import Service.UserCreator;
import model.Item;
import model.User;
import org.junit.Assert;
import org.testng.annotations.Test;

public class Tests extends CommonConditions {

    @Test
    public void testLogin() {
        User testUser = UserCreator.withCredentialsFromProperty();
        MainPage mainPage = new MainPage(driver);
        mainPage.signInElement
                .loginUser(testUser);
        Assert.assertTrue(
                "You have wrong creditals",
                mainPage.signInElement
                        .isLoggedIn("Kalosha")
        );
        mainPage.signInElement
                .logOutUser();
    }

    @Test
    public void testAdditionToCart() {
        Item testItem = ItemCreator.withFieldsFromProperty();
        ProductPage productPage = new ProductPage(driver, testItem);
        productPage.addToCart();
        Assert.assertTrue(
                "There is no such an element",
                productPage.openCart()
                        .isThereElement(testItem)
        );
    }
}
