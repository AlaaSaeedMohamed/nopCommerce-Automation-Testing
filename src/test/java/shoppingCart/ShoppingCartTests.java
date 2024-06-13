package shoppingCart;

import SitePages.SearchPage;
import SitePages.ShoppingCartPage;
import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ShoppingCartTests extends BaseTests {
    @Test(priority = 1)
    public void TestAddToCart()
    {
        SearchPage searchPage = homePage.search();
        searchPage.setSearchString("laptop");
        searchPage.clickSearchButton();
        homePage.scroll(1000);
        ShoppingCartPage shoppingCartPage = homePage.shoppingCart();
        shoppingCartPage.WaitForLoading();
        shoppingCartPage.AddToCart();
    }

    @Test(priority = 2)
    public void TestRemoveAllItems()
    {
        String emptyList = "Your Shopping Cart is empty!";
        TestAddToCart();
        ShoppingCartPage shoppingCartPage = homePage.shoppingCart();
        homePage.scroll(-1000);
        shoppingCartPage.closeButton();
        shoppingCartPage.goToShoppingCart();
        shoppingCartPage.removeItemsFromShoppingCart();
        shoppingCartPage.WaitForVisible(shoppingCartPage.emptyResult);
        assertEquals(shoppingCartPage.getResult(shoppingCartPage.emptyResult), emptyList, "Incorrect");
    }

    @Test(priority = 3)
    public void TestShoppingCartIsEmpty()
    {
        String emptyList = "You have no items in your shopping cart.";
        ShoppingCartPage shoppingCartPage = homePage.shoppingCart();
        shoppingCartPage = shoppingCartPage.hoverOverCart();
        shoppingCartPage.WaitForVisible(shoppingCartPage.emptyCart);
        assertEquals(shoppingCartPage.getResult(shoppingCartPage.emptyCart), emptyList, "Incorrect");
    }
}
