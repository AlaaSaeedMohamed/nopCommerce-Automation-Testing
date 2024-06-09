package SitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    By emailField = By.xpath("//*[@id=\"Email\"]");
    By passwordField = By.xpath("//*[@id=\"Password\"]");
    By loginButton = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button");
    By resultText = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div[2]/form/div[1]");
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public void setEmail(String email)
    {
        driver.findElement(emailField).sendKeys(email);
    }
    public void setPassword(String password)
    {
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickLoginButton()
    {
        driver.findElement(loginButton).click();
    }
    public String getResult()
    {
        return driver.findElement(resultText).getText();
    }

}
