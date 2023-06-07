package org.chris.testngtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class SignInTest {
    private WebDriver driver;

    @BeforeSuite
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(2000);
    }

    @BeforeMethod
    public void signIn() throws InterruptedException {
        driver.get("http://teststore.automationtesting.co.uk/");

        // Go to 'Sign in' page
        driver.findElement(By.xpath("//span[normalize-space()='Sign in']")).click();

        // Inserting email (dan.williams@gmail.com) and password (1234567a)
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("dan.williams@gmail.com");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("1234567a");

        Thread.sleep(2000);

        driver.findElement(By.cssSelector("#submit-login")).click();
    }

    @Test
    public void goToClothesPage() {

        // Go to 'Clothes' page
        driver.findElement(By.linkText("CLOTHES")).click();

    }

    @AfterMethod
    public void signOut() {
        // Press on Sign out
        driver.findElement(By.cssSelector(".logout.hidden-sm-down")).click();
    }

    @AfterSuite
    public void end() {
        driver.close();
        driver.quit();
    }

}
