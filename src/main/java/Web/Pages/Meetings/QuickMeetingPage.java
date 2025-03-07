package Web.Pages.Meetings;

import Web.Pages.Webpage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuickMeetingPage extends Webpage {

    @FindBy(css = "hl-i-create-interview-modal button:nth-child(2)")
    protected WebElement quickInterviewElement;

    @FindBy(css = "hl-s-iwd-interview-position-select div[class='ng-value-container']")
    protected WebElement choosePositionElement;

    @FindBy(css = "div[role='listbox'] > div > div:nth-child(1)")
    protected WebElement positionOptionElement;

    @FindBy(css = "hl-s-iwd-interview-candidate-select div[role='combobox'] > input")
    protected WebElement candidateNameInputElement;

    @FindBy(css = "hl-s-iwd-interview-candidate-select div > span > span[class='ng-arrow']")
    protected WebElement addCandidateElement;

    @FindBy(css = "[type='submit']")
    protected WebElement launchMeetingButtonElement;

    @FindBy(xpath = "//*[contains(text() , 'Add New Candidate')]")
    protected WebElement addCandidateOptionElement;


    public QuickMeetingPage(WebDriver driver) {
        super(driver);
    }

    public InterviewProgressPage quickInterview() {
//        waitClickElement(quickInterviewElement);

        moveAndClickAction(choosePositionElement);
        waitClickElement(positionOptionElement);

        moveAndClickAction(addCandidateElement);
        candidateNameInputElement.sendKeys("Ka George");
        waitClickElement(positionOptionElement);


        waitClickElement(launchMeetingButtonElement);
        return PageFactory.initElements(driver, InterviewProgressPage.class);

    }


}
