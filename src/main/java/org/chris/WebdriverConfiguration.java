package org.chris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebdriverConfiguration {

    private static WebDriver driver;

    public static WebDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver");
        driver = new ChromeDriver();
        return driver;
    }

    public static WebDriver getMacChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/mac_chromedriver");
        driver = new ChromeDriver();
        return driver;
    }

    public static WebDriver getEdgeDriver() {
        System.setProperty("webdriver.edge.driver", "src\\main\\resources\\msedgedriver.exe");
        driver = new EdgeDriver();
        return driver;
    }

}
