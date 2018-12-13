package selenium.pagesautomatyzacja.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlogLoginPage {


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
        driver.findElement(LOGIN_BOX).sendKeys(USER);
        driver.findElement(PASSWORD_BOX).sendKeys(PASSWORD);
        driver.findElement(LOGIN_BUTTON).submit();
    }
}
