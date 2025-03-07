package web.Test;

import Web.Pages.DashboardPage;
import Web.Pages.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.GeneralUtils;

import java.util.Properties;


public class BaseTest extends GeneralUtils {

    protected DashboardPage dashboardPage;
    protected Properties properties;

    @BeforeClass
    public void setUp() {
        properties = loadProperties();
        getLocalDriver(properties);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        dashboardPage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
    }

//    @BeforeClass
//    public void setUp() {
//        optionType = System.getProperty("platform","local");
//        userid = System.getProperty("userid");
//        accessKey = System.getProperty("key");
//        browserType = System.getProperty("browser","chrome");
//        driver = getBrowser(optionType, browserType);
//        driver.get("https://app.hirelogic.com");
//        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
//        dashboardPage = loginPage.login("madhoo@bhea.com", "MontrealBest@007");
//    }

    @AfterClass
    public void tearDown() {
        dashboardPage.logout();
        driver.quit();
    }

}

