package SitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    //By accountFigure = By.xpath("//*[@id=\"en-page\"]/body/div[7]/header/nav/ul/li[3]");

    public LoginPage clickLogin()
    {
        clickLink("Log in");
        return new LoginPage(driver);
    }
    public RegisterPage clickRegister()
    {
        clickLink("Register");
        return new RegisterPage(driver);
    }
    public SearchPage search()
    {
        return new SearchPage(driver);
    }
    public ChangeCurrencyPage currency()
    {
        return new ChangeCurrencyPage(driver);
    }
    public WishListPage wishList()
    {
        return new WishListPage(driver);
    }
    public ShoppingCartPage shoppingCart()
    {
        return new ShoppingCartPage(driver);
    }
    public CheckOutPage checkOut()
    {
        return new CheckOutPage(driver);
    }
    public void scroll(int number)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + number + ")", "");
    }
    public void wait(int duration)
    {
        try {
            Thread.sleep(duration);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    private void clickLink(String linkText)
    {
        driver.findElement(By.linkText(linkText)).click();
    }

}
