import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    static WebDriver driver;

    public static WebDriver startBroswer(String browser, String URL){
        if(browser.equals( "chrome" )){
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
            driver = new ChromeDriver(  );
        } else if (browser.equals( "firefox" )){
            System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
            driver = new FirefoxDriver(  );
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get( URL );
        return driver;
    }
}
