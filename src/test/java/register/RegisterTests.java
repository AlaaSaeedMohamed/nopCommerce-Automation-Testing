package register;

import SitePages.RegisterPage;
import base.BaseTests;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class RegisterTests extends BaseTests {
    @Test
    public void TestSuccessfulRegister()
    {
        String text = "Your registration completed";
        RegisterPage registerPage = homePage.clickRegister();
        registerPage.setFirstName("lolo");
        registerPage.setLastName("saeed");
        registerPage.selectFormDropdown("3", registerPage.DayDropdown);
        registerPage.selectFormDropdown("January", registerPage.MonthDropdown);
        registerPage.selectFormDropdown("2002", registerPage.YearDropdown);
        registerPage.setEmail("ffxghxcvhhkbbn@gmail.com");
        homePage.scroll(600);
        registerPage.setPassword("1qaz2wsx");
        registerPage.setConfirmPassword("1qaz2wsx");
        registerPage.clickRegisterButton();
        registerPage.WaitForVisible(registerPage.resultText);
        assertEquals(registerPage.getResult(registerPage.resultText), text, "incorrect");
    }
    @Test
    public void TestRegisterWithExistingEmail()
    {
        String errorText = "The specified email already exists";
        RegisterPage registerPage = homePage.clickRegister();
        registerPage.setFirstName("lolo");
        registerPage.setLastName("saeed");
        registerPage.selectFormDropdown("3", registerPage.DayDropdown);
        registerPage.selectFormDropdown("January", registerPage.MonthDropdown);
        registerPage.selectFormDropdown("2002", registerPage.YearDropdown);
        registerPage.setEmail("tttt@gmail.com");
        homePage.scroll(600);
        registerPage.setPassword("1qaz2wsx");
        registerPage.setConfirmPassword("1qaz2wsx");
        registerPage.clickRegisterButton();
        registerPage.WaitForVisible(registerPage.errorText);
        assertEquals(registerPage.getResult(registerPage.errorText), errorText, "incorrect");
    }
}
