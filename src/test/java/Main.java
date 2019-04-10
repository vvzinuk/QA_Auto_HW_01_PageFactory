import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private CategoryPage categoryPage;
    private ProductPage productPage;
    private static WebDriverWait wait;


    @Before
    public void init(){
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver(  );
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get( " http://automationpractice.com " );
        homePage = new HomePage( driver );
        loginPage = new LoginPage(driver);
        categoryPage = new CategoryPage(driver);
        productPage = new ProductPage(driver);
        wait = new WebDriverWait(driver,10);
    }

    @Test
    public void checkCart(){
        homePage.openLoginPage();
        loginPage.typeUserName().typePasswd().submit();
        loginPage.openHomePage();
        homePage.openCategoryPage("Women");
        Assert.assertEquals( "Women - My Store", driver.getTitle() );
        categoryPage.openProductPage("Faded Short Sleeve T-shirts");
        productPage.addToCart();
        wait.until( ExpectedConditions.visibilityOf(driver.findElement(productPage.proceedToCheckoutButton)));
        productPage.proceedToCheckout();
        Assert.assertTrue(driver.getPageSource().contains("demo_1"));
    }

    @After
    public void end(){
        driver.quit();
    }
}
