package odevler;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.TestBase;

import java.time.Duration;

public class O1 extends TestBase {
    /*
      Ödev 1
"http://webdriveruniversity.com/Actions" sayfasina gidin
"Hover over Me First" kutusunun ustune gelin
"Link 1" e tiklayin
Popup mesajini yazdirin
Popup'i tamam diyerek kapatin
"Click and hold" kutusuna basili tutun
"Click and hold" kutusunda cikan yaziyi yazdirin
"Double click me" butonunu cift tiklayin
     */

    @Test
    public void testName() throws InterruptedException {
         /*
        Ödev 2
"http://webdriveruniversity.com/IFrame/index.html" sayfasina gidin
"Our Products" butonuna basin
"Cameras product"i tiklayin
Popup mesajini yazdirin
"close" butonuna basin
"WebdriverUniversity.com (IFrame)" linkini tiklayin
"http://webdriveruniversity.com/index.html" adresine gittigini test edin
         */
        //"http://webdriveruniversity.com/IFrame/index.html" sayfasina gidin
driver.get("http://webdriveruniversity.com/IFrame/index.html");
        //"Our Products" butonuna basin
WebElement ourproducts=driver.findElement(By.xpath("//iframe"));
driver.switchTo().frame(ourproducts);
        driver.findElement(By.xpath("//*[text()='Our Products']")).click();
        //"Cameras product"i tiklayin
driver.findElement(By.xpath("(//p)[2]")).click();
        //Popup mesajini yazdirin
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-body")));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("modal-body"))));
        WebElement popUp=driver.findElement(By.className("modal-body"));
        System.out.println("popUp.getText() = " + popUp.getText());
        //"close" butonuna basin

        driver.findElement(By.xpath("//*[text()='Close']")).click();

        //"WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().parentFrame();

        driver.findElement(By.xpath("//*[text()=\"WebdriverUniversity.com (IFrame)\"]")).click();


        //"http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String actualURL=driver.getCurrentUrl();
        String expectedURL="http://webdriveruniversity.com/index.html";
        Assert.assertEquals(expectedURL,actualURL);
    }

}

