package selenium.pageobjectwordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WordPressMainPage {



    private static final String WORDPRES_PAGE_URL = "https://automatyzacja.benedykt.net";
    private final WebDriver wmpDriver;

    public WordPressMainPage(WebDriver driver) {
        wmpDriver = driver;
        wmpDriver.get(WORDPRES_PAGE_URL);
    }

public void pressFirstLink() {
        wmpDriver.findElement(By.cssSelector("article.post"))
                .findElement(By.className("entry-title"))
                .findElement(By.tagName("a"))
                .click();
    }

}
