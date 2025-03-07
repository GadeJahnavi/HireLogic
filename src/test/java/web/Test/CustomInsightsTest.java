package web.Test;

import Web.Pages.CustomInsights.CustomInsightsPage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Constants;

public class CustomInsightsTest extends BaseTest {
    protected CustomInsightsPage customInsightsPage;

    @BeforeMethod
    public void gotoCustomInsightsPage() {
        customInsightsPage = dashboardPage.goToCustomInsightsPage();
    }

//    @Test(priority = 0)
//    public void createNewTemplateFromTemplateTest() {
//        int countBefore = customInsightsPage.getMyCustomTemplatesCount();
//        customInsightsPage.createNewTemplateFromTemplate();
//        int countAfter = customInsightsPage.getMyCustomTemplatesCount();
//
//        Assert.assertEquals(countAfter, countBefore + 1);
//    }

//    @Test(priority = 1)
//    public void createNewTemplateFromScratchTest() {
//        int countBefore = customInsightsPage.getMyCustomTemplatesCount();
//        customInsightsPage.createNewTemplateFromScratch();
//        int countAfter = customInsightsPage.getMyCustomTemplatesCount();
//
//        Assert.assertEquals(countAfter, countBefore + 1);
//    }
//
//    @Test(priority = 2)
//    public void deleteCustomtemplateTest() {
//        int countBefore = customInsightsPage.getMyCustomTemplatesCount();
//        customInsightsPage.deleteCustomTemplate();
//        int countAfter = customInsightsPage.getMyCustomTemplatesCount();
//
//        Assert.assertEquals(countAfter, countBefore - 1);
//    }

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

    @Test(priority = 3)
    public void validatePageUrl() {
        customInsightsPage.getPageUrl();
        Assert.assertTrue(customInsightsPage.getPageUrl());
    }

    @Test(priority = 4)
    public void validateTitle() {
        customInsightsPage.getTitle();
        Assert.assertTrue(customInsightsPage.getTitle());
    }

    @Test(priority = 5)
    public void searchTemplate() {
        String searchKeyword = "Exit Interviews";
        String verifySearch = customInsightsPage.searchTemplate(searchKeyword);
        System.out.println(verifySearch);

        Assert.assertTrue(customInsightsPage.isSearchElementFound(searchKeyword, verifySearch));
    }

    @Test(priority = 6)
    public void duplicateCustomTemplate() {
        String duplicateTemplateCount = customInsightsPage.duplicateTemplate();

        Assert.assertTrue(customInsightsPage.getTemplateCount(duplicateTemplateCount));
    }

    @Test(priority = 7)
    public void deleteCustomTemplate() {
        String TemplateCountBefore = customInsightsPage.deleteDuplicate();
        System.out.println(TemplateCountBefore);

        Assert.assertTrue(customInsightsPage.getTemplateCount(TemplateCountBefore));

    }


}
