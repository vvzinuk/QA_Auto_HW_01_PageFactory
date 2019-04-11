import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    WebDriver driver;

    @FindBy(css = "#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a")
    WebElement proceedToCheckoutButton;

    @FindBy(css = "#add_to_cart > button")
    WebElement addToCartButton;


    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements( driver, this );
    }

    public void addToCart(){
        addToCartButton.click();
    }

    public OrderPage proceedToCheckout (){
        proceedToCheckoutButton.click();
        return new OrderPage(driver);
    }
}
