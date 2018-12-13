package selenium.pagesautomatyzacja.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.stream.Stream;

public class BlogMainPage {

    public BlogMainPage(WebDriver driver) {
        this.driver = driver;
    }

    private final WebDriver driver;



    public void  pressNoteMenu() {
        driver.findElement(By.id("adminmenu")).findElement(By.xpath("//div[.='Wpisy']")).click();
        driver.findElement(By.id("adminmenu")).findElement(By.xpath("//a[.='Dodaj nowy']")).click();
    }


    public boolean checkPublishComment() {
        NewPostPage newPostPage = new NewPostPage(driver);
        Stream<WebElement> comments = driver.findElements(By.cssSelector(".drafts"))
                .stream()
                .filter(c -> c.findElement(By.cssSelector(".hide-if-no-js > p")).getText().equals(newPostPage.getWPIS1()));
        return comments.count() == 1;

    }
}
