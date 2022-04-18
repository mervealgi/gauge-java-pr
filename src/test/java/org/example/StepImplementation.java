package org.example;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;

public class StepImplementation extends BaseTest {

    public void goToEnvUrl(){
        driver.get(testURL);
        this.logger.info(testURL + "adresine gidiliyor.");
    }

    @Step(" <second> saniye bekle")
    public void waitForSecond(int second) throws InterruptedException{
        Thread.sleep(1000*second);
    }

    public String getIfValueSaveKey(String value){
        String valueInSavekey;
        try{
            valueInSavekey = this.getIfValueSaveKey(value);
            log.info(value + " key ile saveKey icerisinde deger bulundu.(" + valueInSavekey + ")");
        } catch (NullPointerException var4) {
            valueInSavekey = value;
            value.info(value + " key ile saveKey icerisinde deger bulunamadı.Degerin kendisiyle devam ediliyor..(" + value + ")");
        }
        return valueInSavekey;
    }

    public void veriyfiedSelectedValueOfCombobox(String elementKey, String selectedValue) throws Exception{
        String valueInSavekey = this.getIfValueSaveKey(selectedValue);
        String selectedValueOfCombo = this.getSelectedValue(elementKey);
        Assertions.assertTrue(selectedValueOfCombo.equals(valueInSavekey), "Comboboxdaki secili deger dogrulanamadi.Beklenen secili deger " + valueInSaveKey)
    }



}
