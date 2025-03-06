package Web.Pages.Positions;

import Web.Pages.Webpage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EasyModeNewPositionPage extends Webpage {

    @FindBy(css = "div[class='ng-value-container']")
    protected WebElement jobTitleElement;

    @FindBy(css = "div > input[type='text']")
    protected  WebElement jobTitleElementInput;

    @FindBy(xpath = "//*[contains(text() , 'Add item')]")
    protected WebElement addItemOptionElement;

    @FindBy(xpath = "//*[contains(text() , 'Next')]")
    protected WebElement nextButtonElement;


    public EasyModeNewPositionPage(WebDriver driver) {
        super(driver);
    }

    public EasyModeQuestionsAndReviewPage easyModePosition(String position) {
        moveAndClickAction(jobTitleElement);
        jobTitleElementInput.sendKeys(position);
        moveAndClickAction(addItemOptionElement);
        waitClickElement(nextButtonElement);
        return PageFactory.initElements(driver, EasyModeQuestionsAndReviewPage.class);
    }

}
