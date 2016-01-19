package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Администратор on 19.01.2016.
 */
public class AddManga extends AbstractPage{
    private final Logger logger = Logger.getLogger(AddManga.class);
    private final String BASE_URL = "http://mangachan.ru";

    public AddManga(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Search page opened");
    }

    @FindBy(xpath = "//div[@id='ratig-layer-fav-5081']//span//a[@class='fav_plus']")
    private WebElement addManga;

    @FindBy(xpath = "//div[@id='navigator']//ul[@class='main_set']//li[@class='r_border']//a[@href='/']")
    private WebElement buttonMain;

    @FindBy(xpath = "//div[@id='side']//div[@class='area_right']//ul[@class='area_rightNews linkStyle']//li//a[@href='/user/mouzi/favorites']")
    private WebElement buttonFavorites;

    @FindBy(xpath = "//ul[@class='area_rightNews linkStyle']//li[@id='ratig-layer-fav-5081']//div[@style='float:left;width:810px;margin-top:3px;']//a[@href='http://mangachan.ru/manga/5081-worst.html']")
    private WebElement buttonFavManga;

    @FindBy(xpath = "//div[@id='top_search']//form[@id='search']//input[@id='story']")
    private WebElement inputSearch;

    @FindBy(xpath = "//div[@id='top_rss']//img[@id='search_button']")
    private WebElement buttonSearch;

    @FindBy(xpath = "//div[@class='manga_row1']//div//h2//a[@href='http://mangachan.ru/manga/5081-worst.html']")
    private WebElement buttonManga;

    @FindBy(xpath = "//table[@class='mangatitle']//tr//td[@class='item2']//h2")
    private WebElement linkManga;

    public void favManga(String addM) throws InterruptedException {
        inputSearch.sendKeys(addM);
        buttonSearch.click();
        Thread.sleep(2000);
        logger.info("Search done");
        buttonManga.click();
        addManga.click();
        buttonMain.click();
        buttonFavorites.click();
        buttonFavManga.click();
        Thread.sleep(2000);
        logger.info("Search performed");
    }
    public String getAddManga(){return linkManga.getText();    }

}

