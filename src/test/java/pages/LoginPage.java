package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Администратор on 18.01.2016.
 */
public class LoginPage extends AbstractPage{
    private final Logger logger = Logger.getLogger(LoginPage.class);
    private final String BASE_URL = "http://mangachan.ru/";


    @FindBy(xpath = "//input[@name='login_name']")
    private WebElement inputLogin;

    @FindBy(xpath = "//input[@name='login_password']")
    private WebElement inputLoginPassword;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement buttonLogged;

    @FindBy(xpath = "//a[@href='http://mangachan.ru/user/mouzi/']")
    private WebElement buttonProfile;

    @FindBy(xpath = "//div[@id='profile-info']//h2")
    private WebElement linkLoggedInUser;



    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Login page opened");
    }

    public void login(String username, String password) throws InterruptedException {
        inputLogin.sendKeys(username);
        inputLoginPassword.sendKeys(password);
        buttonLogged.click();
        logger.info("Login done");
        buttonProfile.click();
        Thread.sleep(2000);
        logger.info("Login performed");
    }
    public String getLoggedInUserName()
    {
        return linkLoggedInUser.getText();
    }}