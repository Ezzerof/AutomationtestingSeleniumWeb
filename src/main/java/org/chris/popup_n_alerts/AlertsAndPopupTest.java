package org.chris.popup_n_alerts;

import org.chris.WebdriverConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsAndPopupTest {

    static WebDriver driver = WebdriverConfiguration.getChromeDriver() ;
    private static String alertAndPopupURL = "https://automationtesting.co.uk/popups.html";
    private static final By triggerAlertButton = By.cssSelector("button[onclick='alertTrigger()']");

    private static void goToAlertAndPopupPage() {
        driver.get(alertAndPopupURL);
    }

    public static void triggerAlert() {
        goToAlertAndPopupPage();
        driver.findElement(triggerAlertButton).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.switchTo().alert().accept();
        driver.close();
        driver.quit();
    }

}
