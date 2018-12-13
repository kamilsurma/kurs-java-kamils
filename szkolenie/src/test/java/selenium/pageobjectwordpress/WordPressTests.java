package selenium.pageobjectwordpress;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import selenium.pageobject.BaseTest;
import selenium.pageobjectwordpress.pages.WordPressMainPage;
import selenium.pageobjectwordpress.pages.WordPressNotePage;

public class WordPressTests extends BaseTest {



    @Test
public  void addCommentToBlog(){

WordPressMainPage wordPressMainPage = new WordPressMainPage(driver);
wordPressMainPage.pressFirstLink();
WordPressNotePage wordPressNotePage = new WordPressNotePage(driver);
wordPressNotePage.addComment();
Assertions.assertTrue(wordPressNotePage.checkComment(), "Sprawdzenie czy wpis został dodany");

}

}
