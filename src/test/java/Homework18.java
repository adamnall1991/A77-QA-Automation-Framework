import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.Assert.*;
import org.testng.annotations.Test;

import java.time.Duration;


public class Homework18 extends BaseTest {
    @Test
    public void playSong() {
        navigateToPage();
        provideEmail("adam.nall@testpro.io");
        providePassword("adam_test1");
        clickSubmit();
        clickPlay();
        Assert.assertTrue(isSongPlaying());
    }



    public void clickPlay() {
        WebElement playNextButton = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));

        playNextButton.click();
        playButton.click();
    }

    public boolean isSongPlaying() {
        WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        return soundBar.isDisplayed();
    }

}