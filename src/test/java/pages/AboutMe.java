package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Администратор on 19.01.2016.
 */
public class AboutMe extends AbstractPage{
    private final Logger logger = Logger.getLogger(AboutMe.class);
    private final String BASE_URL = "http://mangachan.ru/user/mouzi/";

    public AboutMe(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Search page opened");
    }

    @FindBy(xpath = "//div[$class='info-right']//a[@href='javascript:ShowOrHide('options')']")
    private WebElement buttonOptions;

    @FindBy(xpath = "//textarea[@class='f_textarea']")
    private WebElement inputInfo;

    @FindBy(xpath = "//input[@id='submit']")
    private WebElement buttonSave;

    @FindBy(xpath = "//div[@class='info-right']")
    private WebElement linkMe;

    public void me(String addMe) throws InterruptedException {
        buttonOptions.click();
        inputInfo.sendKeys(addMe);
        buttonSave.click();
        Thread.sleep(2000);
        logger.info("Test performed");
    }
    public String getAbout(){return linkMe.getText();    }

}

