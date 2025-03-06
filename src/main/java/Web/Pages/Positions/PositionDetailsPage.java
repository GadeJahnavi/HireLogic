package Web.Pages.Positions;

import Web.Pages.Webpage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PositionDetailsPage extends Webpage {

    @FindBy(css = "div > input[formcontrolname='company']")
    protected WebElement companyInputElement;

    @FindBy(css = "div > hl-form-field input")
    protected List<WebElement> inputElements;

    @FindBy(xpath = "//*[contains(text() , 'Next')]")
    protected WebElement nextButtonElement;

    @FindBy(css = "hl-epw-review > div > button:nth-child(3)")
    protected WebElement createPositionButtonElement;

    @FindBy(css = "hl-pd-position-detail > div > [key='collapse']")
    protected WebElement backButton;

    public PositionDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void fillPositionDetails() {
        waitForVisibilityOfElement(companyInputElement);
        companyInputElement.sendKeys("Infosys");

        WebElement industryInputElement = inputElements.get(2);
        industryInputElement.sendKeys("Engineering Software");

        WebElement levelInputElement = inputElements.get(3);
        levelInputElement.sendKeys("Associate");

        WebElement jobTypeInputElement = inputElements.get(4);
        jobTypeInputElement.sendKeys("Full time");

        WebElement remoteCheckBoxElement = inputElements.get(5);
        waitClickElement(remoteCheckBoxElement);

        WebElement educationInputElement = inputElements.get(7);
        educationInputElement.sendKeys("Computer Engineering");

        WebElement experienceInputElement = inputElements.get(8);
        experienceInputElement.sendKeys("5years");

//        WebElement baseCompensationInputElement = inputElements.get(9);
//        baseCompensationInputElement.sendKeys("5000");

        waitClickElement(nextButtonElement);

        waitClickElement(nextButtonElement);
        waitClickElement(createPositionButtonElement);
        waitForVisibilityOfElement(backButton);
        waitClickElement(backButton);
    }
}
