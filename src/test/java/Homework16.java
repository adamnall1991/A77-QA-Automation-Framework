import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class Homework16 extends BaseTest {
    @Test
    public void clickRegLink(){
        // open Chrome browser
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        // wait 10 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        WebElement regLink = driver.findElement(By.cssSelector("[href='registration']"));
        regLink.click();
/*
<a data-v-4cbf3e38="" href="registration">Registration / Forgot password</a>
 */
        driver.quit();
    }
}