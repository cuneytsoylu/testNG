package tests.day12;

import com.github.dockerjava.core.exec.WaitContainerCmdExec;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C02_MouseActions extends TestBase {
    // amazon ana sayfaya gidin sagUstte Hello, Signin elementinin
    // uzerinde mouse'u bekletin
    // acilan menu'de new list linkine tiklayin
    // ve new list sayfasinin acildigini test edin
    @Test
    public void amazonList() throws InterruptedException {
        // 1- https://www.amazon.com/ adresine gidelim
        driver.get("https://www.amazon.com/");
          //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirelim
        Actions actions=new Actions(driver);
        WebElement helloelement=driver.findElement(By.xpath("(//a[@class='nav-a nav-a-2   nav-progressive-attribute'])[1]"));
        actions.moveToElement(helloelement).perform();
            //3- “Create a list” butonuna basalim
        WebElement listElementi=driver.findElement(By.xpath("//span[text()='Create a List']"));
        actions.click(listElementi).perform();
       // 4- Acilan sayfada “Your Lists” yazisi oldugunu test edelim
        String actualtitle=driver.getTitle();
        String arananMetin="Your List";

        Assert.assertTrue(actualtitle.contains(arananMetin));

        //*********************  SoftAssert  ile    ******************************
       /*
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(actualtitle.contains(arananMetin));
        softAssert.assertAll();
        */
        Thread.sleep(3000);
    }
}