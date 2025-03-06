package web.Test;

import Web.Pages.CustomInsights.CustomInsightsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Constants;

public class ExploratoryTest extends BaseTest{
    protected CustomInsightsPage customInsightsPage;

    @BeforeClass
    public void setupCustomInsightPage() {
        customInsightsPage = dashboardPage.goToCustomInsightsPage();
    }

    @Test
    public void TitleTest() {
        String customPageTitle = customInsightsPage.getPageTitle();
        Assert.assertEquals(customPageTitle, Constants.CUSTOM_PAGE_TITLE);
    }

    @Test
    public void PageURLTest() {
        String pageURL = customInsightsPage.getPageURL();
        Assert.assertEquals(pageURL, Constants.CUSTOM_PAGE_URL);
    }
}
