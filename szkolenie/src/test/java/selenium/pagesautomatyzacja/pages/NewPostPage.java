package selenium.pagesautomatyzacja.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class NewPostPage {

    private final WebDriver driver;

    private final static  By TITLE_BOX  = By.id("title");
    private final static  By CONTENT_BOX  = By.id("content");
    private final static  By PUBLISH_BUTTON  = By.id("publish");
    private final static  By ZOBACZ_WPIS  = By.xpath("//a[.='Zobacz wpis");

    private final static String TYTUL = "Warsztaty automatyzacji  - Warszawa 11-13.12.2028";
    private final static String WPIS = "W dniach 11-13.12.2028 w Warszawie odbyly się warsztaty z automatyzacji testow w javie." +
            "Zakres warsztatów obejmował: testy jednostkowe, testy Selenium WebDriver oraz Page Object Pattern";

public NewPostPage(WebDriver driver) {
        this.driver = driver;
    }


    public void addPost() {
    driver.findElement(TITLE_BOX).sendKeys(TYTUL);
    driver.findElement(CONTENT_BOX).sendKeys(WPIS);
    driver.findElement(ZOBACZ_WPIS).click();
    driver.manage().timeouts().pageLoadTimeout(10 , TimeUnit.SECONDS)
    }

    public boolean checkComment() {

        Stream<WebElement> comments = driver.findElements(By.cssSelector(".site-content > .entry-title"))

                .stream()

                .filter(c -> c.findElement(By.cssSelector(".comment-author > b")).getText().equals(author))

                .filter(c -> c.findElement(By.cssSelector(".comment-content > p")).getText().equals(comment));

        return  comments.count() == 1;

}
