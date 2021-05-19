package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;





public class LoginTest {


    @Test
    public void testLoginIntoSpree(){

        System.setProperty("webdriver.chrome.driver","C:/Users/kumar/Documents/ThoughtWorks/chromedriver.exe");
        WebDriver driver1 = new ChromeDriver();
        //driver1.manage().deleteAllCookies();
        driver1.get("https://spree-vapasi.herokuapp.com/");

        WebDriverWait wait = new WebDriverWait(driver1,300);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='link-to-login']/a")));

        WebElement login_icon = driver1.findElement(By.xpath("//*[@id='link-to-login']/a"));
        login_icon.click();

        driver1.quit();
    }


    @Test
    public void testSuccessfulMessageOnValidLogin() {
        System.setProperty("webdriver.chrome.driver","C:/Users/kumar/Documents/ThoughtWorks/chromedriver.exe");
        WebDriver driver2 = new ChromeDriver();
        //driver2.manage().deleteAllCookies();
        driver2.get("https://spree-vapasi.herokuapp.com/");

        WebDriverWait wait = new WebDriverWait(driver2,300);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("link-to-login")));
        //driver2.findElement(By.xpath("//li[@id='link-to-login']/a")).click();
        driver2.findElement(By.id("link-to-login")).click();

        WebElement username = driver2.findElement(By.id("spree_user_email"));
        username.sendKeys("kumariharsha33@gmail.com");

        WebElement password = driver2.findElement(By.id("spree_user_password"));
        password.sendKeys("Christin#30");
        driver2.findElement(By.name("commit")).click();

        //This will capture the message
        String success_msg = driver2.findElement(By.cssSelector("div.alert.alert-success")).getText();
        Assert.assertEquals(success_msg,"Logged in successfully");

        WebDriverWait wait2 = new WebDriverWait(driver2,300);
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='nav-bar']/li[2]/a")));
        driver2.findElement(By.xpath("//*[@id='nav-bar']/li[2]/a")).click();

        driver2.quit();

    }


    @Test
    public void testErrorMessageOnInvalidLogin() {
        System.setProperty("webdriver.chrome.driver","C:/Users/kumar/Documents/ThoughtWorks/chromedriver.exe");
        WebDriver driver3 = new ChromeDriver();
        //driver3.manage().deleteAllCookies();
        driver3.get("https://spree-vapasi.herokuapp.com/");

        WebDriverWait wait = new WebDriverWait(driver3,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='link-to-login']/a")));
        driver3.findElement(By.xpath("//*[@id='link-to-login']/a")).click();

        WebElement username = driver3.findElement(By.id("spree_user_email"));
        username.sendKeys("kumariharsha33@gmail.com");

        WebElement password = driver3.findElement(By.id("spree_user_password"));
        password.sendKeys("");
        driver3.findElement(By.name("commit")).click();

        //This will capture the message
        String error_msg = driver3.findElement(By.cssSelector("div.alert.alert-error")).getText();
        Assert.assertEquals(error_msg,"Invalid email or password.");

        driver3.quit();
    }




}
