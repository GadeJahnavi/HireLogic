package web.Test;

import Web.Pages.Positions.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PositionsTest extends BaseTest {
    protected PositionsPage positionsPage;
    protected CreateNewPositionPage createNewPositionPage;
    protected EasyModeNewPositionPage easyModeNewPositionPage;
    protected EasyModeQuestionsAndReviewPage easyModeQuestionsAndReviewPage;
    protected TemplateModePositionPage templateModePositionPage;
    protected PositionDetailsPage positionDetailsPage;


    @BeforeMethod
    public void gotoPositionsPage() {
        positionsPage = dashboardPage.goToPositionsPage();
    }

    @Test(priority = 0, dataProvider = "providePositionsName")
    public void addNewEasyModePositionTest(String position) {
        int activePositionsBefore = positionsPage.getActivePositionsCount();
        createNewPositionPage = positionsPage.addNewEasyModePosition(position);
        easyModeNewPositionPage = createNewPositionPage.goToEasyModePage();
        easyModeQuestionsAndReviewPage = easyModeNewPositionPage.easyModePosition(position);
        easyModeQuestionsAndReviewPage.createInterviewQuestions();
        positionsPage = dashboardPage.goToPositionsPage();
        int activePositionsAfter = positionsPage.getActivePositionsCount();

        Assert.assertEquals(activePositionsAfter, activePositionsBefore + 1);
    }

    @Test
    public void addTemplateModePositionTest() {
        int activePositionsBefore = positionsPage.getActivePositionsCount();
        createNewPositionPage = positionsPage.addTemplateModePosition();
        templateModePositionPage = createNewPositionPage.goToTemplateModePage();
        positionDetailsPage = templateModePositionPage.templateModePosition();
        positionDetailsPage.fillPositionDetails();
        positionsPage = dashboardPage.goToPositionsPage();
        int activePositionsAfter = positionsPage.getActivePositionsCount();

        Assert.assertEquals(activePositionsAfter, activePositionsBefore + 1);
    }

    @Test(priority = 2, dataProvider = "provideCandidateName")
    public void closePositionTest(String candidateName) {
        int closedPositionsBefore = positionsPage.getClosedPositionsCount();
        positionsPage.closePostion(candidateName);
        int closedPositionsAfter = positionsPage.getClosedPositionsCount();

        Assert.assertEquals(closedPositionsAfter, closedPositionsBefore + 1);
    }

    @DataProvider(name = "position")
    public Object[][] providePositionsName() {
        return new Object[][]{
                {"Sample Position"}, {"Trainee Position"}, {"Test Position"},
        };
    }

    @DataProvider
    public Object[][] provideCandidateName() {
        return new Object[][]{
                {"John"}, {"Grace"}, {"Meridith Grey"}, {"Stephen"}
        };
    }
}
