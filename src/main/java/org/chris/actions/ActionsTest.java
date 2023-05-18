package org.chris.actions;

import org.chris.WebdriverConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionsTest {
    // Not working
    private static final WebDriver driver = WebdriverConfiguration.getChromeDriver();
    private static final String contactFormURL = "https://automationtesting.co.uk/actions.html";
    private static final By dragMeButton = By.xpath("//p[@id='dragtarget']");
    private static final By placeWhereToDrag = By.cssSelector("(//div[@class='droptarget'])[2]");

    public static void goToTheActionPage() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(contactFormURL);
        WebElement sourceElement = driver.findElement(dragMeButton);
        WebElement targetElement = driver.findElement(placeWhereToDrag);
        Actions action = new Actions(driver);
        action.clickAndHold(sourceElement)
                        .moveToElement(targetElement)
                                .release()
                                        .build()
                                                .perform();

        driver.close();
        driver.quit();
    }

}
