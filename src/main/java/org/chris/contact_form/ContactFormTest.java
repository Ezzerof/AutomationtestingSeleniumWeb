package org.chris.contact_form;

import org.chris.WebdriverConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactFormTest {

    private static final WebDriver driver = WebdriverConfiguration.getChromeDriver();
    private static final String contactFormURL = "https://automationtesting.co.uk/contactForm.html";
    private static final By firstNameLocation = By.name("first_name");
    private static final By lastNameLocation = By.name("last_name");
    private static final By emailAddressLocation = By.name("email");
    private static final By commentLocation = By.name("message");
    private static final By submitButton = By.cssSelector("input[value='SUBMIT']");
    private static final By thankYouMsg = By.cssSelector("div[class='col-8 col-12-small'] h3");

    public static void fillContactForm(String firstName, String lastName, String emailAddress, String comment) throws InterruptedException {
        // going to the Contact form page
        driver.get(contactFormURL);

        //filling page with some information
        driver.findElement(firstNameLocation).sendKeys(firstName);
        driver.findElement(lastNameLocation).sendKeys(lastName);
        driver.findElement(emailAddressLocation).sendKeys(emailAddress);
        driver.findElement(commentLocation).sendKeys(comment);
        Thread.sleep(3000);

        // clicking on submit button
        driver.findElement(submitButton).click();

        // validating the message
        WebElement msg = driver.findElement(thankYouMsg);
        if ("Thank you for your mail!".equals(msg.getText()))
            System.out.println("Successful");
        else
            System.out.println(msg.getText());
        driver.close();
        driver.quit();
    }

}
