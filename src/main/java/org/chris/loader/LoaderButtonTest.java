package org.chris.loader;

import org.chris.WebdriverConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoaderButtonTest {

    static WebDriver driver = WebdriverConfiguration.getChromeDriver();
    private static String loaderPageURL = "https://automationtesting.co.uk/loader.html";
    private static final By clickMeButton = By.cssSelector("#loaderBtn");

    public static void clickOnClickMeBttnImplicit() {
        // Created an implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get(loaderPageURL);
        driver.findElement(clickMeButton).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.close();
        driver.quit();
    }

    public static void clickOnClickMeBttnExplicit() {
        driver.get(loaderPageURL);
        // Created an explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        WebElement bttn = driver.findElement(clickMeButton);
//        wait.until(ExpectedConditions.elementToBeClickable(bttn));
        wait.until(ExpectedConditions.visibilityOf(bttn));
        bttn.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.close();
        driver.quit();
    }

}
