package org.chris.dropdown_n_checkbox;

import io.cucumber.java.eo.Se;
import org.chris.WebdriverConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownTest {

    private static final String dropdownURL = "https://automationtesting.co.uk/dropdown.html";
    private static final WebDriver driver = WebdriverConfiguration.getChromeDriver();

    public static void dropdownTest() throws InterruptedException {
        driver.get(dropdownURL);
        Select audiSelection = new Select(driver.findElement(By.cssSelector("#cars")));
        audiSelection.selectByVisibleText("Mercedes");
        Thread.sleep(2000);
        driver.close();
        driver.quit();
    }

}
