package tests.practice02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q06 extends TestBase {

    @Test
    public void test() throws InterruptedException {
        // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        // web sitesini maximize yapin
        driver.manage().window().maximize();

        // ikinci emojiye tiklayin
        /*1. yol*/
        /*driver.switchTo().frame("emoojis");*/

        /*2. yol*/

        WebElement iframe=driver.findElement(By.xpath("//iframe[@id='emoojis']"));
        driver.switchTo().frame(iframe);

        WebElement secondEmoji=driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]"));
        secondEmoji.click();

        // tüm ikinci emoji ogelerini tiklayin
        List<WebElement>emojiler=driver.findElements(By.xpath("//div[@id='nature']/div/img"));

        for (WebElement w:emojiler) {
            w.click();
        }
     /*lambda ile  --> */   //emojiOgeler.stream().forEach(x->x.click());   ==> yukaridaki for each yerine bu lambda satiri a kullanilabilir.
        System.out.println("ogeler tiklandi..");

        // parent iframe e geri donun
        driver.switchTo().defaultContent();

        // formu doldurun, (istediginiz metinlerle)
        List<WebElement>metinList=driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));

        List<String>metin=new ArrayList<>(Arrays.asList("Bir","iframe","sorusu","bu","kadar","eglenceli","olabilir","sizce de","oyle degil mi?","",""));

        for (int i = 0; i <metinList.size() ; i++) {
            metinList.get(i).sendKeys(metin.get(i));
        }
        Thread.sleep(3000);

        // apply butonuna basin
        driver.findElement(By.xpath("//button[@id='send']")).click();


    }

}
