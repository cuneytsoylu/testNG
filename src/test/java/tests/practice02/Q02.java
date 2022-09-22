package tests.practice02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class Q02 {
    // birbirine bagimli testler olusturun..
    // BeforeClass olusturup setUp ayarlarini yapin..
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    // birbirine bagimli testler olusturarak;

    @Test(dependsOnMethods ="googleTest" )
    public void amazonTest(){
        //     daha sonra google'a bagimli olarak amazon'a gidin
        driver.get("https://www.amazon.com");
    }

    @Test(dependsOnMethods ="facebookTest" )
    public void googleTest(){
        //     daha sonra facebook'a bagimli olarak google'a gidin,
        driver.get("https://www.google.com");
    }

    @Test// (enabled = false) olursa test failed olur
    public void facebookTest(){
        //     ilk once facebook'a gidin
        driver.get("https://www.facebook.com");
    }



    @AfterClass
    public void teardown(){
        // driver'i kapatin
        driver.close();
    }
}
