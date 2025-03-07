package web.Test;

import Web.Pages.AnalyticsPage;
import Web.Pages.TeamViewPage;
import org.example.Testing;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Constants;

public class AnalyticsTest extends BaseTest {

    protected AnalyticsPage analyticsPage;
    protected TeamViewPage teamViewPage;

    @BeforeMethod
    public void classSetUp() {
        analyticsPage = dashboardPage.goToAnalyticsPage();
    }

    @Test
    public void analyticsPageTitleTest() {
        String title = analyticsPage.getPageTitle();
        Assert.assertEquals(title, Constants.PAGE_TITLE);
    }

    @Test
    public void analyticsPageURLTest() {
        String url = analyticsPage.getPageURL();
        Assert.assertTrue(url.contains(Constants.ANALYTICS_PAGE_URL));
    }

    @Test
    public void filterAnalyticPageTest() {
        analyticsPage.filterData();
        Assert.assertEquals(analyticsPage.getFilterButtonText(), "Last 12 months");
    }

    @Test
    public void navigateToTeamViewPage() {
        teamViewPage = analyticsPage.navigateToTeamViewpage();
        softAssert.assertEquals(teamViewPage.getPageTitle(), Constants.PAGE_TITLE);
        softAssert.assertEquals(teamViewPage.getPageURL(), Constants.TEAM_VIEW_PAGE_URL);
        softAssert.assertEquals(teamViewPage.getPageHeader(), Constants.TEAM_VIEW_PAGE_TITLE);
        softAssert.assertAll();
    }

}
