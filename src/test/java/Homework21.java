import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Assert.*;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework21 extends BaseTest {
    String newPlaylistName = "Alternate Playlist Name by Adam";

    Actions actions;

    @Test
    public void changePlaylistName() throws InterruptedException{
        String updatePlaylistMsg = "Updated playlist \"Alternate Playlist Name by Adam.\"";

        navigateToPage();
        actions = new Actions(driver);
        provideEmail("adam.nall@testpro.io");
        providePassword("adam_test1");
        clickSubmit();
        doubleClickPlaylist();
        enterNewPlaylistName();
        Assert.assertEquals(getRenamePlaylistSuccessMsg(), updatePlaylistMsg);
    }

    public void doubleClickPlaylist(){
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playlistElement).perform();
    }

    public void enterNewPlaylistName(){
        WebElement playlistInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name'")));
        playlistInput.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));

        playlistInput.sendKeys(newPlaylistName);
        playlistInput.sendKeys(Keys.ENTER);
    }

    public String getRenamePlaylistSuccessMsg(){
        WebElement notif = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notif.getText();
    }
}
