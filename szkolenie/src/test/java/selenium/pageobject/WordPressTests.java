package selenium.pageobject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import selenium.pageobject.pages.WordPressMainPage;
import selenium.pageobject.pages.WordPressResultPage;

public class WordPressTests extends  BaseTest {



    @Test
public  void addCommentToBlog(){

WordPressMainPage wordPressMainPage = new WordPressMainPage(driver);
wordPressMainPage.pressFirstLink();
WordPressResultPage wordPressResultPage  = new WordPressResultPage(driver);
wordPressResultPage.addComment();
        Assertions.assertTrue(wordPressResultPage.checkComment(), "Sprawdzenie czy wpis został dodany");

}

}
