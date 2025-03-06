package Web.Pages.CustomInsights;

import Web.Pages.Webpage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CustomInsightsPage extends Webpage {

    @FindBy(css = "hl-nav-horizontal-tabs div > button")
    protected WebElement createNewTemplateButtonElement;

    @FindBy(css = "hl-ci-create-template-modal > button:nth-child(2)")
    protected WebElement createFromScratchButtonElement;

    @FindBy(css = "hl-form-field  input[formcontrolname='name']")
    protected WebElement templateNameElement;

    @FindBy(css = "hl-kit-accordion2 ng-select > div > span")
    protected List<WebElement> categoryDropdowns;

    @FindBy(css = "div[role='listbox'] > div:nth-child(2) >div:nth-child(1)")
    protected WebElement chooseOption1;

    @FindBy(css = "div > button[type = 'Submit']")
    protected WebElement saveButtonElement;

    @FindBy(xpath = "//button[contains(text() , 'Save Template')]")
    protected WebElement confirmSaveElement;

    @FindBy(css = "hl-ci-create-template-modal > button:nth-child(3)")
    protected WebElement createFromTemplateButtonElement;

    @FindBy(css = "hl-sit-template-list  div:nth-child(1) > button:nth-child(2)")
    protected List<WebElement> previewButtonElements;

    @FindBy(xpath = "//*[contains(text() , 'Use This Template')]")
    protected WebElement useThisTemplateButtonElement;

    @FindBy(xpath = "//*[contains(text(), 'My Custom Templates')]")
    protected WebElement myCustomTemplateElement;

    @FindBy(css = "datatable-body-row button")
    protected List<WebElement> deleteIcon;

    @FindBy(css = "hirelogic-app-confirm-dialog  button")
    protected List<WebElement> confirmDeleteIcon;

    @FindBy(css = "datatable-selection > datatable-scroller > datatable-row-wrapper")
    protected List<WebElement> listOfCustomTemplates;

    @FindBy(xpath = "//*[contains(text(), 'Add New Category')]")
    protected WebElement addNewCategory;

    @FindBy(css = "svg-icon[key='questionmark-filled']")
    protected WebElement helpButtonElement;

    @FindBy(css = "datatable-header > div datatable-header-cell:nth-child(2) > div > div")
    protected WebElement createdByElement;

    @FindBy(css = ".relative.rounded.flex.h-full> ng-select")
    protected WebElement interviewDropboxElement;

    @FindBy(css = "[class=\"flex flex-row gap-4 justify-center ng-star-inserted\"] > button:first-child")
    protected WebElement cancelButtonElement;

    @FindBy(css = "hl-sit-template-list-item:nth-child(1) button:nth-child(2)")
    protected WebElement HireLogicDefaultInsightElement;

    @FindBy(css = "div[class *= \"flex-none f\"]> button:last-child")
    protected WebElement useThisTemplateElement;

    @FindBy(css = "[class*=\"absolute r\"]")
    protected WebElement closeButton;
    public CustomInsightsPage(WebDriver driver) {
        super(driver);
    }

    public void createNewTemplateFromScratch() {
        waitClickElement(createNewTemplateButtonElement);
        waitClickElement(createFromScratchButtonElement);

        waitClickElement(templateNameElement);
        String timeNow = new SimpleDateFormat("ddMMss").format(new Date());
        templateNameElement.sendKeys("Sample template" + timeNow);

        WebElement addCategoryDropdown = (categoryDropdowns).get(0);
        moveAndClickAction(addCategoryDropdown);
        moveAndClickAction(chooseOption1);

        moveToElement(helpButtonElement);

        moveAndClickAction(saveButtonElement);
        waitClickElement(confirmSaveElement);
    }

    public void createNewTemplateFromTemplate() {
        waitClickElement(createNewTemplateButtonElement);
        waitClickElement(createFromTemplateButtonElement);

        WebElement previewButton = previewButtonElements.get(1);
        waitClickElement(previewButton);

        waitClickElement(useThisTemplateButtonElement);

        waitClickElement(saveButtonElement);
        waitClickElement(confirmSaveElement);
    }

    public void deleteCustomTemplate() {
        waitClickElement(myCustomTemplateElement);
        deleteIcon.get(5).click();
        confirmDeleteIcon.get(1).click();
    }

    public String getInnerHTML(String css) {
        WebElement element = driver.findElement(By.cssSelector(css));
        return element.getText();
    }

    public int getMyCustomTemplatesCount() {
        waitForVisibilityOfElement(myCustomTemplateElement);
        waitClickElement(myCustomTemplateElement);
        waitForVisibilityOfElement(createdByElement);
//        Wait<WebDriver> wait = new FluentWait<>(driver)
//                .withTimeout(Duration.ofSeconds(20))
//                .pollingEvery(Duration.ofMillis(250))
//                .ignoring(NoSuchElementException.class);
//        wait.until(new Function<WebDriver, Boolean>() {
//                       public Boolean apply(WebDriver driver) {
//                           return new String("Created By").contains(getInnerHTML("datatable-header > div datatable-header-cell:nth-child(2) > div > div"));
//                       }
//                   }
//        );

        int count = listOfCustomTemplates.size();
        return count;
    }

    public String getPageTitle() {
        waitForVisibilityOfElement(createNewTemplateButtonElement);
        return driver.getTitle();
    }

    public String getPageURL() {
        waitForVisibilityOfElement(createNewTemplateButtonElement);
        return driver.getCurrentUrl();
    }

    public void selectCreateNewTemplateButton() {
        waitClickElement(interviewDropboxElement);
        waitClickElement(createNewTemplateButtonElement);
        waitClickElement(createFromTemplateButtonElement);
        waitClickElement(HireLogicDefaultInsightElement);

    }

    public Boolean isTemplateButtonVisible() {
       waitForVisibilityOfElement(useThisTemplateElement);
       boolean isVisible;
        isVisible = useThisTemplateButtonElement.isDisplayed();
        waitClickElement(closeButton);
       return isVisible;
    }
}
