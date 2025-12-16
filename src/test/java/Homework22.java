import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class Homework22 extends BaseTest{
    @Test
    public void renamePlaylist(){
        String newPlaylistName = "Adam's Edited Playlist";
        String updatedPlaylistMsg = "Updated playlist \"Adam's Edited Playlist.\"";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login("adam.nall@testpro.io", "adam_test1");
        homePage.doubleClickPlaylist();
        homePage.enterNewPlaylistName(newPlaylistName);
        Assert.assertEquals(homePage.getRenamePlaylistSuccessMsg(), updatedPlaylistMsg);
    }
}
