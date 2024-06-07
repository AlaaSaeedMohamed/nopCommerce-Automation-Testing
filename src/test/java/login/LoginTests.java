package login;

import SitePages.LoginPage;
import base.BaseTests;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class LoginTests extends BaseTests {
    @Test
    public void TestSuccessfulLogin()
    {
        LoginPage loginPage = homePage.clickLogin();
        loginPage.setEmail("aaa@gmail.com");
        loginPage.setPassword("1Qaz2Wsx");
        loginPage.clickLoginButton();
    }
    @Test
    public void TestLoginWithInvalidEmailOrPassword()
    {
        String errorText = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        LoginPage loginPage = homePage.clickLogin();
        loginPage.setEmail("a@gmail.com");
        loginPage.setPassword("1Qaz2Wsx");
        loginPage.clickLoginButton();
        String text = loginPage.getResult();
        assertEquals(text, errorText, "incorrect");
    }
}
