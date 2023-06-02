package org.chris.automationtestingweb.teststore;

import org.chris.WebdriverConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SignInTest {

    private static WebDriver driver = WebdriverConfiguration.getChromeDriver();
    private static final String homePageURL = "http://teststore.automationtesting.co.uk/";
    private static final By signInButton = By.xpath("//span[normalize-space()='Sign in']");
    private static final By radioBttnMR = By.cssSelector("input[value='1'][name='id_gender']");
    private static final By radioBttnMRS = By.cssSelector("input[value='2'][name='id_gender']");
    private static final By firstNameField = By.cssSelector("input[name='firstname']");
    private static final By lastNameField = By.cssSelector("input[name='lastname']");
    private static final By emailField = By.cssSelector("input[name='email']");
    private static final By passwordField = By.cssSelector("input[name='password']");
    private static final By showButton = By.xpath("//button[normalize-space()='Show']");
    private static final By birthDateField = By.cssSelector("input[name='birthday']");
    private static final By saveButton = By.xpath("//button[normalize-space()='Save']");
    private static void goToSignInPage() {
        // Going to the Login page
        driver.get(homePageURL);
        driver.findElement(signInButton).click();
        // Pressing on 'No account? Create one here'
        driver.findElement(By.cssSelector("a[href='http://teststore.automationtesting.co.uk/login?create_account=1']")).click();
    }
    public static void goToLogInPageTest() {
        driver.get(homePageURL);
        driver.findElement(signInButton).click();
        String pageName = driver.getTitle();
        assertEquals("Login", pageName);
        driver.close();
        driver.quit();
    }

    public static void createAccountWithFullInformation() {
        goToSignInPage();
        // Testing radio buttons, pressing on Mr. and Mrs.
        driver.findElement(radioBttnMR).click();
        driver.findElement(radioBttnMRS).click();
        // Enter first name 'Daniel' and last name 'Williams'
        driver.findElement(firstNameField).sendKeys("Daniel");
        driver.findElement(lastNameField).sendKeys("Williams");
        // Enter email 'dan.williams@gmail.com'
        driver.findElement(emailField).sendKeys("dan.williams@gmail.com");
        // Enter password 1234567a and press on 'Show' button
        driver.findElement(passwordField).sendKeys("1234567a");
        driver.findElement(showButton).click();
        // Enter birthdate '05/12/1991'
        driver.findElement(birthDateField).sendKeys("05/12/1991");
        // Tick all boxes
        driver.findElement(By.cssSelector("input[name='optin']")).click();
        driver.findElement(By.cssSelector("input[name='newsletter']")).click();
        driver.findElement(By.cssSelector("input[name='psgdpr']")).click();

        // Slowing down execution
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Press on 'save' button
        driver.findElement(saveButton).click();

        // Slowing down execution
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement alert = driver.findElement(By.cssSelector(".alert.alert-danger"));
        if (alert.isEnabled()) {
            driver.close();
            driver.quit();
            throw new IllegalArgumentException("Email is already used");
        }
        else {
            System.out.println("Account created");
            driver.close();
            driver.quit();
        }
    }

    public static void createAnAccountWithoutInformation() {
        // Going to the Login Page
        goToSignInPage();
        driver.findElement(saveButton).click();
        String actual = driver.getTitle();
        String expected = "teststore";

        assertEquals(expected, actual);
        driver.close();
        driver.quit();
    }

}
