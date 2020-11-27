import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CustomerAccountLoginLogoutTest {
    WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://magento.nublue.co.uk/");
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown(){driver.quit();}

    @Test(priority = 1)
    public void loginInto(){
    LoginCustomer login = new LoginCustomer(driver);
    login.loginCustomerIntoAccount("roni_cost@example.com", "roni_cost3@example.com");
    }

    @Test(priority = 2)
    public void signOut(){
       LogOutCustomer logout = new LogOutCustomer(driver);
       logout.logOutCustomerFromAccount();
    }
}
