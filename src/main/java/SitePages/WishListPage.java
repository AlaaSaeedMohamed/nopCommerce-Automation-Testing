package SitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WishListPage {
    private WebDriver driver;
    By AddToWishListButton = By.xpath("//button[text()='Add to wishlist']");
    public By wishList = By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[3]/a");
    By removeBtn = By.className("remove-btn");
    public By emptyResult = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div");
    By close = By.xpath("//*[@id=\"bar-notification\"]/div/span");
    public WishListPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void AddToWishList()
    {
        List<WebElement> buttons = driver.findElements(AddToWishListButton);
        for(WebElement button : buttons)
        {
            button.click();
            try {
                Thread.sleep(3000);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void goToWishList()
    {
        driver.findElement(wishList).click();
    }

    public void removeItemsFromWishList()
    {
        List<WebElement> buttons = driver.findElements(removeBtn);
        //relocation of elements (stale exception)
        for (int i = 0; i < buttons.size(); i++)
        {
            WebElement btn = driver.findElements(removeBtn).getFirst();
            btn.click();
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public String getResult()
    {
        return driver.findElement(emptyResult).getText();
    }
    public void closeButton()
    {
        driver.findElement(close).click();
    }
    public void WaitForLoading()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(AddToWishListButton));
    }
}
