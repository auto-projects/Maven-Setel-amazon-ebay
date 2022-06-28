package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.AmazonHomePageUI;

import java.util.ArrayList;
import java.util.List;

public class AmazonHomePageObject extends BasePage {
    WebDriver driver;

    public AmazonHomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean getAllProductNamesPricesLinks() {
        List<WebElement> nameElements = getListWebElement(driver, AmazonHomePageUI.UNSORTED_PRODUCT_NAMES);
        List<String> nameValues = new ArrayList<String>();
        for (WebElement product : nameElements) {
            nameValues.add(product.getText());
            nameValues.add("\n");
        }
        List<WebElement> priceElements = getListWebElement(driver, AmazonHomePageUI.GET_PRICE_LIST);
        List<String> priceValues = new ArrayList<String>();
        for (WebElement price : priceElements) {
            priceValues.add(price.getText());
            priceValues.add("\n");
        }
        List<WebElement> linkElements = getListWebElement(driver, AmazonHomePageUI.GET_LINK_LIST);
        List<String> linkValues = new ArrayList<String>();
        for (WebElement link : linkElements) {
            linkValues.add(link.getAttribute("href"));
            linkValues.add("\n");
        }

        System.out.println("☀ Product Names: "+"\n"+nameValues);
        System.out.println("☀ Product's Price is: "+"\n"+priceValues);
        System.out.println("☀ Product's Link is: "+"\n"+linkValues);

    List<String> productNamePriceLinkClone = new ArrayList<String>();
        productNamePriceLinkClone.add(String.valueOf(nameValues));
        productNamePriceLinkClone.add(String.valueOf(priceValues));
        productNamePriceLinkClone.add(String.valueOf(linkValues));

        return nameValues.equals(productNamePriceLinkClone);
}

    public String getHeaderTextsOfResultPage() {
        waitForElementVisible(driver, AmazonHomePageUI.HEADER_TEXT_SEARCHING_RESULT_3);
        return getElementText(driver, AmazonHomePageUI.HEADER_TEXT_SEARCHING_RESULT_3, "value");
    }

}
