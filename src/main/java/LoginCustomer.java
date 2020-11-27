import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginCustomer {
    private WebDriver driver;
    LoginCustomer(WebDriver driver){this.driver = driver;}

    By signInButtonMainPage = By.xpath("//li[@class='authorization-link']");
    By userNameField = By.xpath("//input[@name='login[username]']");
    By passwordField = By.xpath("//input[@name='login[password]']");
    By signInButtonForm = By.xpath("//button[@class='action login primary']");

    public LoginCustomer signInButtonClick(){
        driver.findElement(signInButtonMainPage).click();
        return this;
    }

    public LoginCustomer waitForPageTitle(){
        new WebDriverWait(driver,10).
                until(ExpectedConditions.textToBePresentInElement(
                        driver.findElement(By.xpath("//h1[@class='page-title']")), "Customer Login"));
        return this;
    }

    public LoginCustomer fillLoginField(String login)
    { driver.findElement(userNameField).sendKeys(login);return this;}
    public LoginCustomer fillPasswordField(String pass)
    { driver.findElement(passwordField).sendKeys(pass);return this;}
    public LoginCustomer clickSignInButtonOnAuthForm()
    {driver.findElement(signInButtonForm).click();return this;}


    public LoginCustomer loginCustomerIntoAccount(String user, String password){
        signInButtonClick();
        waitForPageTitle();
        fillLoginField(user);
        fillPasswordField(password);
        clickSignInButtonOnAuthForm();
        return this;
    }
}
