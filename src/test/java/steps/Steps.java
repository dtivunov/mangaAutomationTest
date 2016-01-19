package steps;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by Администратор on 18.01.2016.
 */
public class Steps {
    private WebDriver driver;

    private final Logger logger = Logger.getLogger(Steps.class);

    public void initBrowser()
    {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logger.info("Browser started");
    }

    public void closeDriver()
    {
        driver.quit();
    }

    public void loginManga(String username, String password) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.login(username, password);
    }

    public boolean isLoggedIn(String username)
    {
        LoginPage loginPage = new LoginPage(driver);
        return (loginPage.getLoggedInUserName().trim().toLowerCase().equals(username));
    }

    public void searchManga(String searchM) throws InterruptedException{
        FindManga findManga = new FindManga(driver);
        findManga.openPage();
        findManga.searchManga(searchM);
    }

    public boolean isSearch(String searchM)
    {
        FindManga findManga = new FindManga(driver);
        return (findManga.getSearchManga().trim().toLowerCase().equals(searchM));
    }

    public void favManga(String addM) throws InterruptedException{
        AddManga addManga = new AddManga(driver);
        addManga.openPage();
        addManga.favManga(addM);
    }

    public boolean isAdd(String addM)
    {
        AddManga addManga = new AddManga(driver);
        return (addManga.getAddManga().trim().toLowerCase().equals(addM));
    }

    public void addCom(String searchM, String comm) throws InterruptedException {
        Comment comment = new Comment(driver);
        comment.openPage();
        comment.addOneComment(searchM, comm);
    }

    public boolean iscommentUser(String username)
    {
        Comment comment = new Comment(driver);
        return (comment.getComment().trim().toLowerCase().equals(username));
    }

    public void addAbMe(String addMe) throws InterruptedException {
        AboutMe aboutMe = new AboutMe(driver);
        aboutMe.openPage();
        aboutMe.me(addMe);
    }

    public boolean isInfoUser(String addMe)
    {
        AboutMe aboutMe = new AboutMe(driver);
        return (aboutMe.getAbout().trim().toLowerCase().equals(addMe));
    }

}
