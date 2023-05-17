package org.chris.buttons_testing;

import org.chris.WebdriverConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ButtonsTest {

    WebDriver driver = WebdriverConfiguration.getChromeDriver() ;
    private final By buttonOneId = By.id("btn_one");
    private String testingButtonsURL = "https://automationtesting.co.uk/buttons.html";


    public void testButtonOne() throws InterruptedException {
        driver.get(testingButtonsURL);
        driver.findElement(buttonOneId).click();
        Thread.sleep(3000);
        driver.close();
        driver.quit();
    }


}
