package Web.Pages.Positions;

import Web.Pages.Webpage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EasyModeQuestionsAndReviewPage extends Webpage {

    @FindBy(css = "div >label:nth-child(2) >input")
    protected WebElement createOwnQuestionsButtonElement;

    @FindBy(xpath = "//*[contains(text() , 'Next')]")
    protected WebElement nextButtonElement;

    @FindBy(css = "hl-spw-question hl-form-field > div > textarea")
    protected List<WebElement> questionInputElements;

    @FindBy(css = "hl-spw-question div[class='_grading-criteria'] div>span.ng-arrow-wrapper")
    protected List<WebElement> gradingCriteriaDropdownElements;

    @FindBy(css = "ng-dropdown-panel > div[role='listbox'] > div > div:nth-child(2)")
    protected WebElement chooseOptionFromDropdownElement;

    @FindBy(css = "hl-spw-question div[class='_category'] div>span.ng-arrow-wrapper")
    protected List<WebElement> categoryDropdownElements;

    @FindBy(css = "hl-kit-sticky-container button")
    protected WebElement newQuestionButtonElement;

    @FindBy(css = "hl-epw-review > div > button:nth-child(3)")
    protected WebElement createPositionButtonElement;

    @FindBy(css = "hl-pd-position-detail > div > [key='collapse']")
    protected WebElement backButton;


    public EasyModeQuestionsAndReviewPage(WebDriver driver) {
        super(driver);
    }

    public void createInterviewQuestions() {
        waitClickElement(createOwnQuestionsButtonElement);
        waitClickElement(nextButtonElement);
        question1();
        question2();
        question3();
        waitClickElement(nextButtonElement);
        waitClickElement(createPositionButtonElement);
        waitForVisibilityOfElement(backButton);
        waitClickElement(backButton);
    }

    public void question1() {
        waitClickElement(questionInputElements.get(0));
        questionInputElements.get(0).sendKeys("Tell me something about yourself");
        waitClickElement(gradingCriteriaDropdownElements.get(0));
        waitClickElement(chooseOptionFromDropdownElement);
        waitClickElement(categoryDropdownElements.get(0));
        waitClickElement(chooseOptionFromDropdownElement);
        waitClickElement(newQuestionButtonElement);
    }

    public void question2() {
        waitClickElement(questionInputElements.get(1));
        questionInputElements.get(1).sendKeys("Can you please provide us with an overview of your experience and background that makes you qualified for this position");
        waitClickElement(gradingCriteriaDropdownElements.get(0));
        waitClickElement(chooseOptionFromDropdownElement);
        waitClickElement(categoryDropdownElements.get(0));
        waitClickElement(chooseOptionFromDropdownElement);
        waitClickElement(newQuestionButtonElement);
    }

    public void question3() {
        waitClickElement(questionInputElements.get(2));
        questionInputElements.get(2).sendKeys("Tell me somCan you discuss your approach towards goal-setting and strategic planning ");
        waitClickElement(gradingCriteriaDropdownElements.get(0));
        waitClickElement(chooseOptionFromDropdownElement);
        waitClickElement(categoryDropdownElements.get(0));
        waitClickElement(chooseOptionFromDropdownElement);
    }


}
