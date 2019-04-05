package com.automationpractice.framework;

import com.automationpractice.framework.utilities.PropertiesManager;

/**
 * @author Sajeer Savad
 * Global_VARS class
 * Global variables are stores here
 *
 */

public class Global_VARS {

    // driver defaults
    public static final String DRIVER_PATH = System.getProperty("user.dir")+ "/src/test/resources/drivers/";
    public static final String FIREFOX_DRIVER_NAME = "webdriver.gecko.driver" ;
    public static final String FIREFOX_DRIVER_EXE = "geckodriver.exe";
    public static final String CHROME_DRIVER_NAME = "webdriver.chrome.driver" ;
    public static final String CHROME_DRIVER_EXE = "chromedriver.exe";

    // browser defaults
    public static final String BROWSER = PropertiesManager.getInstance().getBrowser();
    public static final int IMPLICIT_TIMEOUT = 10;


    // suite folder defaults
    public static final String TARGET_URL = PropertiesManager.getInstance().getSiteURL();
    public static final String TEST_OUTPUT_PATH = PropertiesManager.getInstance().getTestOutputPath();
    public static final String SNAPSHOT_PATH = TEST_OUTPUT_PATH + "/Screenshots/";
    public static final String REPORT_PATH = TEST_OUTPUT_PATH + "/Reports/ExtentReport.html";
    public static final String REPORT_CONFIG_FILE = System.getProperty("user.dir")+ "/src/main/resources/extent-config.xml";

    // suite timeout defaults
    public static final int TIMEOUT_INTERVAL = Integer.parseInt(PropertiesManager.getInstance().getWaitTimeout());
    public static final int POLLING_INTERVAL = Integer.parseInt(PropertiesManager.getInstance().getPollingInterval());

    // Data defaults
    public static final String DATA_FILE = System.getProperty("user.dir")+ "/src/test/resources/TestData/TestData.json";
    public static final String EXISTING_USER_NAME = PropertiesManager.getInstance().getUserName();
    public static final String EXISTING_PASSWORD = PropertiesManager.getInstance().getPassword();

}
