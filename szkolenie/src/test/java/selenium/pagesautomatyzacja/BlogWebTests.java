package selenium.pagesautomatyzacja;

import org.junit.jupiter.api.Test;
import selenium.pageobject.BaseTest;
import selenium.pagesautomatyzacja.pages.BlogLoginPage;
import selenium.pagesautomatyzacja.pages.BlogMainPage;

public class BlogWebTests extends BaseTest {


    @Test
    public void addArticleToBlog(){

        BlogLoginPage blogLoginPage = new BlogLoginPage(driver);
        BlogMainPage blogMainPage = new BlogMainPage(driver);
        blogMainPage.pressNoteMenu();


    }


}
