package com.example.test;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver;

    @BeforeScenario
    public static void setUp() throws MalformedURLException, Exception {
        String BaseUrl = " ";
        DesiredCapabilities capabilities;
        if (StringUtils.isEmpty(System.getenv("key"))) {
            capabilities = DesiredCapabilities.chrome();
            ChromeOptions options = new ChromeOptions();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
            driver = new ChromeDriver(capabilities);
        }
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS).implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
        driver.get(BaseUrl);
    }

    @AfterScenario
    public void tearDown() throws Exception {
        driver.quit();
    }
}