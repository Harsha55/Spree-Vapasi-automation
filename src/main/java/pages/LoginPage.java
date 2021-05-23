package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public String login(String userName, String passWord){
        //add functionality
        WebElement loginButton = driver.findElement(By.id("link-to-login"));
        loginButton.click();
        WebElement username = driver.findElement(By.id("spree_user_email"));
        username.sendKeys(userName);
        WebElement password = driver.findElement(By.id("spree_user_password"));
        password.sendKeys(passWord);
        WebElement submitButton = driver.findElement(By.name("commit"));
        submitButton.click();
        String loginMessage = driver.findElement(By.id(".alert.alert-success")).getText();
        return loginMessage;
    }

    public String logout(){
        WebElement logoutButton = driver.findElement(By.linkText("Logout"));
        logoutButton.click();
        String logoutMessage = driver.findElement(By.id(".alert.alert-success")).getText();
        return logoutMessage;
    }
}
