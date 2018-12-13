package selenium.pagesautomatyzacja.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlogMainPage {

    public BlogMainPage(WebDriver driver) {
        this.driver = driver;
    }

    private final WebDriver driver;



    public void  pressNoteMenu() {
        driver.findElement(By.id("adminmenu")).findElement(By.xpath("//div[.='Wpisy']")).click();
        driver.findElement(By.id("adminmenu")).findElement(By.xpath("//a[.='Dodaj nowy']")).click();
    }
}
