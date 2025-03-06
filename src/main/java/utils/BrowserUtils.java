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

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BrowserUtils{
    protected WebDriver driver;
    protected String optionType;
    protected String userid;
    protected String accessKey;
    protected String browserType;

    public WebDriver getBrowser(String platform, String browser) {
        if (platform.equalsIgnoreCase("cloud")) {
            return getCloudDriver(browser, userid, accessKey);
        } else if (platform.equalsIgnoreCase("local")) {
        }
        return getLocalDriver(browser);
    }

    public WebDriver getCloudDriver(String browser, String userid, String accessKey) {
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

    private URL getSauceLabsUrl() {
        try {
            return new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException("Please check the Sauce Labs URL", e);
        }
    }

    public WebDriver getLocalDriver(String browser) {

        if (browser.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("Incorrect Browser");
        }
        driver.manage().window().maximize();
        return driver;
    }
}
