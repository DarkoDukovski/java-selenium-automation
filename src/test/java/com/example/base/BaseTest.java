package com.example.base;

import com.example.utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    // Made public so TestListener can access it via Reflection
    public WebDriver driver;
    protected static final Logger log = LogManager.getLogger(BaseTest.class);
    protected ConfigReader config = new ConfigReader();

    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional String browserParam) {
        String browser = browserParam != null ? browserParam : config.getProperty("browser");
        log.info("Initializing WebDriver for browser: " + browser);

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            
            // Dynamic headless mode support for CI/CD Pipeline
            String headlessProperty = System.getProperty("headless");
            if (headlessProperty != null && headlessProperty.equalsIgnoreCase("true")) {
                options.addArguments("--headless=new"); // New Chrome headless mode
                options.addArguments("--window-size=1920,1080"); // Explicit size for headless interactions (drag & drop fix)
            }
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        } else {
            throw new RuntimeException("Unsupported browser configuration: " + browser);
        }

        int timeout = Integer.parseInt(config.getProperty("timeout"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
        log.info("Driver setup complete with timeout of " + timeout + " seconds.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            log.info("Quitting the WebDriver.");
            driver.quit();
        }
    }

    // Utility for ExtentReports listener to capture failures
    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
        FileUtils.copyFile(source, file);
        return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
    }
}
