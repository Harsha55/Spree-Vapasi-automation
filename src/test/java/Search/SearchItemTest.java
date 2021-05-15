package Search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchItemTest {

    WebDriverWait wait = null;
    @Test
    public void SearchAnItem() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/Users/kumar/Documents/ThoughtWorks/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://spree-vapasi.herokuapp.com/");
        //new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfElementLocated(By.id("Keywords")));

        WebElement search_bar = driver.findElement(By.id("keywords"));
        search_bar.click();
        search_bar.sendKeys("shirt");
        driver.findElement(By.xpath("//*[@id='search-bar']/form/input[2]")).click();
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void SearchAnItemAndAddToCart() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/Users/kumar/Documents/ThoughtWorks/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://spree-vapasi.herokuapp.com/");
        //new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfElementLocated(By.id("Keywords")));

        WebElement search_bar = driver.findElement(By.id("keywords"));
        search_bar.click();
        search_bar.sendKeys("shirt");
        driver.findElement(By.xpath("//*[@id='search-bar']/form/input[2]")).click();
        Thread.sleep(3000);

        wait = new WebDriverWait(driver, 5);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(.,'product')][last()]")));
        WebElement item = driver.findElement(By.xpath("//*[@id='product_10']/div/div[1]"));
        String actualText = item.getText();
        item.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-to-cart-button")));
        driver.findElement(By.id("add-to-cart-button")).click();

        Thread.sleep(3000);

        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("content")));

        Assert.assertTrue(driver.getTitle().equals("Shopping Cart - Spree Demo Site"));

        String expectedText = driver.findElement(By.xpath("//*[@id='line_items']/tr/td[2]/h4/a")).getText();

        Assert.assertEquals(actualText,expectedText);
        driver.close();
        driver.quit();
    }
}
