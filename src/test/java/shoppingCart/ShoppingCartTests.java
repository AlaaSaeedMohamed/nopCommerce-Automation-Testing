package shoppingCart;

import SitePages.SearchPage;
import SitePages.ShoppingCartPage;
import SitePages.WishListPage;
import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ShoppingCartTests extends BaseTests {
    @Test
    public void TestAddToCart()
    {
        SearchPage searchPage = homePage.search();
        searchPage.setSearchString("laptop");
        searchPage.clickSearchButton();
        searchPage.scroll(1000);
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ShoppingCartPage shoppingCartPage = homePage.shoppingCart();
        shoppingCartPage.AddToCart();
    }

    @Test
    public void TestRemoveAllItems()
    {
        String emptyList = "Your Shopping Cart is empty!";
        TestAddToCart();
        ShoppingCartPage shoppingCartPage = homePage.shoppingCart();
        shoppingCartPage.scroll(-1000);
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        shoppingCartPage.goToShoppingCart();
        shoppingCartPage.removeItemsFromShoppingCart();
        assertEquals(shoppingCartPage.getResult(shoppingCartPage.emptyResult), emptyList, "Incorrect");
    }

    @Test
    public void TestShoppingCartIsEmpty()
    {
        String emptyList = "You have no items in your shopping cart.";
        ShoppingCartPage shoppingCartPage = homePage.shoppingCart();
        shoppingCartPage = shoppingCartPage.hoverOverCart();
        assertEquals(shoppingCartPage.getResult(shoppingCartPage.emptyCart), emptyList, "Incorrect");
    }
}
