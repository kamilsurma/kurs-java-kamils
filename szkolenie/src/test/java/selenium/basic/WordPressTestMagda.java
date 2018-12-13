package selenium.basic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WordPressTestMagda {

    private WebDriver driver;

    private WebElement comment;

    @BeforeEach

    public void startDriver() {

        driver = new ChromeDriver();        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);    }


        @Test
    public void commentBlog(){
        driver.get("https://automatyzacja.benedykt.net/");
        driver.findElement(By.className("entry-title")).findElement(By.tagName("a")).click();
        comment = driver.findElement(By.name("comment"));
        comment.sendKeys("Mój komentarz");
        driver.findElement(By.name("author")).sendKeys("Autor");
        driver.findElement(By.name("email")).sendKeys("adres@email.pl");
        driver.findElement(By.name("submit")).click();

    }
    @AfterEach
    public void closeDriver() {        driver.quit();    }

}


