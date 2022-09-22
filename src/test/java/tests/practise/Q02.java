package tests.practise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class Q02 {
    // http://www.bestbuy.com/ 'agidin,
    // Sayfa basliginin "Best" icerdigini dogrulayin
    // Ayrica relative Locator kullanarak;
    //      logoTest ==> BestBuy logosunun goruntulenip goruntulenmedigini dogrulayin
    //      mexicoLinkTest ==> Linkin goruntulenip goruntulenmedigini dogrulayin
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Before
    public void testtenOnce() {
        driver.get("http://www.bestbuy.com/");
    }
    @Test
    public void titleTest(){
        String title =driver.getTitle();
        boolean iceriyorMu=title.contains("Best");
        Assert.assertTrue("Title Best kelimesi icermiyor",iceriyorMu);
    }
    @Test
    public void logoTest(){
        WebElement helloHeading=driver.findElement(By.xpath("(//div[@class='heading'])[1]"));
        WebElement logo=driver.findElement(RelativeLocator.with(By.tagName("img")).above(helloHeading));
        // boolean logoGorunuyorMu=logo.isDisplayed();
        // Assert.assertTrue(logoGorunuyorMu);
        Assert.assertTrue(logo.isDisplayed());
    }
    @Test
    public void linkTest(){
        WebElement usLink=driver.findElement(By.xpath("(//img[@alt='United States'])[1]"));
        WebElement choseYazisi=driver.findElement(By.xpath("//h1[.='Choose a country.']"));
        WebElement mexicoLink=driver.findElement(RelativeLocator.with(By.tagName("a")).toRightOf(usLink).below(choseYazisi));
        Assert.assertTrue(mexicoLink.isDisplayed());
    }
    @AfterClass
    public static void testtenSonra(){
        driver.quit();
    }
}
