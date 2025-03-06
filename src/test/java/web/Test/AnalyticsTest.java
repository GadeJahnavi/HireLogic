package web.Test;

import org.example.Testing;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AnalyticsTest extends Testing {
    @BeforeClass
    public void setUp() {
        driver = openBrowser("chrome");
        driver.get("https://app.hirelogic.com");
        waitForVisibility(15, "css", "input#email");
        getElement("css", "input#email").sendKeys("madhoo@bhea.com");
        waitForVisibility(15, "css", "input#password");
        getElement("css", "input#password").sendKeys("MontrealBest@007");
        waitClick(10, "css", "button[type='submit']");
    }

    @AfterClass
    public void tearDown() {
       goToPage("logout");
    }

    @Test(priority = 0)
    public void chooseOption() {
        goToPage("analytics");
        waitClick(5, "css", "hl-perf-dash-time-interval-selector > button");
        String chooseOption = "hl-perf-dash-time-interval-selector > div button:nth-child(7)";
        waitClick(5, "css", chooseOption);
    }

    @Test(priority = 1)
    public void chooseCustomOption() {
        goToPage("analytics");
        waitClick(5, "css", "hl-perf-dash-time-interval-selector > button");

        String customButtonSelector = "hl-perf-dash-time-interval-selector > div  button:nth-child(8)";
        waitClick(5, "css", customButtonSelector);

        String chooseDateSelector = "ngx-date-picker  div[class='main-calendar-days'] >span:nth-child(13)";
        waitClick(5, "css", chooseDateSelector);
        waitClick(5, "css", chooseDateSelector);
    }

}
