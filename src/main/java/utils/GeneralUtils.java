package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class GeneralUtils {
    protected WebDriver driver;
    private Properties properties;


    public Properties loadProperties() {
        properties = new Properties();
        try (FileInputStream file = new FileInputStream("src/main/config/config.properties")) {
            properties.load(file);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
        return properties;
    }

    private WebDriver getCloudDriver(String browser) {
        String userid = properties.getProperty("userid");
        String accessKey = properties.getProperty("accessKey");

        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("userid", userid);
        sauceOptions.put("accessKey", accessKey);
        sauceOptions.put("build", "selenium-build-1ULB4");
        sauceOptions.put("name", "Test");

        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-maximized");
                chromeOptions.setPlatformName("Windows 11");
                chromeOptions.setBrowserVersion("latest");
                chromeOptions.setCapability("sauce:options", sauceOptions);
                return new RemoteWebDriver(getSauceLabsUrl(), chromeOptions);

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("start-maximized");
                firefoxOptions.setPlatformName("Windows 10");
                firefoxOptions.setBrowserVersion("latest");
                firefoxOptions.setCapability("sauce:options", sauceOptions);
                return new RemoteWebDriver(getSauceLabsUrl(), firefoxOptions);

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("start-maximized");
                edgeOptions.setPlatformName("Windows 11");
                edgeOptions.setBrowserVersion("latest");
                edgeOptions.setCapability("sauce:options", sauceOptions);
                return new RemoteWebDriver(getSauceLabsUrl(), edgeOptions);

            case "safari":
                SafariOptions safariOptions = new SafariOptions();
                safariOptions.setPlatformName("Mac OS 11.0");
                safariOptions.setBrowserVersion("latest");
                safariOptions.setCapability("sauce:options", sauceOptions);
                return new RemoteWebDriver(getSauceLabsUrl(), safariOptions);

            default:
                throw new RuntimeException("Unsupported browser: " + browser);
        }
    }

    public URL getSauceLabsUrl() {
        try {
            return new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException("Please check the Sauce Labs URL", e);
        }
    }
    public WebDriver getLocalDriver(Properties prop) {
        String browser = prop.getProperty("browser");
        switch (browser.toLowerCase()) {
            case "safari":
                driver= new SafariDriver();
                break;
            case "chrome":
                driver= new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Incorrect Browser: " + browser);
        }
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        return driver;
    }
}
