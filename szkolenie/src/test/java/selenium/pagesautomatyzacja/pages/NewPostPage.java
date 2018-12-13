package selenium.pagesautomatyzacja.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.pageobject.BaseTest;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class NewPostPage extends BaseTest {

    private final WebDriver driver;

    private final static By TITLE_BOX = By.id("title");
    private final static By CONTENT_BOX = By.id("content");
    private final static By PUBLISH_BUTTON = By.id("publish");
    private final static By LINK_ZOBACZ_WPIS = By.linkText("Zobacz wpis");


    private final  String TYTUL = "Warsztaty z automatyzacji java 11-13.12.2018";
    private final static String WPIS = "W dniach 11-13.12.2028 w Warszawie odbyly się warsztaty z automatyzacji testow w javie." +
            "Zakres warsztatów obejmował: testy jednostkowe, testy Selenium WebDriver oraz Page Object Pattern";

    public String getWPIS1() {
        return WPIS1;
    }

    private final String WPIS1 = generateRandomText();


    public NewPostPage(WebDriver driver) {
        this.driver = driver;
    }


    public void addPost() {
        driver.findElement(TITLE_BOX).sendKeys(TYTUL);
        driver.findElement(CONTENT_BOX).sendKeys(WPIS1);
        driver.findElement(PUBLISH_BUTTON).click();
        WebDriverWait webDriverWait = new WebDriverWait(driver , 20);
webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#publish.button.button-primary.button-large")));
        driver.findElement(By.cssSelector("input#publish.button.button-primary.button-large")).click();
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(LINK_ZOBACZ_WPIS)));
        driver.findElement(LINK_ZOBACZ_WPIS).click();
    }

    public boolean checkComment() {
        Stream<WebElement> comments = driver.findElements(By.cssSelector(".site"))
                .stream()
                .filter(c -> c.findElement(By.cssSelector(".entry-content > p")).getText().equals(WPIS1));
        return comments.count() == 1;
    }

    public void aWyloguj(){
        driver.findElement(By.linkText("Wylogować?")).click();

    }

    /*
    WebElement button = driver.findElement(By.cssSelector("#publish"));
       button.click();        WebElement postStatus = driver.findElement(By.cssSelector("#post-status-display"));
       WebDriverWait wait = new WebDriverWait(driver, 10);
       wait.until(ExpectedConditions.textToBePresentInElement(postStatus, "Opublikowano"));
     */


}
