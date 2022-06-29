package commons;

import java.io.File;

public class GlobalConstants {
    public static final String AMAZON_PAGE_URL = "https://www.amazon.com/";
    public static final String EBAY_PAGE_URL = "https://www.ebay.com/";

    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String JAVA_VERSION = System.getProperty("java.version");
    public static final String REPORTNG_SCREENSHOT = PROJECT_PATH + File.separator + "reportNGImages" + File.separator;

    public static final long SHORT_TIMEOUT = 5;
    public static final long LONG_TIMEOUT = 30;
    public static final long RETRY_TEST_FAIL = 3;

}
