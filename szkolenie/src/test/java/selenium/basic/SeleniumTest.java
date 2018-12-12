package selenium.basic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class SeleniumTest {

    private WebDriver driver;

    @BeforeEach
    public void startDriver() {
        System.setProperty("webdriver.chrome.driver","c:\\drivers\\chrome\\chromedriver.exe");
       driver = new ChromeDriver();
    }


    @Test
    public void canFindCodeSprintersOnGoogle() {

        driver.get("https://google.com");
      WebElement searchBox = driver.findElement(By.name("q"));
      searchBox.sendKeys("code sprinters");
      searchBox.submit();
        Stream<WebElement> searchResults = driver.findElements(By.cssSelector("div.rc")).stream();

        Stream<WebElement> resultFiltered  = searchResults.filter(r -> r.findElement(By.cssSelector("div.r > a")).getAttribute("href").equals("http://agileszkolenia.pl/"));
        List<WebElement> resultList  = resultFiltered.collect(Collectors.toList());

        Assertions.assertEquals(1 , resultList.size());
        WebElement result  = resultList.get(0);
        Assertions.assertEquals("agileszkolenia.pl/" , result.findElement(By.tagName("cite")).getText());

    }

    @Test
    public void  verifyFindAuthorOfBlogNoteAboutTransformtion () {
        driver.get("http://markowicz.pro/");
        Stream<WebElement> listOfNotes = driver. findElements(By.className("entry-title"))
                .stream()
                .filter(n -> n.findElement(By.tagName("a")).getText().equals("O transformacjach"));
        List<WebElement> filteredNotes  = listOfNotes.collect(Collectors.toList());
        Assertions.assertEquals(1 , filteredNotes.size() , "Only one matching note is found on main page");
    }

    @Test

    public void verifyAuthorOfBlogNoteAboutTransformationsStepByStep() {

        driver.get("http://markowicz.pro/");

        List<WebElement> listOfNotes = driver.findElements(By.className("entry-title"));
        Stream<WebElement> streamOfNotes = listOfNotes.stream();
        Stream<WebElement> filteredStream = streamOfNotes
        .filter(n -> n.findElement(By.tagName("a")).getText().equals("O transformacjach"));
        List<WebElement> filteredNotes = filteredStream.collect(Collectors.toList());
        Assertions.assertEquals(1, filteredNotes.size(), "Only one matching note is found on main page");



    }



    @AfterEach
    public void closeDriver() {
        driver.close();
    }
}

