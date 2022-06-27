package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.AmazonHomePageObject;
import pageObjects.EbayHomePageObject;


public class PageGeneratorManager {

    public static AmazonHomePageObject getAmazonHomePage(WebDriver driver) {
        return new AmazonHomePageObject(driver);
    }

    public static EbayHomePageObject getEbayHomePage(WebDriver driver) {
        return new EbayHomePageObject(driver);
    }


}

