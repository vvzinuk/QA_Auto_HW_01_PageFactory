import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    @FindBy(id = "email")
    private WebElement loginField;
    @FindBy(id = "passwd")
    private WebElement passwdField;
    @FindBy(id = "SubmitLogin")
    private WebElement submitButton;
    @FindBy(css = "a.account")
    private WebElement accountName;

    private static String login = "fake@mail.ua";
    private static String passwd = "Fakepass";
    static String nameLastname = "Fake Fakeson";

    private WebDriver driver;

    LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements( driver,this );
    }

    LoginPage typeUserName(){
        loginField.sendKeys( login );
        return this;
    }

    LoginPage typePasswd(){
        passwdField.sendKeys( passwd );
        return this;
    }

    void pressSubmitButton(){
        submitButton.click();
    }

    public HomePage openHomePage(){
        driver.get( " http://automationpractice.com " );
        return new HomePage(driver);
    }

    public String getAccountName(){
        return accountName.getText();
    }

}
