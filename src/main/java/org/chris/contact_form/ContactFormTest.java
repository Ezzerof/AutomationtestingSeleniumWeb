package org.chris.contact_form;

import org.chris.WebdriverConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactFormTest {

    private static final WebDriver driver = WebdriverConfiguration.getChromeDriver();
    private static final String contactFormURL = "https://automationtesting.co.uk/contactForm.html";
    private static final By firstNameLocation = By.name("first_name");
    private static final By lastNameLocation = By.name("last_name");
    private static final By emailAddressLocation = By.name("email");
    private static final By commentLocation = By.name("message");

    public static void fillContactForm(String firstName, String lastName, String emailAddress, String comment) throws InterruptedException {

        driver.get(contactFormURL);
        driver.findElement(firstNameLocation).sendKeys(firstName);
        driver.findElement(lastNameLocation).sendKeys(lastName);
        driver.findElement(emailAddressLocation).sendKeys(emailAddress);
        driver.findElement(commentLocation).sendKeys(comment);
        Thread.sleep(3000);
        driver.close();
        driver.quit();
    }

}
