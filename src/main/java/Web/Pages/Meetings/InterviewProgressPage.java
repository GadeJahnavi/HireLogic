package Web.Pages.Meetings;

import Web.Pages.Webpage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InterviewProgressPage extends Webpage {

    @FindBy(css = "[role='dialog'] button:nth-child(1)")
    protected WebElement doNotTranscribeButtonElement;

    @FindBy(css = "hl-s-eval-score-selector > label:nth-child(4)")
    protected WebElement idealScoreButtonElement;

    @FindBy(css = "hl-s-companion-item-notes textarea")
    protected WebElement skillProgressInputElement;

    @FindBy(css = "hl-s-companion-interview-screen > div:nth-child(2) >div > button")
    protected WebElement nextButtonElement;

    @FindBy(css = "div.flex-grow > button")
    protected WebElement finishButtonElement;

    @FindBy(css = "hl-s-companion-candidate-recommendation-modal label:nth-child(2)")
    protected WebElement recommendLevelOption;

    @FindBy(css = "div[role='dialog'] button:nth-child(2)")
    protected WebElement doneButtonElement;

    @FindBy(css = "hl-kit-logo-brand")
    protected WebElement completeInterviewPageElement;

    @FindBy(css = "div button:nth-child(1)")
    protected WebElement seeInterviewSummaryButtonElement;

    public InterviewProgressPage(WebDriver driver) {
        super(driver);
    }

    public void finishInterviewProgress() {
        waitClickElement(doNotTranscribeButtonElement);

        completeInterviewQuestion();
        completeInterviewQuestion();
        completeInterviewQuestion();

        waitClickElement(finishButtonElement);
        waitClickElement(recommendLevelOption);
        waitClickElement(doneButtonElement);
        waitForVisibilityOfElement(completeInterviewPageElement);
        waitClickElement(seeInterviewSummaryButtonElement);
    }

    public void completeInterviewQuestion() {
        waitClickElement(idealScoreButtonElement);
        waitClickElement(skillProgressInputElement);
        skillProgressInputElement.sendKeys("Good Work");
        waitClickElement(nextButtonElement);
    }
}
