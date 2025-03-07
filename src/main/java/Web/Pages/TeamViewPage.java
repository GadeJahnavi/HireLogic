package Web.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TeamViewPage extends Webpage {

    @FindBy(css = "h2[class = \"font-bold text-xl\"]")
    protected WebElement pageHeaderElement;

    public TeamViewPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getPageHeader() {
        waitForVisibilityOfElement(pageHeaderElement);
        return pageHeaderElement.getText();
    }

    public String getPageURL() {
        waitForVisibilityOfElement(pageHeaderElement);
        return driver.getCurrentUrl();
    }

}
