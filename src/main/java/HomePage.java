import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    @FindBy(linkText = "Sign in")
    private WebElement loginButton;
    static final String CATEGORY_WOMEN = "Women";



    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements( driver, this );
    }


    public LoginPage openLoginPage (){
        loginButton.click();
        return new LoginPage(driver);
    }

    public CategoryPage openCategoryPage (String categoryName){
        driver.findElement( By.linkText( categoryName ) ).click();
        return new CategoryPage(driver);
    }
}
