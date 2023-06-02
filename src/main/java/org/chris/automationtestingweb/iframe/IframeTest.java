package org.chris.automationtestingweb.iframe;

import org.chris.WebdriverConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class IframeTest {

    static WebDriver driver = WebdriverConfiguration.getChromeDriver();
    private static String iframeURL = "https://automationtesting.co.uk/iframes.html";

    private static void goToIframePage() {
        driver.get(iframeURL);
    }

    public static void toggleMenuOnIframeAndParent() {
        goToIframePage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.switchTo().frame(0);
        driver.findElement(By.cssSelector(".toggle")).click();

        driver.switchTo().parentFrame();
        driver.findElement(By.cssSelector(".toggle")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.close();
        driver.quit();
    }

    public static void pressPlayOnVideoIframe() {
        goToIframePage();

        driver.switchTo().frame(1);
        driver.findElement(By.cssSelector("[aria-label='Play']")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.close();
        driver.quit();
    }

}
