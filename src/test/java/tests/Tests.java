package tests;

import model.SearchStatement;
import pages.FavouriteListPage;
import pages.ListOfProductsPage;
import pages.MainPage;
import pages.ProductPage;
import rervice.ItemCreator;
import rervice.SearchStatementCreator;
import rervice.UserCreator;
import model.Item;
import model.User;
import org.junit.Assert;
import org.testng.annotations.Test;

public class Tests extends CommonConditions {

    @Test
    public void testLogin() {
        User testUser = UserCreator.withCredentialsFromProperty();
        MainPage mainPage = new MainPage(driver);

        try {
            Assert.assertEquals("You have wrong creditals",
                    testUser.getSurname(),
                    mainPage.signInElement
                            .loginUser(testUser)
                            .signInElement
                            .getUserSurname()
                    );
        }finally {
            mainPage.signInElement
                    .logOutUser();
        }
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
        User testUser;
        MainPage mainPage = new MainPage(driver);
        Item testItem;
        ProductPage productPage;
        FavouriteListPage favouriteListPage;

        try{
            testUser = UserCreator.withCredentialsFromProperty();
            mainPage = new MainPage(driver).signInElement.loginUser(testUser);

            testItem = ItemCreator.withFieldsFromProperty();
            productPage = new ProductPage(driver, testItem);
            productPage.addToFavouriteList();
            favouriteListPage = productPage.openFavouriteList();
            Assert.assertTrue(
                    "There is no such an element",
                    favouriteListPage.isThereElement(testItem)
                            );
            favouriteListPage.deleteAddedItem();
        }
        finally{
            mainPage.signInElement.logOutUser();
        }
    }

    @Test
    public void testSearch(){
        MainPage mainPage = new MainPage(driver);
        SearchStatement testSearchStatement = SearchStatementCreator.withFieldsFromProperty();
        ListOfProductsPage listOfProductsPage = mainPage.search(testSearchStatement.getStatement());
    }
}
