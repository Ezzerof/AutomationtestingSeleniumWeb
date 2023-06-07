package org.chris.testngtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class SignInWithParametersTest {
    private WebDriver driver;

    @BeforeSuite
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(2000);
    }

    @Parameters({"email", "password"})
    @Test
    public void signIn(String email, String password) throws InterruptedException {
        driver.get("http://teststore.automationtesting.co.uk/");

        // Go to 'Sign in' page
        driver.findElement(By.xpath("//span[normalize-space()='Sign in']")).click();

        // Inserting email (dan.williams@gmail.com) and password (1234567a)
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys(email);
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);

        Thread.sleep(2000);

        driver.findElement(By.cssSelector("#submit-login")).click();
    }


    @AfterSuite
    public void end() {
        driver.close();
        driver.quit();
    }
}
