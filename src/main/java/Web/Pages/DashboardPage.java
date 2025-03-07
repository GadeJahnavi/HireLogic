package Web.Pages;

import Web.Pages.CustomInsights.CustomInsightsPage;
import Web.Pages.Meetings.MeetingsPage;
import Web.Pages.Positions.PositionsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends Webpage {

    @FindBy(css = "div > hl-nav-nav-item-icon-wrapper")
    protected WebElement homePage;

    @FindBy(css = "hl-nav-nav-item-icon-wrapper >svg-icon[key = 'position']")
    protected WebElement positionsPage;

    @FindBy(css = "hl-nav-nav-item-icon-wrapper >svg-icon[key = 'camera-on']")
    protected WebElement meetingsPage;

    @FindBy(css = "hl-nav-nav-item-icon-wrapper >svg-icon[key = 'kpi']")
    protected WebElement analyticsPage;

    @FindBy(css = "hl-nav-nav-item-icon-wrapper >svg-icon[key = 'loupe']")
    protected WebElement analyzeInterviewsPage;

    @FindBy(css = "hl-nav-nav-item-icon-wrapper >svg-icon[key = 'layout-blocks']")
    protected WebElement customInsightsPage;

    @FindBy(css = "div[tpvariation='dropdown']")
    protected WebElement avatarButton;

    @FindBy(css = "div.tippy-content > div >div >div:nth-child(4)")
    protected WebElement logoutOption;


    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public DashboardPage goToHomePage() {
        waitForVisibilityOfElement(homePage);
        waitClickElement(homePage);
        return PageFactory.initElements(driver, DashboardPage.class);
    }

    public PositionsPage goToPositionsPage() {
        waitForVisibilityOfElement(positionsPage);
        waitClickElement(positionsPage);
        return PageFactory.initElements(driver, PositionsPage.class);
    }

    public MeetingsPage goToMeetingsPage() {
        waitForVisibilityOfElement(meetingsPage);
        waitClickElement(meetingsPage);
        return PageFactory.initElements(driver, MeetingsPage.class);
    }

    public AnalyticsPage goToAnalyticsPage() {
        waitForVisibilityOfElement(analyticsPage);
        waitClickElement(analyticsPage);
        return new AnalyticsPage(driver);
    }

    public AnalyzeInterviewsPage goToAnalyzeInterviewsPage() {
        waitForVisibilityOfElement(analyticsPage);
        waitClickElement(analyzeInterviewsPage);
        return PageFactory.initElements(driver, AnalyzeInterviewsPage.class);
    }

    public CustomInsightsPage goToCustomInsightsPage() {
        waitForVisibilityOfElement(customInsightsPage);
        waitClickElement(customInsightsPage);
        return PageFactory.initElements(driver, CustomInsightsPage.class);
    }

    public void logout() {
        goToHomePage();
        waitForVisibilityOfElement(avatarButton);
        waitClickElement(avatarButton);
        waitClickElement(logoutOption);
        driver.quit();
    }
}

