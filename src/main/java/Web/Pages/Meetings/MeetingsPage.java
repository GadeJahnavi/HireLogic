package Web.Pages.Meetings;

import Web.Pages.Webpage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MeetingsPage extends Webpage {

    @FindBy(css = "button.hl-button-primary.ng-star-inserted")
    protected WebElement newInterviewButtonElement;

    @FindBy(xpath = "//*[contains(text() , 'Upcoming Interviews')]")
    protected WebElement upcomingInterviewsButtonElement;

    @FindBy(xpath = "//*[contains(text() , 'Past Interviews')]")
    protected WebElement pastInterviewsButtonElement;

    public MeetingsPage(WebDriver driver) {
        super(driver);
    }

    public QuickMeetingPage clickOnNewInterviewButton() {
        waitClickElement(newInterviewButtonElement);
        return PageFactory.initElements(driver, QuickMeetingPage.class);
    }

    public PastInterviewsPage goToPastInterviews() {
        waitClickElement(pastInterviewsButtonElement);
        return PageFactory.initElements(driver, PastInterviewsPage.class);
    }


}
