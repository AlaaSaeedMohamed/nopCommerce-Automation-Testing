package currency;

import SitePages.ChangeCurrencyPage;
import base.BaseTests;
import org.testng.annotations.Test;

public class CurrencyTests extends BaseTests {
    @Test
    public void TestChangeCurrency()
    {
        ChangeCurrencyPage changeCurrencyPage = homePage.currency();
        changeCurrencyPage.selectFormDropdown("Euro");
    }
}
