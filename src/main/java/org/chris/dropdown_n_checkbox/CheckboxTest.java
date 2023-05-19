package org.chris.dropdown_n_checkbox;

import org.chris.WebdriverConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxTest {

    private static final String checkboxURL = "https://automationtesting.co.uk/dropdown.html";
    private static final WebDriver driver = WebdriverConfiguration.getChromeDriver();


    public static void checkTheCheckbox() {
        driver.get(checkboxURL);
        WebElement checkbox = driver.findElement(By.cssSelector("input#cb_red"));
        System.out.println(checkbox.isSelected());
        driver.close();
        driver.quit();
    }

}
