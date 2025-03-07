package web.Test;

import Web.Pages.Meetings.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class MeetingsTest extends BaseTest {
    protected MeetingsPage meetingsPage;
    protected QuickMeetingPage quickMeetingPage;
    protected ScheduleMeetingPage scheduleMeetingPage;
    protected InterviewProgressPage interviewProgressPage;
    protected PastInterviewsPage pastInterviewsPage;

    @BeforeMethod
    public void gotoMeetingsPage() {
        meetingsPage = dashboardPage.goToMeetingsPage();
    }

    @Test(priority = 0)
    public void startNewInterview() {
        quickMeetingPage = meetingsPage.clickOnNewInterviewButton();
        interviewProgressPage = quickMeetingPage.quickInterview();
        interviewProgressPage.finishInterviewProgress();
        dashboardPage.goToMeetingsPage();
    }

    @Test(priority = 3)
    public void scheduleInterview() {
        scheduleMeetingPage = meetingsPage.chooseScheduleMeetingButton();
        scheduleMeetingPage.newInterview();
    }

    @Test(priority = 1)
    public void deletePastInterview() {
        pastInterviewsPage = meetingsPage.goToPastInterviews();
        pastInterviewsPage.deletePastInterview();
    }

    @Test(priority = 2)
    public void deleteALLPastInterviews() {
        pastInterviewsPage = meetingsPage.goToPastInterviews();
        pastInterviewsPage.deleteTopPastInterviews();
    }

}
