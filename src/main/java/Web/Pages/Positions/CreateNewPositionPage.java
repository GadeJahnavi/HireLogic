package Web.Pages.Positions;

import Web.Pages.Webpage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewPositionPage extends Webpage {
    protected EasyModeNewPositionPage easyModeNewPositionPage;

    @FindBy(css = "hl-kit-appsection-subheader button")
    protected WebElement interviewGuideButtonElement;

    @FindBy(css = "hl-p-create-position-modal > div > div >div:nth-child(1)")
    protected WebElement easyModeElement;

    @FindBy(css = "hl-p-create-position-modal > div > div >div:nth-child(2)")
    protected WebElement templateModeElement;

    @FindBy(css = "hl-p-create-position-modal > div > div >div:nth-child(3)")
    protected WebElement advancedModeElement;

    public CreateNewPositionPage(WebDriver driver) {
        super(driver);
    }

    public EasyModeNewPositionPage goToEasyModePage() {
        waitClickElement(easyModeElement);
        return PageFactory.initElements(driver, EasyModeNewPositionPage.class);
    }

    public TemplateModePositionPage goToTemplateModePage() {
        waitClickElement(templateModeElement);
        return PageFactory.initElements(driver, TemplateModePositionPage.class);
    }

    public AdvancedModePositionPage goToAdvancedModePage() {
        waitClickElement(advancedModeElement);
        return PageFactory.initElements(driver, AdvancedModePositionPage.class);
    }
}
