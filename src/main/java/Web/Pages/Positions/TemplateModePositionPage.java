package Web.Pages.Positions;

import Web.Pages.Webpage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TemplateModePositionPage extends Webpage {

    @FindBy(css = "hl-sl-layout-v1-wrapper > div > div > button")
    protected WebElement createNewJobTemplateButtonElement;

    @FindBy(css = "hl-templates-template-item > div:nth-child(2)")
    protected List<WebElement> templateElements;

    @FindBy(css = "[class*=\"flex flex-row g\"] > button:first-child")
    protected WebElement useJobTemplateButtonElement;

    @FindBy(xpath = "//*[text() = \" Job Description \"]")
    protected WebElement jobDescriptionElement;


    public TemplateModePositionPage(WebDriver driver) {
        super(driver);
    }

    public PositionDetailsPage templateModePosition() {
        waitForVisibilityOfElement(createNewJobTemplateButtonElement);
        waitForVisibilityOfElement(jobDescriptionElement);
        WebElement accountExecutive = templateElements.get(0);
        waitClickElement(accountExecutive);

        waitClickElement(useJobTemplateButtonElement);

        return PageFactory.initElements(driver, PositionDetailsPage.class);
    }
}
