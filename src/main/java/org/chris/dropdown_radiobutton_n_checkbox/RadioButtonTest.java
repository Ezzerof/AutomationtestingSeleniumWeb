package org.chris.dropdown_radiobutton_n_checkbox;

import org.chris.WebdriverConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioButtonTest {

    private static final String radioBttnURL = "https://automationtesting.co.uk/dropdown.html";
    private static final WebDriver driver = WebdriverConfiguration.getChromeDriver();
    private static final By radioBttnOne = By.cssSelector("label[for='demo-priority-low']");
    private static final By radioBttnTwo = By.cssSelector("label[for='demo-priority-normal']");
    private static final By radioBttnThree = By.cssSelector("label[for='demo-priority-high']");

    private static void goToRadioPage() {
        driver.get(radioBttnURL);
    }

    public static void clickOnAllRadioButtons() {
        goToRadioPage();
        driver.findElement(radioBttnOne).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(radioBttnTwo).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(radioBttnThree).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.close();
        driver.quit();
    }

}
