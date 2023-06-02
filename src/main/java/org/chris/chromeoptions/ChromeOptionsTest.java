package org.chris.chromeoptions;

import org.chris.WebdriverConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Set;

public class ChromeOptionsTest {
    private static WebDriver driver;
    public static void runMaximizedAndIncognito() {
        driver = WebdriverConfiguration.getChromeDriverOption("--start-maximized", "--incognito");
        driver.get("https://automationtesting.co.uk/index.html");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.close();
        driver.quit();
    }

    public static void runBrowserWithAdBlocker() {
        driver = WebdriverConfiguration.getChromeDriverWithAdBlock();
        driver.get("https://automationexercise.com/");

        String parentHandle = driver.getWindowHandle();

        Set<String> windowHandles = driver.getWindowHandles();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (String windowHandle : windowHandles) {
            if (!windowHandle.equalsIgnoreCase(parentHandle)) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                driver.switchTo().window(windowHandle);
                driver.close();
            }
        }

        driver.close();
        driver.quit();

    }

}
