package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

// Bir class olusturun "C04_Dropdown"
public class C04_Dropdown {
    WebDriver driver;
    WebElement dropdownElementi;
    Select select;
    @BeforeClass
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
        Thread.sleep(1000);
    }

    @Test(priority = 2)
    public void test1() throws InterruptedException {
        // https://www.amazon.com/ adresine gidiniz.
        // driver.get("https://www.amazon.com/");
        // -Test 1
        //  Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        dropdownElementi=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select=new Select(dropdownElementi);

        List<WebElement>optionListesi=select.getOptions();

        int actualOptionSayisi=optionListesi.size();
        int expectedOptionSayisi=45;

        Assert.assertEquals(actualOptionSayisi,expectedOptionSayisi);
        Thread.sleep(5000);
    }
    @Test(priority = 1)
    public void test2() throws InterruptedException {
        // -Test 2
        // driver.get("https://www.amazon.com/");
        //  1. Kategori menusunden Books secenegini secin
        driver.findElement(By.xpath("//option[@value='search-alias=stripbooks-intl-ship']")).click();
        //  2. Arama kutusuna "Java" yazip aratin
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java"+ Keys.ENTER);

        //  3. Bulunan sonuc sayisini yazdirin
        WebElement sonucSayisiElementi=driver.findElement(By.xpath("//div[span='1-16 of over 30,000 results for']"));
        System.out.println(sonucSayisiElementi.getText());
        //  4. Sonucun "Java" kelimesini icerdigini test edin..
        WebElement sonucYazisiElementi=driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        System.out.println(sonucYazisiElementi.getText());
        Thread.sleep(5000);
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}
