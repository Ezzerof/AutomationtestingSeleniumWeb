package org.chris.cookies;

import org.chris.WebdriverConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CookieManipulation {

    private static WebDriver driver;

    public static void goToHomePage() {
        driver = WebdriverConfiguration.getChromeDriverWithAdBlock();
        driver.get("http://teststore.automationtesting.co.uk/");

        String parentHandle = driver.getWindowHandle();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Set<String> windowHandles = driver.getWindowHandles();

        for (String windowHandle : windowHandles) {
            if (!windowHandle.equalsIgnoreCase(parentHandle)) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                driver.switchTo().window(windowHandle);
                driver.close();
            }
        }
        driver.switchTo().window(parentHandle);

        // going to 'Sign in' page
        driver.findElement(By.cssSelector("[title] .hidden-sm-down")).click();
        // enter email address
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("dan.williams@gmail.com");
        // enter password
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("1234567a");
        // press on 'SIGN IN' button
        driver.findElement(By.cssSelector("button#submit-login")).click();
        // going to 'Clothes' link
        driver.findElement(By.linkText("CLOTHES")).click();
        // selecting first product
        driver.findElement(By.cssSelector("img[alt='Hummingbird printed t-shirt']")).click();
        // add to cart item
        driver.findElement(By.cssSelector("[data-button-action]")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // press on 'Continue shopping'
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement continueShoppingBttn = driver.findElement(By.cssSelector(".cart-content-btn [data-dismiss]"));
        wait.until(ExpectedConditions.visibilityOf(continueShoppingBttn)).click();

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();

        int actualNumberOfProductsInCart = Integer.parseInt(driver.findElement(By.cssSelector(".cart-products-count")).getText().substring(1,2));

        assertEquals(0, actualNumberOfProductsInCart);

    }


}
