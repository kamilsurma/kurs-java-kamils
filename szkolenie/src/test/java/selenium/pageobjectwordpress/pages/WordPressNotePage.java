package selenium.pageobjectwordpress.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.UUID;
import java.util.stream.Stream;

public class WordPressNotePage {


    private final WebDriver wprpDriver;
    String comment = UUID.randomUUID().toString();

    String author = UUID.randomUUID().toString();

    String email = UUID.randomUUID() + "@test.com";

    public WordPressNotePage(WebDriver  driver) {
       wprpDriver = driver;
    }

public void addComment() {
    wprpDriver.findElement(By.id("comment")).sendKeys(comment);
    wprpDriver.findElement(By.id("author")).sendKeys(author);
    wprpDriver.findElement(By.id("email")).sendKeys(email);
    WebElement submit =wprpDriver.findElement(By.id("submit"));
    JavascriptExecutor jsExec = (JavascriptExecutor) wprpDriver;
    jsExec.executeScript("arguments[0].scrollIntoView(true);", submit);
    submit.click();
}

public boolean checkComment() {

    Stream<WebElement> comments = wprpDriver.findElements(By.cssSelector(".comment-list > .comment"))

            .stream()

            .filter(c -> c.findElement(By.cssSelector(".comment-author > b")).getText().equals(author))

            .filter(c -> c.findElement(By.cssSelector(".comment-content > p")).getText().equals(comment));

  return  comments.count() == 1;

}




}
