package Web.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AnalyticsPage extends Webpage {

    public AnalyticsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "hl-perf-dash-time-interval-selector > div button:nth-child(4)")
    protected WebElement chooseOptionElement;

    @FindBy(css = "hl-perf-dash-time-interval-selector > div  button:nth-child(8)")
    protected WebElement customOptionElement;

    @FindBy(css = "ngx-date-picker  div[class='main-calendar-days'] >span:nth-child()")
    protected WebElement chooseDateFromCalendar;

    @FindBy(css = "[value=\"team-view\"]")
    protected WebElement teamViewButton;

    public void chooseOptions() {
        for (int i = 1; i <= 8; i++) {
            if (i < 8) {
                waitClickElement(chooseOptionElement);
            } else {
                waitClickElement(customOptionElement);
                for (int j = 4; j <= 20; j++) {
                    if (j < 20) {
                        waitClickElement(chooseDateFromCalendar);
                    }
                }
            }
        }

    }

    public TeamViewPage navigateToTeamViewpage() {
        waitClickElement(teamViewButton);
        return new TeamViewPage(driver);
    }

    public String getPageURL() {
        waitForVisibilityOfElement(teamViewButton);
        return driver.getCurrentUrl();
    }
}
