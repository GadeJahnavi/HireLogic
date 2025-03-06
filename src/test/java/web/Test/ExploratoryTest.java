package web.Test;

import Web.Pages.AnalyticsPage;
import Web.Pages.CustomInsights.CustomInsightsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Constants;

public class ExploratoryTest extends BaseTest{
    protected CustomInsightsPage customInsightsPage;
    protected AnalyticsPage analyticsPage;

    @Test
    public void TitleTest() {
        customInsightsPage = dashboardPage.goToCustomInsightsPage();
        String customPageTitle = customInsightsPage.getPageTitle();
        Assert.assertEquals(customPageTitle, Constants.PAGE_TITLE);
    }

    @Test
    public void PageURLTest() {
        customInsightsPage = dashboardPage.goToCustomInsightsPage();
        String pageURL = customInsightsPage.getPageURL();
        Assert.assertEquals(pageURL, Constants.CUSTOM_PAGE_URL);
    }

    @Test
    public void navigateToCreateNewTemplate() {
        customInsightsPage = dashboardPage.goToCustomInsightsPage();
        customInsightsPage.selectCreateNewTemplateButton();
        Assert.assertTrue(customInsightsPage.isTemplateButtonVisible());
    }

    @Test
    public void analyticsPageTitleTest() {
        analyticsPage = dashboardPage.goToAnalyticsPage();
        String title = analyticsPage.getPageTitle();
        Assert.assertEquals(title, Constants.PAGE_TITLE);
    }

    @Test
    public void analyticsPageURLTest() {
        analyticsPage = dashboardPage.goToAnalyticsPage();
        String url = analyticsPage.getPageURL();
        Assert.assertEquals(url, Constants.ANALYTICS_PAGE_URL);
    }
}
