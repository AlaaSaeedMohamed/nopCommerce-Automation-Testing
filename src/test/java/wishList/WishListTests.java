package wishList;

import SitePages.SearchPage;
import SitePages.WishListPage;
import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WishListTests extends BaseTests {
    @Test
    public void TestAddToWishList()
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
        WishListPage wishListPage = homePage.wishList();
        wishListPage.AddToWishList();
    }

    @Test
    public void TestRemoveAllItems()
    {
        String emptyList = "The wishlist is empty!";
        TestAddToWishList();
        WishListPage wishListPage = homePage.wishList();
        wishListPage.scroll(-1000);
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        wishListPage.goToWishList();
        wishListPage.removeItemsFromWishList();
        assertEquals(wishListPage.getResult(), emptyList, "Incorrect");
    }
}
