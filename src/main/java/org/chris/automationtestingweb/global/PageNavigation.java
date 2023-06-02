package org.chris.automationtestingweb.global;

import org.chris.WebdriverConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageNavigation {

    private static final WebDriver driver = WebdriverConfiguration.getChromeDriver() ;
    private static String testingButtonsURL = "https://automationtesting.co.uk";
    private static final By loaderTab = By.linkText("Loader");

    public static void goToLoaderTab() {
        driver.get(testingButtonsURL);
        driver.findElement(loaderTab);
    }

}
