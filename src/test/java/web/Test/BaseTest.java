package web.Test;

import Web.Pages.DashboardPage;
import Web.Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import utils.BrowserUtils;
import utils.GeneralUtils;

import java.util.Properties;


public class BaseTest extends GeneralUtils {

    protected DashboardPage dashboardPage;
    protected Properties properties;
    protected GeneralUtils generalUtils;

    @BeforeTest
    public void setUp() {
        properties = loadProperties();
        generalUtils = new GeneralUtils();
        driver = generalUtils.getLocalDriver(properties);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        dashboardPage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
    }

    @AfterTest
    public void tearDown() {
        dashboardPage.logout();
        driver.quit();
    }
}

