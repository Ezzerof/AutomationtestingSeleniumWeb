package org.chris.buttons_testing;

import org.chris.WebdriverConfiguration;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ButtonsTest {

    WebDriver driver = WebdriverConfiguration.getChromeDriver() ;
    private String testingButtonsURL = "https://automationtesting.co.uk/buttons.html";
    private final By buttonOneId = By.xpath("//button[@id='btn_one']");
    private final By buttonTwoId = By.cssSelector("#btn_two");
    private final By buttonThreeId = By.cssSelector("#btn_three");
    private final By buttonFourId = By.cssSelector("#btn_four");



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

    public void testButtonThree() throws InterruptedException {
        driver.get(testingButtonsURL);
        WebElement buttonThree = driver.findElement(buttonThreeId);
        Actions actions = new Actions(driver);
        actions.moveToElement(buttonThree).click().perform();
        Thread.sleep(3000);
        driver.close();
        driver.quit();
    }

    public void testButtonFour() {
        driver.get(testingButtonsURL);
        WebElement element = driver.findElement(buttonFourId);
        if (element.isEnabled()) {
            element.click();
            System.out.println("Element is enable");
        }
        else
            System.out.println("Element is not enable");

    }
}
