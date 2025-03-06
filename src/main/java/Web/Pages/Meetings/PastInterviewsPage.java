package Web.Pages.Meetings;

import Web.Pages.Webpage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PastInterviewsPage extends Webpage {

    @FindBy(css = "datatable-body datatable-row-wrapper:nth-child(1) input")
    protected WebElement selectItemCheckBoxElement;

    @FindBy(css = "hl-i-past-interviews > div > button")
    protected WebElement deleteButtonElement;

    @FindBy(css = "hl-i-delete-interview-modal > div  > div > button:nth-child(2)")
    protected WebElement confirmDeleteButtonElement;

    @FindBy(css = "datatable-header-cell input")
    protected WebElement nameOptionCheckBoxElement;

    public PastInterviewsPage(WebDriver driver) {
        super(driver);
    }

    public void deletePastInterview() {
        waitClickElement(selectItemCheckBoxElement);
        waitForVisibilityOfElement(deleteButtonElement);
        waitClickElement(deleteButtonElement);
        waitClickElement(confirmDeleteButtonElement);
    }

    public void deleteTopPastInterviews() {
        waitClickElement(nameOptionCheckBoxElement);
        waitForVisibilityOfElement(deleteButtonElement);
        waitClickElement(deleteButtonElement);
        waitClickElement(confirmDeleteButtonElement);
    }



}
