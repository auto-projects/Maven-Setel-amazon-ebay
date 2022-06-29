package commons;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageUIs.BasePageUI;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {

    public static BasePage getBasePageObject() {
        return new BasePage();
    }

    // Alert
    protected Alert waitForAlertPresence(WebDriver driver) {
        WebDriverWait explicitWait = new WebDriverWait(driver, 30);
        return explicitWait.until(ExpectedConditions.alertIsPresent());
    }

    // Dynamic Locator
    private String getDynamicXpath(String xpathLocator, String... dynamicValues) {
        xpathLocator = String.format(xpathLocator, (Object[]) dynamicValues);
        return xpathLocator;
    }

    public WebElement getWebElement(WebDriver driver, String xpathLocator) {
        return driver.findElement(By.xpath(xpathLocator));
    }

    public List<WebElement> getListWebElement(WebDriver driver, String xpathLocator) {
        return driver.findElements(By.xpath(xpathLocator));
    }

    public List<WebElement> getListWebElement(WebDriver driver, String xpathLocator, String... dynamicValues) {
        return driver.findElements(By.xpath(getDynamicXpath(xpathLocator, dynamicValues)));
    }

    public void clickOnElement(WebDriver driver, String xpathLocator) {
        getWebElement(driver, xpathLocator).click();
    }

    public void clickOnElement(WebDriver driver, String xpathLocator, String... dynamicValues) {
        getWebElement(driver, getDynamicXpath(xpathLocator, dynamicValues)).click();
    }

    public void sendkeyIntoElement(WebDriver driver, String xpathLocator, String textValue) {
        WebElement element = getWebElement(driver, xpathLocator);
        element.clear();
        element.sendKeys(textValue);
    }

    public void sendkeyIntoElement(WebDriver driver, String xpathLocator, String textValue, String... dynamicValues) {
        WebElement element = getWebElement(driver, getDynamicXpath(xpathLocator, dynamicValues));
        element.clear();
        element.sendKeys(textValue);
    }

    protected void selectItemInDefaultDropdown(WebDriver driver, String xpathLocator, String itemText) {
        Select select = new Select(getWebElement(driver, xpathLocator));
        select.selectByVisibleText(itemText);
    }

    // selectItemInDefaultDropdown(driver,
    // BasePageNopCommerceUI.DYNAMIC_DROPDOWN_BY_NAME, itemText, dropdownName);
    protected void selectItemInDefaultDropdown(WebDriver driver, String xpathLocator, String itemText,
                                               String... dynamicValues) {
        Select select = new Select(getWebElement(driver, getDynamicXpath(xpathLocator, dynamicValues)));
        select.selectByVisibleText(itemText);
    }

    public void sleepInSecond(long time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }

    protected String getElementAttribute(WebDriver driver, String xpathLocator, String attributeName) {
        return getWebElement(driver, xpathLocator).getAttribute(attributeName);
    }

    protected String getElementAttribute(WebDriver driver, String xpathLocator, String attributeName,
                                         String... dynamicValues) {
        return getWebElement(driver, getDynamicXpath(xpathLocator, dynamicValues)).getAttribute(attributeName);
    }

    public String getElementText(WebDriver driver, String xpathLocator) {
        return getWebElement(driver, xpathLocator).getText().trim();
    }

    public String getElementText(WebDriver driver, String xpathLocator, String... dynamicValues) {
        return getWebElement(driver, getDynamicXpath(xpathLocator, dynamicValues)).getText().trim();
    }

    public void overrideGlobalTimeout(WebDriver driver, long timeout) {
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    // Wait
    public void waitForElementVisible(WebDriver driver, String xpathLocator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathLocator)));
    }

    public void waitForElementVisible(WebDriver driver, String xpathLocator, String... dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(getDynamicXpath(xpathLocator, dynamicValues))));
    }

    public void waitForElementClickable(WebDriver driver, String xpathLocator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathLocator)));
    }

    public void waitForElementClickable(WebDriver driver, String xpathLocator, String... dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait
                .until(ExpectedConditions.elementToBeClickable(By.xpath(getDynamicXpath(xpathLocator, dynamicValues))));
    }

    public long longTimeout = GlobalConstants.LONG_TIMEOUT;

    // AMAZON & EBAY
    public void inputIntoSearchTextboxByID(WebDriver driver, String textboxByID, String searchValue) {
        waitForElementVisible(driver, BasePageUI.TEXTBOX_BY_ID, textboxByID);
        sendkeyIntoElement(driver, BasePageUI.TEXTBOX_BY_ID, searchValue, textboxByID);
    }

    public void clickOnButtonByID(WebDriver driver, String buttonByID) {
        waitForElementClickable(driver, BasePageUI.BUTTON_BY_ID, buttonByID);
        clickOnElement(driver, BasePageUI.BUTTON_BY_ID, buttonByID);
    }

    public void selectOptionFromSortDropdownByID(WebDriver driver, String dropdownByText, String selectedOption) {
        waitForElementClickable(driver, BasePageUI.SORT_DROPDOWN_BY_TEXT, dropdownByText);
        selectItemInDefaultDropdown(driver, BasePageUI.SORT_DROPDOWN_BY_TEXT, selectedOption, dropdownByText);
    }



}

