package Web.Pages.Positions;

import Web.Pages.Webpage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdvancedModePositionPage extends Webpage {

    @FindBy(css = "hl-spw-job-title div> input")
    protected WebElement jobTitleElement;

    @FindBy(css = "hl-spw-job-title > ng-select > ng-dropdown-panel > div > div > div[role='option']")
    protected WebElement addItemElement;

    @FindBy(xpath = "//*[contains(text() , '+View function suggestions')]")
    protected WebElement viewFunctionSuggestionsButtonElement;

    @FindBy(css = "")
    protected WebElement functionElements;

    public AdvancedModePositionPage(WebDriver driver) {
        super(driver);
    }

    public void advancedModeRolePage() {
        waitClickElement(jobTitleElement);
        jobTitleElement.sendKeys("HR Position");
        waitClickElement(addItemElement);
        waitClickElement(viewFunctionSuggestionsButtonElement);

    }
}
