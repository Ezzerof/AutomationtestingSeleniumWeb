package org.chris.automationtestingweb.actions;

import org.chris.WebdriverConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActionsTest {
    // Not working
    private static WebDriver driver = WebdriverConfiguration.getChromeDriver();
//    private static WebDriver driver = WebdriverConfiguration.getMacChromeDriver();
    private static final String actionsPageURL = "https://automationtesting.co.uk/actions.html";
    private static final By dragMeButton = By.xpath("//p[@id='dragtarget']");
    private static final By placeWhereToDrag = By.cssSelector("(//div[@class='droptarget'])[2]");

    public static void goToTheActionPage() {
        driver.get(actionsPageURL);
        String pageName = driver.getTitle();
        assertEquals("Actions", pageName);
        driver.close();
        driver.quit();
    }

    public static void interactWithDragMeButton() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(actionsPageURL);

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

    public static void doubleClick() throws InterruptedException {
        driver.get(actionsPageURL);
        WebElement button = driver.findElement(By.xpath("//div[@class='col-6 col-12-medium ']//p[@id='doubClickStartText']"));
        Actions actions = new Actions(driver);
        actions.doubleClick(button);
        Thread.sleep(3000);
        driver.close();
        driver.quit();
    }

}
