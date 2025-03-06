package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Testing {
    protected static WebDriver driver = null;

    public static WebDriver openBrowser(String browserName) {

        if (browserName.toLowerCase().equals("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--start-maximized");
            driver = new ChromeDriver(chromeOptions);
        } else if (browserName.toLowerCase().equals("safari")) {
            driver = new SafariDriver();
//            Dimension screenSize = new Dimension(2560, 1600);
//            driver.manage().window().setSize(screenSize);
        } else {
            System.out.println("Browser Unavailable " + browserName);
        }
        return driver;
    }

    public WebElement getElement(String type, String selector) {
        if (type.toLowerCase() == "css") {
            return driver.findElement(By.cssSelector(selector));
        } else if (type.toLowerCase() == "xpath") {
            }
        return driver.findElement(By.xpath(selector));
    }

    public List<WebElement> getElements(String type, String selector) {
        if (type.toLowerCase() == "css") {
            return driver.findElements(By.cssSelector(selector));
        } else if (type.toLowerCase() == "xpath") {
        }
        return driver.findElements(By.xpath(selector));
    }

    public static void waitForVisibility(int seconds,  String type,  String selector) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            if (type.toLowerCase() == "css") {
                WebElement elementAfterWait = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector)));
                if (elementAfterWait.isDisplayed()) {
                    elementAfterWait.click();
                }
            } else if (type.toLowerCase() == "xpath") {
                WebElement elementAfterWait = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selector)));
                if (elementAfterWait.isDisplayed()) {
                    elementAfterWait.click();
                }
            }
        } catch (TimeoutException ex) {
            System.out.println("Exception found" + ex.getMessage());
        }
    }

    public static void waitClick(int seconds, String type, String selector) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            if (type.toLowerCase() == "css") {
                WebElement elementAfterWait = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
                if (elementAfterWait.isDisplayed()) {
                    elementAfterWait.click();
                }
            } else if (type.toLowerCase() == "xpath") {
                WebElement elementAfterWait = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(selector)));
                if (elementAfterWait.isDisplayed()) {
                    elementAfterWait.click();
                }
            }
        } catch (TimeoutException ex) {
            System.out.println(ex.getMessage());
//            JavascriptExecutor jse = (JavascriptExecutor) driver;
//            jse.executeScript(" arguments[0].document.querySelectorAll" + (selector) ) ;
        }
    }
    public void moveClickAction(String type, String selector) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element = wait.until(ExpectedConditions.visibilityOf(getElement(type,selector)));

        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    public static void pauseExecution(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            System.out.println("Runtime error" + e.getMessage());
        }
    }

    public void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void goToPage(String option) {
        switch (option.toLowerCase()) {
            case "home":
                String homePageSelector = "div > hl-nav-nav-item-icon-wrapper";
                waitClick(10, "css", homePageSelector);
                break;
            case "positions":
                String positionsPageSelector = "hl-nav-nav-item-icon-wrapper.ng-tns-c148398989-12";
                waitClick(10, "css", positionsPageSelector);
                break;
            case "meetings":
                String meetingsPageSelector = "hl-nav-nav-item-icon-wrapper.ng-tns-c148398989-13";
                waitClick(10, "css", meetingsPageSelector);
                break;
            case "analytics":
                String analyticsPageSelector = "hl-nav-nav-item-icon-wrapper.ng-tns-c148398989-14";
                waitClick(10, "css", analyticsPageSelector);
                break;
            case "analyze interviews":
                String analyzeInterviewsPageSelector = "hl-nav-nav-item-icon-wrapper.ng-tns-c148398989-15";
                waitClick(10, "css", analyzeInterviewsPageSelector);
                break;
            case "custom insights":
                String customInsightsPageSelector = "hl-nav-nav-item-icon-wrapper.ng-tns-c148398989-16";
                waitClick(10, "css", customInsightsPageSelector);
                break;
            case "logout":
                String avatharButtonSelector = "div[tpvariation='dropdown']";
                waitClick(10, "css", avatharButtonSelector );
                pauseExecution(2);

                String logoutOptionSelector = "div.tippy-content > div >div >div:nth-child(4)";
                waitClick(10, "css", logoutOptionSelector );
                driver.quit();

//            default:
//                System.out.println("Invalid option");
//                break;
        }
    }

}
