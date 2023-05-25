package org.chris.hidden_elements;

import org.chris.WebdriverConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HiddenElementsTest {

    static WebDriver driver = WebdriverConfiguration.getChromeDriver();
    private static String hiddenElementsPageURL = "https://automationtesting.co.uk/hiddenElements.html";
    private static final By toggleBttn = By.cssSelector("button[onclick='myFunction()']");

    public static void showHiddenElements() {

        driver.get(hiddenElementsPageURL);
        WebElement hiddenElement = driver.findElement(By.cssSelector("#myDIV"));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (hiddenElement.isDisplayed())
            System.out.println(hiddenElement.getText());
        else {
            driver.findElement(toggleBttn).click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(hiddenElement.getText());
        }
        driver.close();
        driver.quit();
    }

}
