package tests;

import model.Card;
import model.SearchStatement;
import pages.*;
import rervice.*;
import model.Item;
import model.User;
import org.junit.Assert;
import org.testng.annotations.Test;

public class Tests extends CommonConditions {

    @Test(priority = 1)
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

    @Test(priority = 2)
    public void testLogOut() {
        User testUser = UserCreator.withCredentialsFromProperty();
        MainPage mainPage = new MainPage(driver);
        mainPage.signInElement.loginUser(testUser).signInElement.logOutUser();
        Assert.assertEquals("Logged In",
                                "Вход",
                                    mainPage.signInElement.getLogoutWord());
    }

    @Test(priority = 3)
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

    @Test(priority = 4)
    public void testAdditionToFavouriteList(){
        User testUser;
        MainPage mainPage = new MainPage(driver);
        Item testItem;
        ProductPage productPage;
        FavouriteListPage favouriteListPage;

        try{
            testUser = UserCreator.withCredentialsFromProperty();
            mainPage = new MainPage(driver)
                            .signInElement
                            .loginUser(testUser);

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
            mainPage
                    .signInElement
                    .logOutUser();
        }
    }

    @Test(priority = 5)
    public void testSearch(){
        MainPage mainPage = new MainPage(driver);
        SearchStatement testSearchStatement = SearchStatementCreator.withFieldsFromProperty();

        ListOfProductsPage listOfProductsPage = mainPage.search(testSearchStatement.getStatement());
        Assert.assertTrue("Search results are empty",
                            listOfProductsPage
                                    .getSearchResults(testSearchStatement));
    }

    @Test(priority = 6)
    public void testDiscount(){
        Item testItem = ItemCreator.withFieldsFromProperty();
        ProductPage productPage = new ProductPage(driver, testItem);

        productPage.addToCart();
        Assert.assertEquals(
                "There is no such an element",
                testItem.getDiscountCost(),
                productPage.openCart()
                        .getCurrentCost()
        );
    }

    @Test(priority = 7)
    public void testPayment(){
        Card testCard = CardCreator.withFieldsFromProperty();
        User testUser = UserCreator.withCard(testCard);

        String errorCode = new BillPage(driver)
                                                .openBillPage()
                                                .login(testUser)
                                                .enterValue(testUser)
                                                .pay(testUser);
        Assert.assertEquals("Cart is not valid",
                                    testCard.getErrorCode(),
                                    errorCode);
    }

    @Test(priority = 8)
    public void testChangeLang(){
        MainPage mainPage = new MainPage(driver);

        Assert.assertEquals("language has not been changes",
                "Log in",
                mainPage.changeLang()
                        .getMenuLang());
    }

    @Test(priority = 9)
    public void testMakeUpDiscounts(){
        ListOfProductsPage makeUpPage = new ListOfProductsPage(driver)
                .openListOfProdpage(TestDataReader.getPage("testdata.page.makeup"));
        makeUpPage.promotionFilterOn();
        Assert.assertTrue("Error promotions selection",makeUpPage.isAllItemsHavePromotion());
    }

    @Test(priority = 10)
    public void testDiscountWithTwoProducts(){
        Item testItem = ItemCreator.withFieldsFromProperty();
        ProductPage productPage = new ProductPage(driver, testItem);
        productPage.addToCart();

        productPage = new ProductPage(driver, testItem);
        productPage.addToCart();
        Assert.assertEquals(
                "There is no such an element",
                testItem.getDiscountCost(),
                productPage.openCart()
                        .getCurrentCost()
        );
    }
}
