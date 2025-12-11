import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class LoginTests extends BaseTest {


    @Test(enabled = true, priority = 1, description = "Login with valid email and valid password")
    public void loginValidEmailPassword() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("adam.nall@testpro.io");
        loginPage.providePassword("adam_test1");
        loginPage.clickSubmit();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

    }

    /*
    @Test
    public void loginEmptyEmailPassword() throws InterruptedException {


//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // TODO (for students): Review the configuration as part of HW15
        provideEmail("");
        providePassword("");
        clickSubmit();

        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test(dataProvider="IncorrectLoginData", dataProviderClass = BaseTest.class, enabled = true, priority = 0, description = "Login with invalid email and valid password")
    public void loginInvalidEmailValidPassword(String email, String password) throws InterruptedException{
        provideEmail(email);
        providePassword(password);
        clickSubmit();

        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }



    @Test(enabled = true, priority = 3, description = "Login with valid email and empty password")
    public void loginValidEmailEmptyPassword() throws InterruptedException{
        navigateToPage();
        provideEmail("adam.nall@testpro.io");
        providePassword("");
        clickSubmit();

        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

     */

    public void isAvatarDisplayed(){
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
    }
}
