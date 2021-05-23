package Login;
import UserActions.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;


public class LoginTest {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:/Users/kumar/Documents/ThoughtWorks/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://spree-vapasi.herokuapp.com/");
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='link-to-login']/a")));
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }


    @Test
    public void testLoginIntoSpree(){
        WebElement login_icon = driver.findElement(By.xpath("//*[@id='link-to-login']/a"));
        login_icon.click();
    }


    @Test
    public void testSuccessfulMessageOnValidLogin() {
        LoginPage loginAs = new LoginPage(driver);
        String success_msg = loginAs.login("kumariharsha33@gmail.com","Christin#30");
        Assert.assertEquals(success_msg,"Logged in successfully");

    }


    @Test
    public void testErrorMessageOnInvalidLogin() {
        LoginPage loginAs = new LoginPage(driver);
        String error_msg = loginAs.login("kumariharsha33@gmail.com","Christin");
        Assert.assertEquals(error_msg,"Invalid email or password.");
    }

}
