package Web.Pages.Meetings;

import Web.Pages.Webpage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ScheduleMeetingPage extends Webpage {

    @FindBy(css = "hl-s-iwd-interview-position-select span.ng-arrow-wrapper")
    protected WebElement addPositionDropdownElement;

    @FindBy(css = "hl-s-iwd-interview-position-select input")
    protected WebElement addPositionInputElement;

    @FindBy(css = "div[role='option'] > div")
    protected List<WebElement> positionsList;

    @FindBy(css = "hl-s-iwd-interview-candidate-select span.ng-arrow-wrapper")
    protected WebElement addCandidateDropdownElement;

    @FindBy(css = "hl-s-iwd-interview-candidate-select input")
    protected WebElement addCandidateInputElement;

    @FindBy(css = "div.ng-option:nth-child(1)")
    protected WebElement candidateOptionElement;

    @FindBy(css = "input[formcontrolname = 'subject']")
    protected WebElement subjectInputElement;

    @FindBy(css = "div.input-block > ng-select span.ng-arrow-wrapper")
    protected WebElement addTeamMembersDropdownElement;

    @FindBy(css = "div > input[type='checkbox']")
    protected WebElement activeUserElement;

    @FindBy(css = "ng-select[bindvalue='id'] > div > span.ng-arrow-wrapper")
    protected WebElement interviewModeDropdownElement;

    @FindBy(css = "div[role='listbox'] > div > div:nth-child(1)")
    protected WebElement launchOptionElement;

    @FindBy(xpath = "//*[contains(text(), 'Click here')]")
    protected WebElement addEmailButtonElement;

    @FindBy(css = "div > input[formcontrolname='email']")
    protected WebElement emailInputElement;

    @FindBy(css = "hl-s-iwd-candidate-email-modal button")
    protected WebElement saveButtonElement;

    @FindBy(css = "div[class='main-calendar-days'] > span:nth-child(16)")
    protected WebElement calendarDayElement;

    @FindBy(css = "hl-time-picker[formcontrolname='startTime'] span.ng-arrow-wrapper")
    protected WebElement startTimeElement;

    @FindBy(css = "hl-time-picker[formcontrolname='endTime'] span.ng-arrow-wrapper")
    protected WebElement endTimeElement;

    @FindBy(xpath = "//span[contains(text(), '10:00 AM')]")
    protected WebElement startTimeOptionElement;

    @FindBy(xpath = "//span[contains(text(), '12:00 PM')]")
    protected WebElement endTimeOptionElement;

    @FindBy(xpath = "//button[contains(text(), ' Schedule ')]")
    protected WebElement scheduleButtonElement;

    public ScheduleMeetingPage(WebDriver driver) {
        super(driver);
    }

    public void newInterview() {
        choosePosition();
        chooseCandidate();
        addCandidateEmail();
        addSubject();
        addTeamMembers();
        chooseInterviewMode();
        addStartTime();
        addEndTime();

//        waitClickElement(addPositionInputElement);
//        addPositionInputElement.sendKeys("HR position");

        waitClickElement(scheduleButtonElement);
    }

    public void choosePosition() {
        waitClickElement(addPositionDropdownElement);
        waitClickElement(positionsList.get(1));
    }

    public void chooseCandidate() {
//        waitClickElement(addCandidateDropdownElement);
        waitClickElement(addCandidateInputElement);
        addCandidateInputElement.sendKeys("Keth");
        waitClickElement(candidateOptionElement);

    }

    public void addCandidateEmail() {
        waitClickElement(addEmailButtonElement);
        waitClickElement(emailInputElement);
        emailInputElement.sendKeys("random@ymail.com");
        waitClickElement(saveButtonElement);
    }

    public void addSubject() {
        waitClickElement(subjectInputElement);
        subjectInputElement.sendKeys("Interview Invite");
    }

    public void addTeamMembers() {
        waitClickElement(addTeamMembersDropdownElement);
        waitClickElement(activeUserElement);
    }

    public void chooseInterviewMode() {
        waitClickElement(interviewModeDropdownElement);
        waitClickElement(launchOptionElement);
    }

    public void addStartTime() {
        waitClickElement(calendarDayElement);
        waitClickElement(startTimeElement);
        waitClickElement(startTimeOptionElement);
    }

    public void addEndTime() {
        waitClickElement(endTimeElement);
        waitClickElement(endTimeOptionElement);
    }

}
