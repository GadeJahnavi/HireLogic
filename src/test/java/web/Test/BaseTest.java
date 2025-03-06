package web.Test;

import Web.Pages.DashboardPage;
import Web.Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import utils.BrowserUtils;
import utils.GeneralUtils;

import java.util.Properties;


public class BaseTest extends GeneralUtils {

    protected DashboardPage dashboardPage;
    protected Properties properties;
    protected GeneralUtils generalUtils;
    protected SoftAssert softAssert;

    @Parameters("browser")
    @BeforeTest
    public void setUp(@Optional String browserName) {
        properties = loadProperties();
        generalUtils = new GeneralUtils();
        softAssert = new SoftAssert();
        if (browserName != null) {
            properties.setProperty("browser", browserName);
        }
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

