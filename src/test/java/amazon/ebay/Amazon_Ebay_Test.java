package amazon.ebay;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.AmazonHomePageObject;
import pageObjects.EbayHomePageObject;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;


public class Amazon_Ebay_Test extends BaseTest {
    WebDriver driver;
    String searchData;
    AmazonHomePageObject amazonHomePage;
    EbayHomePageObject ebayHomePage;

    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {
        log.info("Pre-Condition - Step 01: Open browser '" + browserName + "' and navigate to '");

        driver = getBrowserDriver(browserName);

        searchData = "iPhone 11";
        showBrowserConsoleLogs(driver);
    }

    @Test
    public void Testcase_01_Open_Amazon_and_Search(Method method) {
        ExtentTestManager.startTest(method.getName(), "OPEN AMAZON AND SEARCH");

        ExtentTestManager.getTest().log(Status.INFO, "Amazon_01 - Step 01: Open 'Amazon' Homepage");
        driver.get(GlobalConstants.AMAZON_PAGE_URL);
        amazonHomePage = PageGeneratorManager.getAmazonHomePage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Amazon_01 - Step 02: Search into 'Search' textbox with value data");
        amazonHomePage.inputIntoSearchTextboxByID(driver, "twotabsearchtextbox", searchData);

        ExtentTestManager.getTest().log(Status.INFO, "Amazon_01 - Step 03: Click on 'Search' or 'Magnifier' button");
        amazonHomePage.clickOnButtonByID(driver, "nav-search-submit-button");

        ExtentTestManager.getTest().log(Status.INFO, "Amazon_01 - Step 04: Verify that 'RESULTS' page is displayed");
        System.out.println("AMAZON RESULTS: " + amazonHomePage.getHeaderTextsOfResultPage());

        ExtentTestManager.getTest().log(Status.INFO, "Amazon_01 - Step 05: Select option 'Price: Low to High' from 'Sort By' dropdown");
        amazonHomePage.selectOptionFromSortDropdownByID(driver, "s-result-sort-select", "Price: Low to High");
        amazonHomePage.sleepInSecond(3);

        ExtentTestManager.getTest().log(Status.INFO, "Amazon_01 - Step 06: Get and Print out all names of sorted items in the result page");
        amazonHomePage.getAllNamesOfSortedProduct();


    }

    //@Test
    public void Testcase_02_Open_Ebay_and_Search(Method method) {
        ExtentTestManager.startTest(method.getName(), "OPEN EBAY AND SEARCH");

        ExtentTestManager.getTest().log(Status.INFO, "Ebay_02 - Step 01: Open 'Ebay' Homepage");
        driver.get(GlobalConstants.EBAY_PAGE_URL);
        ebayHomePage = PageGeneratorManager.getEbayHomePage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Ebay_02 - Step 02: Search into 'Search' textbox with value data");
        ebayHomePage.inputIntoSearchTextboxByID(driver, "gh-ac", searchData);

        ExtentTestManager.getTest().log(Status.INFO, "Ebay_02 - Step 03: Click on 'Search' or 'Magnifier' button");
        amazonHomePage.clickOnButtonByID(driver, "gh-btn");

        ExtentTestManager.getTest().log(Status.INFO, "Ebay_02 - Step 04: Verify that 'RESULTS' page is displayed");
        verifyEquals(ebayHomePage.getHeaderTextsOfResultPage(), "1,400" + "+ results for " + searchData);
        System.out.println("EBAY RESULTS: " + ebayHomePage.getHeaderTextsOfResultPage());

        ExtentTestManager.getTest().log(Status.INFO, "Ebay_02 - Step 05: Select option 'Price: Low to High' from 'Best Match' dropdown");

        ExtentTestManager.getTest().log(Status.INFO, "Ebay_02 - Step 06: Get and Print out all names of sorted items in the result page");
    }

    //@Test
    public void Testcase_03_Combine_the_output_of_both_websites(Method method) {
        ExtentTestManager.startTest(method.getName(), "SEARCHING RESULTS COMBINATION");


    }

    @Parameters({"browser"})
    @AfterClass()
    public void cleanBrowser() {
        ExtentTestManager.getTest().log(Status.INFO, "►►►►►►►►►► Close Browsers and Drivers ►►►►►►►►►►");
        cleanDriverInstance();
    }
}
