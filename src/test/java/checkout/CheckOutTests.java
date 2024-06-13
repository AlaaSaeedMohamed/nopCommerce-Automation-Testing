package checkout;

import SitePages.CheckOutPage;
import SitePages.SearchPage;
import SitePages.ShoppingCartPage;
import base.BaseTests;
import org.testng.annotations.Test;

public class CheckOutTests extends BaseTests {

    @Test
    public void TestCheckout()
    {
        SearchPage searchPage = homePage.search();
        searchPage.setSearchString("laptop");
        searchPage.clickSearchButton();
        homePage.scroll(1000);
        homePage.wait(2000);
        ShoppingCartPage shoppingCartPage = homePage.shoppingCart();
        shoppingCartPage.AddToCart();
        homePage.scroll(-1000);
        homePage.wait(2000);
        shoppingCartPage.goToShoppingCart();
        CheckOutPage checkOutPage = homePage.checkOut();
        checkOutPage.click(checkOutPage.checkbox);
        checkOutPage.click(checkOutPage.checkoutButton);
        checkOutPage.click(checkOutPage.checkoutAsGuestButton);
        homePage.wait(1000);
        checkOutPage.firstNameField("llll");
        checkOutPage.lastNameField("llll");
        checkOutPage.setEmail("aaa@gmail.com");
        checkOutPage.selectFormDropdown("United States", checkOutPage.countryDropdown);
        homePage.wait(1000);
        checkOutPage.selectFormDropdown("Hawaii", checkOutPage.stateDropdown);
        homePage.scroll(1000);
        checkOutPage.setCity("llll");
        checkOutPage.setAddress1("lll");
        checkOutPage.setPhoneNumber("343456");
        checkOutPage.setPostalCode("3456");
        checkOutPage.click(checkOutPage.continueToShippingMethodButton);
        checkOutPage.WaitForLoading(checkOutPage.continueToPayingMethod);
        checkOutPage.click(checkOutPage.continueToPayingMethod);
        checkOutPage.WaitForLoading(checkOutPage.continueToPaymentInfo);
        checkOutPage.click(checkOutPage.continueToPaymentInfo);
        checkOutPage.WaitForLoading(checkOutPage.continueToConfirmOrder);
        checkOutPage.click(checkOutPage.continueToConfirmOrder);
        checkOutPage.WaitForLoading(checkOutPage.confirmButton);
        checkOutPage.click(checkOutPage.confirmButton);
    }
}
