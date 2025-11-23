import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;


public class Homework17 extends BaseTest {
//    public WebDriver driver = null;
//
//    public String url = "https://qa.koel.app";



    @Test
    public void addSongToPlaylist(){
        login();
        // open Chrome browser
        /*
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        // wait 10 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);
        //Assert.assertEquals(driver.getCurrentUrl(), url);

        WebElement regLink = driver.findElement(By.cssSelector("[href='registration']"));

        driver.quit();
        */

    }

    public void login(){
        // open Chrome browser
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        // wait 10 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);
        //Assert.assertEquals(driver.getCurrentUrl(), url);

//        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
//        emailField.clear();
//        emailField.sendKeys("adam.nall@testpro.io");
        provideEmail("adam.nall@testpro.io");

//        WebElement passField = driver.findElement(By.cssSelector("input[type='password']"));
//        passField.clear();
//        passField.sendKeys("adam_test1");
        providePassword("adam_test1");

//        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
//        loginButton.click();
        clickSubmit();
    }

    public void provideEmail(String email){
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void providePassword(String password){
        WebElement passField = driver.findElement(By.cssSelector("input[type='password']"));
        passField.clear();
        passField.sendKeys(password);
    }

    public void clickSubmit(){
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
    }

//    @AfterMethod
//    public void closeBrowser(){
//        driver.quit();
//    }
}