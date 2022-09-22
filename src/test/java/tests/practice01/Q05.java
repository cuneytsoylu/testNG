package tests.practice01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q05 {
    // ...Exercise5...
    // @BeforeClass'in icine driver'i kuralim
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // maximize edip tum web elementler yuklenene kadar 10sn bekletelim
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void test1() {
        // Google'a gidelim ve sayfa basliginin "Google" icerdigini dogrulayalim
        driver.get("https://www.google.com");
    }


    // Amazon'a gidelim ve url in www.amazon.com icerip icermedigini dogrulayalim
    // @AfterClass to driver'i kapatalim
}
