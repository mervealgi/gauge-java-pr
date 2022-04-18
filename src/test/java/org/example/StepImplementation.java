package org.example;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;

public class StepImplementation extends com.example.test.BaseTest {

    @Step(" <second> saniye bekle")
    public void waitForSecond(int second) throws InterruptedException{
        Thread.sleep(1000*second);
    }

    @Step("Arama alanına <key> bilgisini yazdır")
    public void search(String key){
        driver.findElement(By.cssSelector("")).sendKeys();
    }



}
