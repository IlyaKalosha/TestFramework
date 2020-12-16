package Tests;

import Pages.FavouriteListPage;
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
        Assert.assertTrue(
                "You have wrong creditals",
                mainPage.signInElement
                        .loginUser(testUser)
                        .signInElement
                        .isTestUserLoggedIn(testUser)
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

    @Test
    public void testAdditionToFavouriteList(){
        User testUser = UserCreator.withCredentialsFromProperty();
        MainPage mainPage = new MainPage(driver).signInElement.loginUser(testUser);

        Item testItem = ItemCreator.withFieldsFromProperty();
        ProductPage productPage = new ProductPage(driver, testItem);
        productPage.addToFavouriteList();
        FavouriteListPage favouriteListPage = productPage.openFavouriteList();
        Assert.assertTrue(
                "There is no such an element",
                favouriteListPage.isThereElement(testItem)
        );
        favouriteListPage.deleteAddedItem();
        mainPage.signInElement.logOutUser();
    }
}
