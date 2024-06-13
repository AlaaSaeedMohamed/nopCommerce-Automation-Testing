package SitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    private WebDriver driver;
    By searchField = By.xpath("//*[@id=\"small-searchterms\"]");
    By searchButton = By.xpath("//*[@id=\"small-search-box-form\"]/button");
    By resultText = By.xpath("//button[text()='Add to cart']");

    public By lessThanThreeLettersError = By.xpath("//*[@id=\"main\"]/div/div[2]/div/div[2]/div[2]/div/div[2]/div");
    public By NoResultError = By.xpath("//*[@id=\"main\"]/div/div[2]/div/div[2]/div[2]/div/div[2]/div");

    public SearchPage(WebDriver driver){
        this.driver = driver;
    }
    public void setSearchString(String searchString)
    {
        driver.findElement(searchField).sendKeys(searchString);
    }
    public void clickSearchButton()
    {
        driver.findElement(searchButton).click();
    }
    public int getResult()
    {
        return driver.findElements(resultText).size();
    }
    public String getResult(By result)
    {
        return driver.findElement(result).getText();
    }
    public void alert_clickToAccept(){
        driver.switchTo().alert().accept();
    }
}
