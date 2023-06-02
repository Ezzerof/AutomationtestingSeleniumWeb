package org.chris.automationtestingweb.easyjet;

import org.chris.WebdriverConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class EasyJetTest {
    static WebDriver driver = WebdriverConfiguration.getChromeDriver();
    //    static WebDriver driver = WebdriverConfiguration.getEdgeDriver() ;
    private static String easyJetURL = "https://www.easyjet.com/en/";

    public static void goToEasyJet() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(easyJetURL);

//        // closing Cookie popup
//        driver.findElement(By.cssSelector("#ensCloseBanner")).click();

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.id("ensCloseBanner")));
        driver.findElement(By.id("ensCloseBanner")).click();


        // entering Origin
        driver.findElement(By.cssSelector("input[name='origin']")).click();
        driver.findElement(By.cssSelector("input[name='origin']")).sendKeys("London");

        List<WebElement> origins = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#ui-id-1 >li>a>span")));

        // Selecting Luton from all available airports
        for (WebElement origin : origins) {
            if (origin.getText().contains("Luton")) {
                origin.click();
            }
        }


        // entering destination
        driver.findElement(By.cssSelector("input[name='destination']")).click();
        driver.findElement(By.cssSelector("input[name='destination']")).sendKeys("Paris");
        List<WebElement> destinations = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#ui-id-2 >li>a>span")));

        // Selecting Orly from all Paris airports
        for (WebElement destination : destinations) {
            if (destination.getText().contains("Orly")) {
                destination.click();
            }
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.close();
        driver.quit();
    }

}
