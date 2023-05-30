package org.chris.browsetabs;

import org.chris.WebdriverConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BrowserTabsTest {

    private static final WebDriver driver = WebdriverConfiguration.getChromeDriver();
    private static final String browsersTabsURL = "https://automationtesting.co.uk/browserTabs.html";


    private static void openThreeTabs() {
        driver.get(browsersTabsURL);
        for (int i = 0; i < 3; i++) {
            driver.findElement(By.cssSelector("input[value='Open Tab']")).click();
        }

    }

    public static void closeGoogleTabs() {
        openThreeTabs();

        String parentName = driver.getWindowHandle();

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        Iterator<String> iterator = tabs.iterator();

        while (iterator.hasNext()) {
            String tabName = iterator.next();
            if (!tabName.equalsIgnoreCase(parentName)) {
                driver.switchTo().window(tabName).close();
            }

        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.close();
        driver.quit();
    }

}
