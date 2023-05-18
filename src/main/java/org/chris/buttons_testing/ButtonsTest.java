package org.chris.buttons_testing;

import org.chris.WebdriverConfiguration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ButtonsTest {

    WebDriver driver = WebdriverConfiguration.getChromeDriver() ;
    private String testingButtonsURL = "https://automationtesting.co.uk/buttons.html";
    private final By buttonOneId = By.xpath("//button[@id='btn_one']");
    private final By buttonTwoId = By.cssSelector("#btn_two");



    public void testButtonOne() throws InterruptedException {
        driver.get(testingButtonsURL);
        driver.findElement(buttonOneId).click();
        Thread.sleep(3000);
        driver.close();
        driver.quit();
    }

    public void testButtonTwo() throws InterruptedException {
        driver.get(testingButtonsURL);
        WebElement button = driver.findElement(buttonTwoId);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", button);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(3000);
        driver.close();
        driver.quit();
    }
}
