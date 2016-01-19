package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Администратор on 19.01.2016.
 */
public class Comment extends AbstractPage{
    private final Logger logger = Logger.getLogger(Comment.class);
    private final String BASE_URL = "http://mangachan.ru";

    public Comment(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Search page opened");
    }

    @FindBy(xpath = "//div[@id='top_search']//form[@id='search']//input[@id='story']")
    private WebElement inputSearch;

    @FindBy(xpath = "//div[@id='top_rss']//img[@id='search_button']")
    private WebElement buttonSearch;

    @FindBy(xpath = "//div[@class='manga_row1']//div//h2//a[@href='http://mangachan.ru/manga/5081-worst.html']")
    private WebElement buttonManga;

    @FindBy(xpath = "//div[@class='editor']//textarea[@id='comments']")
    private WebElement addComment;

    @FindBy(xpath = "//input[@id='post-comment']")
    private WebElement buttonSend;

    @FindBy(xpath = "//div[@class='comment_left']//a[@href='http://mangachan.ru/user/mouzi/']")
    private WebElement linkComment;

    public void addOneComment(String searchM,String comm) throws InterruptedException {
        inputSearch.sendKeys(searchM);
        buttonSearch.click();
        Thread.sleep(2000);
        logger.info("Search done");
        buttonManga.click();
        addComment.sendKeys(comm);
        buttonSend.click();
        Thread.sleep(2000);
        Thread.sleep(2000);
        logger.info("Search performed");
    }
    public String getComment(){return linkComment.getText();    }

}
