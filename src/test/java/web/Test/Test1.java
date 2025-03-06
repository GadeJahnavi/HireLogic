package web.Test;

import Web.Pages.CustomInsights.CustomInsightsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Constants;

public class Test1 extends BaseTest{
    protected CustomInsightsPage customInsightsPage;

    @BeforeClass
    public void classSetUp() {
        customInsightsPage = dashboardPage.goToCustomInsightsPage();
    }

    @Test
    public void TitleTest() {
        String customPageTitle = customInsightsPage.getPageTitle();
        Assert.assertEquals(customPageTitle, Constants.PAGE_TITLE);
    }

    @Test
    public void PageURLTest() {
        String pageURL = customInsightsPage.getPageURL();
        Assert.assertEquals(pageURL, Constants.CUSTOM_PAGE_URL);
    }

    @Test
    public void navigateToCreateNewTemplate() {
        customInsightsPage.selectCreateNewTemplateButton();
        Assert.assertTrue(customInsightsPage.isTemplateButtonVisible());
    }
}
