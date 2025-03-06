package web.Test;

import Web.Pages.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {
//    @BeforeClass
//    public void setUp() {
//        optionType = System.getProperty("option", "local");
//        browserType = System.getProperty("browser", "chrome");
//        driver = getBrowser(optionType, browserType);
//        driver.get("https://app.hirelogic.com");
//    }

    @Test
    public void loginTest() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        dashboardPage = loginPage.login("madhoo@bhea.com", "MontrealBest@007");
        Assert.assertTrue(driver.getCurrentUrl().contains("https://app.hirelogic.com/bhea-tech-inc/workspace"), "Login failed");
    }
}
