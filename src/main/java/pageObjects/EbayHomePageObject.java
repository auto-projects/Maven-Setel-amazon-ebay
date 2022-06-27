package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.EbayHomePageUI;

public class EbayHomePageObject extends BasePage {
    WebDriver driver;

    public EbayHomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getHeaderTextsOfResultPage() {
            waitForElementVisible(driver, EbayHomePageUI.HEADER_TEXT_SEARCHING_RESULT);
            return getElementText(driver, EbayHomePageUI.HEADER_TEXT_SEARCHING_RESULT, "value");
        }
    }

