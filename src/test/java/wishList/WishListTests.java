package wishList;

import SitePages.SearchPage;
import SitePages.WishListPage;
import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WishListTests extends BaseTests {
    @Test
    public void TestAddToWishList()
    {
        SearchPage searchPage = homePage.search();
        searchPage.setSearchString("laptop");
        searchPage.clickSearchButton();
        homePage.scroll(1000);
        WishListPage wishListPage = homePage.wishList();
        wishListPage.WaitForLoading();
        wishListPage.AddToWishList();
    }

    @Test
    public void TestRemoveAllItems()
    {
        String emptyList = "The wishlist is empty!";
        TestAddToWishList();
        WishListPage wishListPage = homePage.wishList();
        homePage.scroll(-1000);
        wishListPage.closeButton();
        wishListPage.goToWishList();
        wishListPage.removeItemsFromWishList();
        assertEquals(wishListPage.getResult(), emptyList, "Incorrect");
    }
}
