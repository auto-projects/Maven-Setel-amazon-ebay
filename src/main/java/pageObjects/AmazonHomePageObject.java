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

    public String getHeaderTextsOfResultPage() {
        waitForElementVisible(driver, AmazonHomePageUI.HEADER_TEXT_SEARCHING_RESULT_3);
        return getElementText(driver, AmazonHomePageUI.HEADER_TEXT_SEARCHING_RESULT_3, "value");
    }
    public boolean getAllNamesOfSortedProduct() {
        List<WebElement> nameElements = getListWebElement(driver, AmazonHomePageUI.GET_NAME_LIST);
        List<String> nameValues = new ArrayList<String>();
        for (WebElement name : nameElements) {
            nameValues.add(name.getText());
        }
        System.out.println("►►►Product Name: " + nameValues + "\n");

        List<WebElement> priceElements = getListWebElement(driver, AmazonHomePageUI.GET_PRICE_LIST);
        List<String> priceValues = new ArrayList<String>();
        for (WebElement price : priceElements) {
            nameValues.add(price.getText());
        }
        System.out.println("►►►Product Price: " + priceValues + "\n");

        List<WebElement> linkElements = getListWebElement(driver, AmazonHomePageUI.GET_NAME_LIST);
        List<String> linkValue = new ArrayList<String>();

        for (WebElement link : linkElements) {
            nameValues.add(link.getAttribute("href"));
        }
        System.out.println("►►►Product Link: " + linkElements + "\n");

        List<String> nameValuesClone = new ArrayList<String>();
        nameValuesClone.addAll(nameValues);
        System.out.println("►►►AMAZON PRODUCTS SORTED BY ASCENDING PRICE:►►►");
        for (String profileList : nameValuesClone) {
            System.out.println(profileList);
        }
        return nameValues.equals(nameValuesClone);
    }

}
