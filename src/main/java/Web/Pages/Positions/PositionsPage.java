package Web.Pages.Positions;

import Web.Pages.Webpage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PositionsPage extends Webpage {
    @FindBy(css = "div > hl-nav-tab[routerlink='active']")
    protected WebElement activePositionsElement;

    @FindBy(css = "div > hl-nav-tab[routerlink='closed'] > span.text-bold")
    protected WebElement closedPositionsElement;

    @FindBy(css = "hl-kit-appsection-subheader button")
    protected WebElement interviewGuideButtonElement;

    protected WebElement addCandidateOptionElement;

    @FindBy(css = "hl-nav-tab > span[class='text-bold']" )
    protected List<WebElement> listOfActivePositions;

    @FindBy(css = "hirelogic-positions-list-item > div button")
    protected List<WebElement> listOfPositionInterviews;

    @FindBy( css = "hl-i-create-interview-modal button:nth-child(2)")
    protected WebElement quickInterviewElement;

    @FindBy(css = "hl-s-iwd-interview-candidate-select div[role='combobox'] > input")
    protected WebElement candidateNameInputElement;

    @FindBy(css = "hl-s-iwd-interview-candidate-select div > span > span[class='ng-arrow']")
    protected WebElement addCandidateElement;

    @FindBy(css = "[type='submit']")
    protected  WebElement launchMeetingButtonElement;

    @FindBy(css = "[role='dialog'] button:nth-child(1)")
    protected WebElement doNotTranscribeButtonElement;

    @FindBy(css = "div.flex-grow > button")
    protected WebElement finishButtonElement;

    @FindBy(css = "div[role='dialog'] button:nth-child(1)")
    protected WebElement skipButtonElement;

    @FindBy(css = "div button:nth-child(1)")
    protected WebElement seeInterviewSummaryButtonElement;

    @FindBy(css = "hl-a-more-options-dropdown > button")
    protected WebElement moreOptionsButtonElement;

    @FindBy(xpath = "//*[contains(text() , 'Close Position')]")
    protected WebElement closePositionOptionElement;

    @FindBy(css = "hl-a-close-position-modal div>input")
    protected WebElement selectHiredCandidateElement;

    @FindBy(css = "div[class='scrollable-content'] > div:nth-child(1)")
    protected WebElement chooseCandidateElement;

    @FindBy(xpath = "//button[contains(text() , 'Close Position')]")
    protected WebElement confirmClosePosition;

    @FindBy(css = "hirelogic-positions-list > div:nth-child(3)")
    protected WebElement activePositionsListHeader;

    @FindBy(css = "hl-kit-logo-brand")
    protected WebElement completeInterviewPageElement;

    public PositionsPage(WebDriver driver) {
        super(driver);
    }

    public CreateNewPositionPage addNewEasyModePosition(String position) {
        waitClickElement(interviewGuideButtonElement);
       return PageFactory.initElements(driver, CreateNewPositionPage.class);
    }

    public CreateNewPositionPage addTemplateModePosition() {
        waitClickElement(interviewGuideButtonElement);
        return PageFactory.initElements(driver, CreateNewPositionPage.class);
    }

    public CreateNewPositionPage addAdvancedModePosition() {
        waitClickElement(interviewGuideButtonElement);
        return PageFactory.initElements(driver, CreateNewPositionPage.class);
    }

    public void closePostion(String candidateName) {
        waitClickElement(activePositionsElement);

        waitForVisibilityOfElement(activePositionsListHeader);
        WebElement firstPositionName = listOfPositionInterviews.get(0);
        waitClickElement(firstPositionName);

        waitClickElement(quickInterviewElement);

        moveAndClickAction(addCandidateElement);
        candidateNameInputElement.sendKeys(candidateName);

        moveAndClickAction(addCandidateOptionElement);

        waitClickElement(launchMeetingButtonElement);
        waitClickElement(doNotTranscribeButtonElement);
        waitClickElement(finishButtonElement);
        waitClickElement(skipButtonElement);

        waitForVisibilityOfElement(completeInterviewPageElement);

        waitClickElement(seeInterviewSummaryButtonElement);
        waitClickElement(moreOptionsButtonElement);
        waitClickElement(closePositionOptionElement);

        moveAndClickAction(selectHiredCandidateElement);
        moveAndClickAction(chooseCandidateElement);
        waitClickElement(confirmClosePosition);
    }

    public int getActivePositionsCount() {
        waitForVisibilityOfElement(interviewGuideButtonElement);
        waitForVisibilityOfElement(interviewGuideButtonElement);

        waitClickElement(activePositionsElement);

        String count = listOfActivePositions.get(0).getText();
        return Integer.parseInt(count);
    }

    public int getClosedPositionsCount() {
        waitForVisibilityOfElement(interviewGuideButtonElement);
        waitForVisibilityOfElement(interviewGuideButtonElement);

        waitClickElement(closedPositionsElement);

        String count = closedPositionsElement.getText();
        return Integer.parseInt(count);
    }



}
