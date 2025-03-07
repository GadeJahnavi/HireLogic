package Web.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Webpage{
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;


    public Webpage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public void moveAndClickAction(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        actions.moveToElement(webElement).click().perform();
    }


    public static void pauseExecution(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            System.out.println("Runtime error" + e.getMessage());
        }
    }

    public void moveToElement(WebElement element) {
        actions.moveToElement(element).perform();
    }

    public void wait(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException ex) {
            moveToElement(element);
        }
    }

    public void waitForInvisibility(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOfAllElements(element));
    }

    public void waitClickElement(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (TimeoutException e) {
            moveAndClickAction(element);
        }
    }

    public void refreshPage() {
        driver.navigate().refresh();
        waitForInvisibility(getElement(By.cssSelector("hl-state-loading-overlay")));
    }

    public void waitForVisibilityOfElement(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            moveToElement(element);
        }
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void clickEnter() {
        actions.keyDown(Keys.ENTER).perform();
        actions.keyUp(Keys.ENTER).perform();
    }



}
