package org.chris.actions;

import org.chris.WebdriverConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActionsTest {
    // Not working
    private static final WebDriver driver = WebdriverConfiguration.getChromeDriver();
    private static final String contactFormURL = "https://automationtesting.co.uk";
    private static final By goToActionsPage = By.linkText("Actions");

    public static void goToTheActionPage() throws InterruptedException {
        driver.get(contactFormURL);
        driver.findElement(goToActionsPage).click();
        Thread.sleep(3000);
        driver.close();
        driver.quit();
    }

}
