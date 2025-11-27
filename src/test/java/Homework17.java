import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist(){
        login();

        String expectedSuccessMsg = "Added 1 song into \"AdamTest.\"";

        searchSong("Way of the Samurai");

        WebElement song = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//table[@class='items']//tr[1]"));
        song.click();

        WebElement addToBtn = driver.findElement(By.cssSelector("button[class='btn-add-to'"));
        addToBtn.click();

        WebElement testPlaylist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(), 'AdamTest')]"));;
        testPlaylist.click();

        WebElement successMessage = driver.findElement(By.xpath("//div[@class='success show']"));

        Assert.assertEquals(successMessage.getText(), expectedSuccessMsg);

    }

    public void searchSong(String song){
        WebElement searchBar = driver.findElement(By.cssSelector("input[type='search'][placeholder='Press F to search']"));
        searchBar.clear();
        searchBar.sendKeys(song);

        WebElement viewAll = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewAll.click();
    }
}