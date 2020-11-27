import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogOutCustomer {
    private WebDriver driver;
    public LogOutCustomer(WebDriver driver){this.driver = driver;}

    By dropdownMenu = By.xpath("//li[@class='customer-welcome']");
    By signOut = By.xpath("//li[@class='authorization-link']");

    public LogOutCustomer dropdownMenuButtonClick(){driver.findElement(dropdownMenu).click();return this;}
    public LogOutCustomer signOutButtonClick(){driver.findElement(signOut).click();return this;}

    public LogOutCustomer waitForPageTitle(){
        new WebDriverWait(driver,10).
                until(ExpectedConditions.textToBePresentInElement(
                        driver.findElement(By.xpath("//span[@class='base']")), "You are signed out"));
        return this;
    }

    public LogOutCustomer logOutCustomerFromAccount(){
        dropdownMenuButtonClick();
        signOutButtonClick();
        waitForPageTitle();
        return this;
    }

}




