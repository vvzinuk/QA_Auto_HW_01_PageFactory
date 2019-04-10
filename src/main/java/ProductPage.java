import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    WebDriver driver;

    By proceedToCheckoutButton = By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart(){
        driver.findElement( By.cssSelector("#add_to_cart > button")).click();
    }

    public OrderPage proceedToCheckout (){
        driver.findElement(proceedToCheckoutButton).click();
        return new OrderPage(driver);
    }
}
