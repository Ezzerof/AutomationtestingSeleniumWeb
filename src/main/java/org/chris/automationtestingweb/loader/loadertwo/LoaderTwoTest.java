package org.chris.automationtestingweb.loader.loadertwo;

import org.chris.WebdriverConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class LoaderTwoTest {

    static WebDriver driver = WebdriverConfiguration.getChromeDriver();
    private static String loaderTwoPageURL = "https://automationtesting.co.uk/loadertwo.html";
    private static final By thirdParagraph = By.cssSelector("#appears");

    public static void checkForVisibilityOfThirdParagraph() {

        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        driver.get(loaderTwoPageURL);
        wait.withTimeout(Duration.ofSeconds(8));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.ignoring(NoSuchElementException.class);

        WebElement thirdP = wait.until(webDriver -> webDriver.findElement(thirdParagraph));
        System.out.println(thirdP.getText());

        driver.close();
        driver.quit();

    }

}
