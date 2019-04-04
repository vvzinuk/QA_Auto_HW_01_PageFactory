package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    static By loginField = By.id("email");
    static By passwdField = By.id("passwd");
    static String login = "fake@mail.ua";
    static String passwd = "Fakepass";
    static By submitButton = By.id( "SubmitLogin" );

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage typeUserName (){
        driver.findElement( loginField ).sendKeys( login );
        return this;
    }

    public LoginPage typePasswd (){
        driver.findElement( passwdField ).sendKeys( passwd );
        return this;
    }


}
