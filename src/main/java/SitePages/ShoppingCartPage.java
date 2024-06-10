package SitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ShoppingCartPage {
    private WebDriver driver;
    By AddToCartButton = By.xpath("//button[text()='Add to cart']");
    By shoppingCart = By.xpath("//*[@id=\"topcartlink\"]/a");
    By removeBtn = By.className("remove-btn");
    public By emptyResult = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div/div");
    public By emptyCart = By.xpath("//*[@id=\"flyout-cart\"]/div/div");
    By cartFigure = By.xpath("//*[@id=\"topcartlink\"]");
    public ShoppingCartPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void AddToCart()
    {
        List<WebElement> buttons = driver.findElements(AddToCartButton);
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
    public void goToShoppingCart()
    {
        driver.findElement(shoppingCart).click();
    }

    public void removeItemsFromShoppingCart()
    {
        List<WebElement> buttons = driver.findElements(removeBtn);
        //relocation of elements (stale exception)
        for (int i = 0; i < buttons.size(); i++)
        {
            WebElement btn = driver.findElements(removeBtn).getFirst();
            btn.click();
            try {
                Thread.sleep(1500);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void scroll(int number)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + number + ")", "");
    }
    public String getResult(By result)
    {
        return driver.findElement(result).getText();
    }
    public ShoppingCartPage hoverOverCart()
    {
        WebElement figure = driver.findElement(cartFigure);
        Actions actions = new Actions(driver);
        actions.moveToElement(figure).perform();
        return new ShoppingCartPage(driver);
    }
}
