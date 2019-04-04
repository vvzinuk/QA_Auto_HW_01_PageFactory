package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    By loginButton = By.linkText( "Sign in" );

    WebDriver driver;
    LoginPage loginPage = new LoginPage( this.driver );


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage login(){
        System.out.println(1);
        driver.findElement(loginButton).click();
        System.out.println(2);
        loginPage.typeUserName();
        loginPage.typePasswd();
        System.out.println(3);
        driver.findElement( loginPage.submitButton ).click();
        System.out.println(4);
        driver.get( " http://automationpractice.com " );
        return new HomePage( driver );
    }

}
