package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
    }

    By emailField = By.cssSelector("input[type='email']");
    By passwordField = By.cssSelector("input[type='password']");
    By submitBtn = By.cssSelector("button[type='submit']");

    public void provideEmail(String email){
        findElement(emailField).clear();
        findElement(emailField).sendKeys(email);
    }

    public void providePassword(String password){
        findElement(passwordField).clear();
        findElement(passwordField).sendKeys(password);
    }

    public void clickSubmit(){
        findElement(submitBtn).click();
    }

    public void login(String email, String password){
//        provideEmail("adam.nall@testpro.io");
//        providePassword("adam_test1");
        provideEmail(email);
        providePassword(password);
        clickSubmit();
    }
}
