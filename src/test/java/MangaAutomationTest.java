import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.Steps;

/**
 * Created by Администратор on 18.01.2016.
 */
public class MangaAutomationTest {
    private Steps steps;
    private final String USERNAME = "mouzi";
    private final String PASSWORD = "mouzi95";
    private final String SEARCHMANGA = "worst";
    private final String COMMENT = "я аж тащусь";
    private final String TEXT = "18 января 2016 17:44";

    @BeforeMethod(description = "Init browser")
    public void setUp()
    {
        steps = new Steps();
        steps.initBrowser();
    }

    @Test
    public void oneCanLoginManga() throws InterruptedException {
        steps.loginManga(USERNAME,PASSWORD);
        Assert.assertTrue(steps.isLoggedIn(USERNAME));
    }

    @Test
    public void searchMangachan() throws InterruptedException{
        steps.searchManga(SEARCHMANGA);
        Assert.assertTrue(steps.isSearch(SEARCHMANGA));
    }

    @Test
    public void addMangachan() throws InterruptedException{
        steps.loginManga(USERNAME,PASSWORD);
        steps.favManga(SEARCHMANGA);
        Assert.assertTrue(steps.isAdd(SEARCHMANGA));
    }

    @Test
    public void addComment() throws InterruptedException{
        steps.loginManga(USERNAME,PASSWORD);
        steps.addCom(SEARCHMANGA,COMMENT);
        Assert.assertTrue(steps.iscommentUser(USERNAME));
    }

    @Test
    public void Myself() throws InterruptedException{
        steps.loginManga(USERNAME,PASSWORD);
        steps.addAbMe(TEXT);
        Assert.assertTrue(steps.iscommentUser(TEXT));
    }


    @AfterMethod(description = "Stop Browser")
    public void stopBrowser()
    {
        steps.closeDriver();
    }
}

