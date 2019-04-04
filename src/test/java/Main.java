import Pages.HomePage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {
    WebDriver driver = new ChromeDriver(  );
    HomePage homePage = new HomePage( driver );
    private static WebDriverWait wait;

    @Before
    public void init(){
        driver.get( " http://automationpractice.com " );
        driver.manage().deleteAllCookies();
        wait = new WebDriverWait(driver,10);
    }

    @Test
    public void checkCart(){
        driver.findElement( By.linkText( "Sign in" )).click();
        driver.findElement( By.id( "email" )).sendKeys( "fake@mail.ua" );
        driver.findElement( By.id( "passwd" )).sendKeys( "Fakepass" );
        driver.findElement( By.id( "SubmitLogin" ) ).click();
        driver.get( " http://automationpractice.com " );
        driver.findElement( By.linkText( "Women" ) ).click();
        Assert.assertEquals( "Women - My Store", driver.getTitle() );
        driver.findElement( By.linkText( "Faded Short Sleeve T-shirts" ) ).click();
        driver.findElement( By.cssSelector("#add_to_cart > button")).click();
        wait.until( ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a"))));
        driver.findElement(By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a")).click();
        Assert.assertNotNull( driver.findElement( By.cssSelector("a[title=\"Faded Short Sleeve T-shirts\"]")) );
        driver.quit();
    }

}
