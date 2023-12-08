package com.ecommerce.utilities;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {
    public static void captureScreenshot(WebDriver driver, String testName) {
        try {
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String screenshotName = testName + "_" + timestamp + ".png";
        	File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        	File destFile = new File("./Screenshots/"+screenshotName);
        	FileUtils.copyFile(srcFile, destFile);
            LoggerUtil.info("Screenshot captured");
        } catch (IOException e) {
            LoggerUtil.error("Error capturing screenshot: " + e.getMessage());
        } catch (Exception e) {
            LoggerUtil.error("Unexpected error capturing screenshot: " + e.getMessage());
        }
    }
}
