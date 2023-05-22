package org.chris.calculator;

import org.chris.WebdriverConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalculatorTest {

    private static WebDriver driver = WebdriverConfiguration.getMacChromeDriver();
    private static final String calculatorURL = "https://automationtesting.co.uk/calculator.html";
    private static final By two = By.cssSelector("input[value='2']");
    private static final By five = By.cssSelector("input[value='5']");
    private static final By addOperation = By.cssSelector("input[value='+']");
    private static final By equalSign = By.cssSelector("input[value='=']");
    private static final By result = By.cssSelector("#result");

    public static void addTwoAndFive() {
        driver.get(calculatorURL);
        driver.findElement(two).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(addOperation).click();
        driver.findElement(five).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(equalSign).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement sum = driver.findElement(result);

        if ("7".equals(sum.getAttribute("value")))
            System.out.println("True");
        else
            System.out.println("False");
        driver.close();
        driver.quit();
    }

}
