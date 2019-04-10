import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    By loginButton = By.linkText( "Sign in" );

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    public LoginPage openLoginPage (){
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }

    public CategoryPage openCategoryPage (String categoryName){
        driver.findElement( By.linkText( categoryName ) ).click();
        return new CategoryPage(driver);
    }
}
