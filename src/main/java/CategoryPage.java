import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryPage {

    WebDriver driver;
    public CategoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductPage openProductPage (String productName){
        driver.findElement( By.linkText( productName ) ).click();
        return new ProductPage(driver);
    }
}
