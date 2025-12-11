import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.UUID;

public class BaseTest {
    //public WebDriver driver = null;
    public static WebDriver driver = null;

    //public String url;
    public static String url = null;
    //public WebDriverWait wait;
    public static WebDriverWait wait = null;

    public static Actions actions = null;


    @BeforeSuite
    void setupClass(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        url = BaseURL;
        navigateToPage();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

//    @AfterMethod
//    public void closeBrowser(){
//        driver.quit();
//    }

    public void navigateToPage(){
        driver.get(url);
    }


    public void login(){
        // open Chrome browser
        navigateToPage();

        provideEmail("adam.nall@testpro.io");

        providePassword("adam_test1");

        clickSubmit();
    }



    public void provideEmail(String email){
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void providePassword(String password){
        WebElement passField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        passField.clear();
        passField.sendKeys(password);
    }

    public void clickSubmit(){
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        loginButton.click();
    }

    public void clickSaveButton(){
        WebElement saveButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        saveButton.click();
    }

    public void provideProfileName(String randomName){
        WebElement profileName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        profileName.clear();
        profileName.sendKeys(randomName);
    }

    public void provideCurrentPassword(String password){
        WebElement currentPassword = wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("[name='current_password']"))));
        currentPassword.clear();
        currentPassword.sendKeys(password);
    }

    public String generateRandomName(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    public void clickAvatarIcon(){
        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
        avatarIcon.click();
    }

    public void isAvatarDisplayed(){
        WebElement userAvatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("img.avatar"))));
        Assert.assertTrue(userAvatarIcon.isDisplayed());
    }


}