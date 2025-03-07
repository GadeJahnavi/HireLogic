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

    @FindBy(css = "hl-nav-tab[routerlink='hirelogic']")
    protected WebElement searchElementForHireLogicTemp;

    @FindBy(css = "hl-form-field > div > input[type='text']")
    protected WebElement searchBarElement;

    @FindBy(xpath = "//*[contains(text(), 'Exit Interviews')]")
    protected WebElement searchElement;

    @FindBy(css = "datatable-body-cell > div > div > div > button")
    protected WebElement verifySearchElement;

    @FindBy(xpath = "//*[contains(text(), 'Back')]")
    protected WebElement backButtonElement;

    @FindBy(css = "hl-nav-tab[routerlink='custom']")
    protected WebElement customTemplateTab;

    @FindBy(xpath = "//*[contains(text(), 'Default')]")
    protected WebElement defaultTextElement;

    @FindBy(css = "datatable-selection > datatable-scroller > datatable-row-wrapper:first-child > " +
            "datatable-body-row > div:nth-child(2) > datatable-body-cell:nth-child(5) > " +
            "div > div > button:nth-child(3)")
    protected WebElement duplicateButtonIconElement;

    @FindBy(css = "hirelogic-app-confirm-dialog div > button:nth-child(2)")
    protected WebElement duplicateConfirmButton;

    @FindBy(css = "div[class='relative rounded flex h-full'] > input")
    protected WebElement templateNameField;

    @FindBy(css = "form > div > button:nth-child(2)")
    protected WebElement confirmSaveButtonElement;

    @FindBy(css = "hirelogic-app-confirm-dialog div > button:nth-child(2)")
    protected WebElement saveTemplateButtonElement;

    @FindBy(css = "datatable-selection > datatable-scroller > datatable-row-wrapper:first-child > " +
            "datatable-body-row > div:nth-child(2) > datatable-body-cell:nth-child(5) > " +
            "div > div > div:nth-child(5) > button")
    protected WebElement deleteDuplicateButtonIconElement;

    @FindBy(css = "hirelogic-app-confirm-dialog div > button:nth-child(2)")
    protected WebElement deleteConfirmButtonIconElement;

    @FindBy(xpath = "//*[contains(text(), 'Showing')]")
    protected WebElement customTemplateCount;

    @FindBy(xpath = "//*[contains(text(), 'successfully deleted')]")
    protected WebElement categoriesElement;

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

    public String duplicateTemplate() {
        waitClickElement(customTemplateTab);
        waitForVisibilityOfElement(customTemplateCount);
        String templateCount = customTemplateCount.getText();

        waitClickElement(duplicateButtonIconElement);
        waitClickElement(duplicateConfirmButton);

        waitForVisibilityOfElement(confirmSaveButtonElement);
        confirmSaveButtonElement.click();

        waitClickElement(saveTemplateButtonElement);
        return templateCount;
    }

    public boolean getTemplateCount(String templateCount) {
        waitForVisibilityOfElement(customTemplateCount);
        waitForVisibilityOfElement(categoriesElement);
//        pauseExecution(2);
        String templateCountAfter = customTemplateCount.getText();
        System.out.println(templateCountAfter);
        if(!templateCountAfter.equalsIgnoreCase(templateCount)) {
            return true;
        }
        return false;
    }

    public String deleteDuplicate() {
        waitClickElement(customTemplateTab);
        waitForVisibilityOfElement(customTemplateCount);
        String templateCountBefore = customTemplateCount.getText();
        System.out.println(templateCountBefore);

        waitClickElement(customTemplateTab);
        waitClickElement(deleteDuplicateButtonIconElement);
        waitClickElement(deleteConfirmButtonIconElement);
        return templateCountBefore;
    }

    public boolean getPageUrl() {
        waitForVisibilityOfElement(defaultTextElement);
        String url = driver.getCurrentUrl();
        if(url.contains("custom-insights")) {
            return true;
        }
        return false;
    }

    public boolean getTitle() {
        String title = driver.getTitle();
        if(title.contains("HireLogic")) {
            return true;
        }
        return false;
    }

    public String searchTemplate(String searchWord) {
        waitClickElement(searchElementForHireLogicTemp);
        waitClickElement(searchBarElement);
        searchBarElement.sendKeys(searchWord);

        waitForVisibilityOfElement(searchElement);
        searchElement.click();

        waitClickElement(backButtonElement);
        String verifySearch = verifySearchElement.getText();
        return verifySearch;
    }

    public boolean isSearchElementFound(String verifySearch, String searchKeyword) {
        if (verifySearch.equalsIgnoreCase(searchKeyword)) {
            return true;
        }
        return false;
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

    public String getPageURL() {
        waitForVisibilityOfElement(interviewDropboxElement);
        return driver.getCurrentUrl();
    }
}
