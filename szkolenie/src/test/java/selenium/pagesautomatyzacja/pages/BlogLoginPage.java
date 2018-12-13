package selenium.pagesautomatyzacja.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.pageobject.BaseTest;

import java.util.concurrent.TimeUnit;

public class BlogLoginPage extends BaseTest {


    private final WebDriver driver;
    private final static String URL_BLOG_PAGE = "https://automatyzacja.benedykt.net/wp-admin";
    private final static String USER = "automatyzacja";
    private final static String PASSWORD = "jesien2018";
    private static final By LOGIN_BOX = By.id("user_login");
    private static final By PASSWORD_BOX = By.id("user_pass");
    private static final By LOGIN_BUTTON = By.id("wp-submit");


    public BlogLoginPage(WebDriver driver) {
        this.driver = driver;
        driver.get(URL_BLOG_PAGE);
        WebDriverWait webDriverWait = new WebDriverWait(driver, 20);
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(LOGIN_BOX)));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON));
        driver.findElement(LOGIN_BOX).sendKeys(USER);
        driver.findElement(PASSWORD_BOX).sendKeys(PASSWORD);
        driver.findElement(LOGIN_BUTTON).submit();


    }
}
