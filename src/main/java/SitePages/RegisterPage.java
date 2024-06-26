package SitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class RegisterPage {
    private WebDriver driver;
    By firstNameField = By.xpath("//*[@id=\"FirstName\"]");
    By lastNameField = By.xpath("//*[@id=\"LastName\"]");
    public By DayDropdown = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[1]");
    public By MonthDropdown = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[2]");
    public By YearDropdown = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[3]");
    By emailField = By.xpath("//*[@id=\"Email\"]");
    By passwordField = By.xpath("//*[@id=\"Password\"]");
    By confirmPasswordField = By.xpath("//*[@id=\"ConfirmPassword\"]");
    public By resultText = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]");
    public By errorText = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/form/div[1]/ul/li");
    //public By continueButton = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[2]/a");

    By registerButton = By.xpath("//*[@id=\"register-button\"]");
    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectFormDropdown(String option,By dropdown)
    {
        Select dropdownElement = findDropdownElement(dropdown);
        dropdownElement.selectByVisibleText(option);
    }
    private Select findDropdownElement(By dropdown)
    {
        return new Select(driver.findElement(dropdown));
    }

    public void setFirstName(String firstName)
    {
        driver.findElement(firstNameField).sendKeys(firstName);
    }
    public void setLastName(String lastName)
    {
        driver.findElement(lastNameField).sendKeys(lastName);
    }
    public void setEmail(String email)
    {
        driver.findElement(emailField).sendKeys(email);
    }
    public void setPassword(String password)
    {
        driver.findElement(passwordField).sendKeys(password);
    }
    public void setConfirmPassword(String confirmPassword)
    {
        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
    }
    public void clickRegisterButton()
    {
        driver.findElement(registerButton).click();
    }
    public String getResult(By result)
    {
        return driver.findElement(result).getText();
    }
    public void WaitForVisible(By element)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}
