package org.chris.popup_n_alerts;

import org.chris.WebdriverConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class AlertsAndPopupTest {

    static WebDriver driver = WebdriverConfiguration.getChromeDriver() ;
    private static String alertAndPopupURL = "https://automationtesting.co.uk/popups.html";
    private static final By triggerAlertButton = By.cssSelector("button[onclick='alertTrigger()']");
    private static final By triggerPopUpButton = By.cssSelector("button[onclick='popup()']");

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

    public static void popUpTesting() {
        goToAlertAndPopupPage();
        driver.findElement(triggerPopUpButton).click();
        // Saving Id of the main page
        String mainWindow = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterate = handles.iterator();

        // Will iterate through all windows and close them
        while (iterate.hasNext()) {
            String child = iterate.next();

            if (!mainWindow.equalsIgnoreCase(child)) {
                driver.switchTo().window(child);
                driver.close();
            }
        }
        driver.switchTo().window(mainWindow);
        driver.close();
        driver.quit();
    }

}
