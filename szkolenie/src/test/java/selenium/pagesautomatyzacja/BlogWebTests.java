package selenium.pagesautomatyzacja;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import selenium.pageobject.BaseTest;
import selenium.pagesautomatyzacja.pages.BlogLoginPage;
import selenium.pagesautomatyzacja.pages.BlogMainPage;
import selenium.pagesautomatyzacja.pages.NewPostPage;

import java.util.concurrent.TimeUnit;

public class BlogWebTests extends BaseTest {


    @Test
    public void addArticleToBlog(){
        BlogLoginPage blogLoginPage = new BlogLoginPage(driver);
        BlogMainPage blogMainPage = new BlogMainPage(driver);
        blogMainPage.pressNoteMenu();
        NewPostPage newPostPage = new NewPostPage(driver);
        newPostPage.addPost();
        Assertions.assertTrue(newPostPage.checkComment(), "Sprawdzenie dodanego komentarza");
        newPostPage.aWyloguj();
        BlogLoginPage blogLoginPage1 = new BlogLoginPage(driver);
        Assertions.assertTrue(blogMainPage.checkPublishComment());
    }


}
