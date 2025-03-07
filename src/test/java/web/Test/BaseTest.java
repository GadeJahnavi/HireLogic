package web.Test;

import Web.Pages.DashboardPage;
import Web.Pages.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import utils.GeneralUtils;

import java.util.Properties;


public class BaseTest extends GeneralUtils {

    protected DashboardPage dashboardPage;
    protected Properties properties;
    protected SoftAssert softAssert;

    @Parameters("browser")
    @BeforeTest
    public void setUp(@Optional String browserName) {
        properties = loadProperties();
        softAssert = new SoftAssert();
        if (browserName != null) {
            properties.setProperty("browser", browserName);
        }
        driver = getLocalDriver(properties);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        dashboardPage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
    }

    @AfterTest
    public void tearDown() {
        dashboardPage.logout();
    }

    @AfterSuite
    public void quitBrowser() {
        driver.quit();
    }
}

