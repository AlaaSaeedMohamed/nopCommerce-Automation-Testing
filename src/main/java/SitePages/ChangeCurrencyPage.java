package SitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ChangeCurrencyPage {
    private WebDriver driver;
    By dropdown = By.xpath("//*[@id=\"customerCurrency\"]");
    public ChangeCurrencyPage(WebDriver driver){
        this.driver = driver;
    }
    public void selectFormDropdown(String option)
    {
        Select dropdownElement = findDropdownElement();
        dropdownElement.selectByVisibleText(option);
    }
    private Select findDropdownElement()
    {
        return new Select(driver.findElement(dropdown));
    }
}
