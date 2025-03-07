package Web.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends Webpage {

    @FindBy(css = "input#email")
    WebElement userNameElement;

    @FindBy(css = "input#password")
    WebElement passwordElement;

    @FindBy(css = "button[type='submit']")
    WebElement loginButtonElement;

    @FindBy(css = "div[tpvariation='dropdown']")
    protected WebElement avatarButton;


    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public DashboardPage login(String username , String password) {
        waitForVisibilityOfElement(userNameElement);
        userNameElement.sendKeys(username);
        passwordElement.sendKeys(password);
        waitClickElement(loginButtonElement);
        waitForVisibilityOfElement(avatarButton);
        return PageFactory.initElements(driver, DashboardPage.class);
    }
}


