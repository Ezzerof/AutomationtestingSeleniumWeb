package org.chris.automationtestingweb.accordion;

import org.chris.WebdriverConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccordionTest {

    static WebDriver driver = WebdriverConfiguration.getChromeDriver();
    private static String accordionpageURL = "https://automationtesting.co.uk/accordion.html";

    public static void pressOnAllAccordions(int n) {
        driver.get(accordionpageURL);

        for (int i = 0; i != n; i++) {
            driver.findElement(By.xpath("//div[normalize-space()='Platform Portability']")).click();
            driver.findElement(By.xpath("//div[normalize-space()='Language Support']")).click();
            driver.findElement(By.xpath("//div[normalize-space()='Selenium Grid']")).click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        driver.close();
        driver.quit();
    }

}
