package org.chris.screenshot;

//import org.apache.commons.io.FileUtils;
import org.chris.WebdriverConfiguration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShotTaker {

    static WebDriver driver;
    public static void goToHomePageAndTakeScreenShot() {
        driver = WebdriverConfiguration.getChromeDriver();
        driver.get("http://teststore.automationtesting.co.uk/");
        driver.manage().window().maximize();
        takeSnapShot(driver);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.close();
        driver.quit();
    }

    private static void takeSnapShot(WebDriver driver) {
        // taking screenshots by using apache commons io

        File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        File destFile =  new File("src\\main\\resources\\Screenshots\\" + timestamp() + ".png");

//        try {
//            FileUtils.copyFile(sourceFile, destFile);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

    private static String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }

}
