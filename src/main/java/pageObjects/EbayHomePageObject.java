package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.EbayHomePageUI;

import java.util.ArrayList;
import java.util.List;

public class EbayHomePageObject extends BasePage {
    WebDriver driver;

    public EbayHomePageObject(WebDriver driver) {
        this.driver = driver;
    }
    public List<String> getHeaderTextsOfResultPage() {
        List<WebElement> textElements = getListWebElement(driver, EbayHomePageUI.HEADER_TEXT_SEARCHING_RESULT);
        List<String> textValues = new ArrayList<String>();
        for (WebElement product : textElements) {
            textValues.add(product.getText().trim());
            textValues.add("\n");
        }
        System.out.println("☀ EBAY RESULT PAGE: " + textValues);
        return textValues;
    }
    public List<String> getAllProductNamesPricesLinks() {
        List<WebElement> nameElements = getListWebElement(driver, EbayHomePageUI.GET_NAME_LIST);
        List<String> nameValues = new ArrayList<String>();
        for (WebElement product : nameElements) {
            nameValues.add(product.getText());
            nameValues.add("\n");
        }
        System.out.println("☀ Product Names: " + "\n" + nameValues);

        List<WebElement> priceElements = getListWebElement(driver, EbayHomePageUI.GET_PRICE_LIST);
        List<String> priceValues  = new ArrayList<String>();
        for (WebElement product : priceElements) {
            priceValues.add(product.getText());
            priceValues.add("\n");
        }
        System.out.println("☀ Product Prices: " + "\n" + priceValues);

        List<WebElement> linkElements = getListWebElement(driver, EbayHomePageUI.GET_LINK_LIST);
        List<String> linkValues = new ArrayList<String>();
        for (WebElement link : linkElements) {
            linkValues.add(link.getAttribute("href"));
            linkValues.add("\n");
        }
        System.out.println("☀ Product's Link is: " + "\n" + linkValues);

        List<String> productNamePriceLinkClone = new ArrayList<String>();
        productNamePriceLinkClone.add(String.valueOf(nameValues));
        productNamePriceLinkClone.add(String.valueOf(priceValues));
        productNamePriceLinkClone.add(String.valueOf(linkValues));
        return productNamePriceLinkClone;
    }

    public void selectOptionFromSortDropdown() {
        waitForElementClickable(driver, EbayHomePageUI.BEST_MATCH_BUTTON);
        clickOnElement(driver, EbayHomePageUI.BEST_MATCH_BUTTON);
        waitForElementClickable(driver, EbayHomePageUI.LOW_TO_HIGH_PRICE);
        clickOnElement(driver, EbayHomePageUI.LOW_TO_HIGH_PRICE);
    }

}

