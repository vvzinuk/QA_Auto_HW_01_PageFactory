import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

class CategoryPage {
    static String womenTitle = "Women - My Store";

    WebDriver driver;
    CategoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements( driver,this );
    }

    public ProductPage openProductPage (String productName){
        driver.findElement( By.linkText( productName ) ).click();
        return new ProductPage(driver);
    }
}
