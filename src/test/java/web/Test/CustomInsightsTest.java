package web.Test;

import Web.Pages.CustomInsights.CustomInsightsPage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CustomInsightsTest extends BaseTest {
    protected CustomInsightsPage customInsightsPage;

    @BeforeMethod
    public void gotoCustomInsightsPage() {
        customInsightsPage = dashboardPage.goToCustomInsightsPage();
    }

    @Test(priority = 0)
    public void createNewTemplateFromTemplateTest() {
        int countBefore = customInsightsPage.getMyCustomTemplatesCount();
        customInsightsPage.createNewTemplateFromTemplate();
        int countAfter = customInsightsPage.getMyCustomTemplatesCount();

        Assert.assertEquals(countAfter, countBefore + 1);
    }

    @Test(priority = 1)
    public void createNewTemplateFromScratchTest() {
        int countBefore = customInsightsPage.getMyCustomTemplatesCount();
        customInsightsPage.createNewTemplateFromScratch();
        int countAfter = customInsightsPage.getMyCustomTemplatesCount();

        Assert.assertEquals(countAfter, countBefore + 1);
    }

    @Test(priority = 2)
    public void deleteCustomtemplateTest() {
        int countBefore = customInsightsPage.getMyCustomTemplatesCount();
        customInsightsPage.deleteCustomTemplate();
        int countAfter = customInsightsPage.getMyCustomTemplatesCount();

        Assert.assertEquals(countAfter, countBefore - 1);
    }

    @Test(priority = 3)
    public void searchTemplate() {
        String searchKeyword = "Exit Interviews";
        String elementVerify = customInsightsPage.searchTemplate(searchKeyword);

        Assert.assertTrue(customInsightsPage.checkSearchElement(searchKeyword, elementVerify), "Search Failed");
    }

    @Test(priority = 4)
    public void duplicateCustomTemplate() {
        String field = customInsightsPage.duplicateTemplate();
        System.out.println(field);
    }

    @Test(priority = 7)
    public void deleteCustomTemplate() {
        customInsightsPage.deleteDuplicate();
    }

    @Test(priority = 5)
    public void validateUrl() {
        customInsightsPage.getUrl();
        Assert.assertTrue(customInsightsPage.getUrl());
    }

    @Test(priority = 6)
    public void validateTitle() {
        customInsightsPage.getTitle();
        Assert.assertTrue(customInsightsPage.getTitle());
    }







}
