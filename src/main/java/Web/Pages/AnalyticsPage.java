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

    @FindBy(css = "[tpplacement=\"bottom-start\"]")
    protected WebElement filterButton;

    @FindBy(css = ".tippy-content button:nth-child(4)")
    protected WebElement lastYearDropdownElement;

    @FindBy(css = "hl-perf-dash-time-interval-selector > button > div")
    protected WebElement filterButtonElement;

    @FindBy(css = "[value=\"team-view\"]")
    protected WebElement teamViewButton;

    @FindBy(css = "._table-header-wrapper.ng-star-inserted > div:nth-child(2)")
    protected WebElement teamMemberElement;


    public void filterData() {
        waitClickElement(filterButton);
        waitClickElement(lastYearDropdownElement);
    }

    public String getFilterButtonText() {
        waitForVisibilityOfElement(filterButtonElement);
        return filterButtonElement.getText();
    }

    public TeamViewPage navigateToTeamViewpage() {
        waitClickElement(teamViewButton);
        waitForVisibilityOfElement(teamMemberElement);
        return new TeamViewPage(driver);
    }

    public String getPageURL() {
        waitForVisibilityOfElement(teamViewButton);
        return driver.getCurrentUrl();
    }
}
