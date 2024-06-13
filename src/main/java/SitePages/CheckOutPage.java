package SitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutPage {
    private WebDriver driver;
    public By checkbox = By.xpath("//*[@id=\"termsofservice\"]");
    public By checkoutButton = By.xpath("//*[@id=\"checkout\"]");
    public By checkoutAsGuestButton = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div[1]/div[3]/button[1]");
    By firstName = By.xpath("//*[@id=\"BillingNewAddress_FirstName\"]");
    By lastName = By.xpath("//*[@id=\"BillingNewAddress_LastName\"]");
    By email = By.xpath("//*[@id=\"BillingNewAddress_Email\"]");
    By city = By.xpath("//*[@id=\"BillingNewAddress_City\"]");
    By address1 = By.xpath("//*[@id=\"BillingNewAddress_Address1\"]");
    By postalCode = By.xpath("//*[@id=\"BillingNewAddress_ZipPostalCode\"]");
    By phoneNumber = By.xpath("//*[@id=\"BillingNewAddress_PhoneNumber\"]");
    public By countryDropdown = By.xpath("//*[@id=\"BillingNewAddress_CountryId\"]");
    public By stateDropdown = By.xpath("//*[@id=\"BillingNewAddress_StateProvinceId\"]");
    public By continueToShippingMethodButton = By.xpath("//*[@id=\"billing-buttons-container\"]/button[2]");
    public By continueToPayingMethod = By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button");
    public By continueToPaymentInfo = By.xpath("//*[@id=\"payment-method-buttons-container\"]/button");
    public By continueToConfirmOrder = By.xpath("//*[@id=\"payment-info-buttons-container\"]/button");
    public By confirmButton = By.xpath("//*[@id=\"confirm-order-buttons-container\"]/button");
    public CheckOutPage(WebDriver driver)
    {
        this.driver = driver;
    }
    public void selectFormDropdown(String option, By dropdown)
    {
        Select dropdownElement = findDropdownElement(dropdown);
        dropdownElement.selectByVisibleText(option);
    }
    private Select findDropdownElement(By dropdown)
    {
        return new Select(driver.findElement(dropdown));
    }
    public void firstNameField(String first)
    {
        driver.findElement(firstName).sendKeys(first);
    }
    public void lastNameField(String last)
    {
        driver.findElement(lastName).sendKeys(last);
    }
    public void setEmail(String e)
    {
        driver.findElement(email).sendKeys(e);
    }
    public void setAddress1(String address)
    {
        driver.findElement(address1).sendKeys(address);
    }
    public void setCity(String c)
    {
        driver.findElement(city).sendKeys(c);
    }
    public void setPostalCode(String code)
    {
        driver.findElement(postalCode).sendKeys(code);
    }
    public void setPhoneNumber(String phone)
    {
        driver.findElement(phoneNumber).sendKeys(phone);
    }
    public void click(By button)
    {
        driver.findElement(button).click();
    }
    public void WaitForLoading(By element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


}
