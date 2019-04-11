import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CriticalPathTests {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private CategoryPage categoryPage;
    private ProductPage productPage;
    private static WebDriverWait wait;
    private static final String URL = " http://automationpractice.com ";
    private String productName;
    private String productId;

    public CriticalPathTests(String productName, String productId) {
        this.productName = productName;
        this.productId = productId;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {"Faded Short Sleeve T-shirts","demo_1"},
                {"Blouse","demo_2"}
        });
    }

    @Before
    public void init(){
        driver = DriverFactory.startBroswer( "chrome",URL );
        homePage = new HomePage( driver );
        loginPage = new LoginPage(driver);
        categoryPage = new CategoryPage(driver);
        productPage = new ProductPage(driver);
        wait = new WebDriverWait(driver,20);
    }

    @Test
    public void checkCart(){
        homePage.openLoginPage();
        loginPage.typeUserName().typePasswd().pressSubmitButton();
//            Assert.assertEquals( LoginPage.nameLastname, loginPage.getAccountName());
        loginPage.openHomePage();
        homePage.openCategoryPage(HomePage.CATEGORY_WOMEN);
//            Assert.assertEquals( CategoryPage.womenTitle, driver.getTitle() );
        categoryPage.openProductPage(productName);
        productPage.addToCart();
        wait.until( ExpectedConditions.visibilityOf(productPage.proceedToCheckoutButton));
        productPage.proceedToCheckout();
            Assert.assertTrue(driver.getPageSource().contains(productId));
    }

    @After
    public void end(){
        driver.quit();
    }
}
