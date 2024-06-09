package SitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    private WebDriver driver;
    By searchField = By.xpath("//*[@id=\"small-searchterms\"]");
    By searchButton = By.xpath("//*[@id=\"small-search-box-form\"]/button");
    By resultText = By.cssSelector("#main > div > div.center-2 > div > div.page-body > div.search-results > div > div.products-wrapper > div.product-grid > div > div:nth-child(3) > div > div.details > div.add-info > div.buttons > button.button-2.product-box-add-to-cart-button");
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
        return driver.findElement(resultText).getText().split(" ").length;
    }
    public String getResult(By result)
    {
        return driver.findElement(result).getText();
    }
    public void alert_clickToAccept(){
        driver.switchTo().alert().accept();
    }
}
