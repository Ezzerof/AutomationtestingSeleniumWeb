package org.chris;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class WebdriverConfiguration {

    private static WebDriver driver;

    public static WebDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }
    public static WebDriver getChromeDriverWithAdBlock() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        DesiredCapabilities capabilities = new DesiredCapabilities();

        options.addExtensions(new File("src\\main\\resources\\adblock.crx"));
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        options.merge(capabilities);
        driver = new ChromeDriver(options);
        return driver;
    }

    public static WebDriver getChromeDriverOption(String option) {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments(option);
        driver = new ChromeDriver(options);
        return driver;
    }

    public static WebDriver getChromeDriverOption(String option1, String option2) {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments(option1);
        options.addArguments(option2);
        driver = new ChromeDriver(options);
        return driver;
    }

    public static WebDriver getChromeDriverOption(String option1, String option2, String option3) {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments(option1);
        options.addArguments(option2);
        options.addArguments(option3);
        driver = new ChromeDriver(options);
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
