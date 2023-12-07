package com.ecommerce.utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {
    private static final String screenshotDir = "screenshots";

    public static void captureScreenshot(WebDriver driver, String testName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String screenshotName = testName + "_" + timestamp + ".png";

            Path targetPath = Paths.get(screenshotDir, screenshotName);
            Files.copy(source.toPath(), targetPath);

            LoggerUtil.info("Screenshot captured: " + targetPath.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
