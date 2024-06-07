package SitePages;

import org.openqa.selenium.By;
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
//    public LoginPage hoverOverFigure()
//    {
//        WebElement figure = driver.findElement(accountFigure);
//        Actions actions = new Actions(driver);
//        actions.moveToElement(figure).perform();
//        return new LoginPage(driver);
//    }
    private void clickLink(String linkText)
    {
        driver.findElement(By.linkText(linkText)).click();
    }

}
