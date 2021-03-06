package selenium.pageobject;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import selenium.pageobject.pages.GoogleMainPage;
import selenium.pageobject.pages.GoogleResultPage;

import static org.junit.jupiter.api.Assertions.*;

public class GoogleTests extends BaseTest {


    @Test
    public void canFindScrumOrgOnGoogle() {
        String pageUrl = "https://www.scrum.org/";
        String pageTitle = "Scrum.org: Homepage";

        // Open Google Main Page
        GoogleMainPage googlePage = new GoogleMainPage(driver);

        // Search For Scrum.org
        GoogleResultPage resultPage = googlePage.search("Scrum.org");

        // Assert Scrum.org page is found
        assertTrue(resultPage.contains(pageUrl));
        assertTrue(resultPage.containsResultWithTitle(pageUrl, pageTitle),
                "Scrum.org page has correct title");
    }




    @Test
    public void canFindCodeSprinters() {
        String pageUrl = "http://agileszkolenia.pl/";
        String pageTitle = "Code Sprinters - Agile Experts -";

        GoogleMainPage googlePage = new GoogleMainPage(driver);
        GoogleResultPage resultPage = googlePage.search("Code Sprinters");
        assertTrue(resultPage.contains(pageUrl));
        assertTrue(resultPage.containsResultWithTitle(pageUrl, pageTitle));
    }


}

