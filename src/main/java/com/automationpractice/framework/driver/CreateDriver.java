package com.automationpractice.framework.driver;

import com.automationpractice.framework.Global_VARS;
import com.automationpractice.framework.utilities.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

/**
 * @author Sajeer Savad
 *
 * Driver Factory class
 *
 */

public class CreateDriver {

    private static CreateDriver instance = null;
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    //constructor
    private CreateDriver() {};


    /**
     * getInstance method to retrieve active driver instance
     *
     * @return CreateDriver
     */
    public static CreateDriver getInstance() {
        if ( instance == null ) {
            instance = new CreateDriver();
        }

        return instance;
    }


    /**
     * set driver based on user configuration
     *
     * @param browser
     */
    public final void  setDriver(String browser) {
        if(browser == null || browser.isEmpty()){
                browser = Global_VARS.BROWSER;
                Log.info("Setting default browser");
            }
        switch (browser){
            case "firefox" :
                Log.info("Initializing firefox browser. ");
                System.setProperty(Global_VARS.FIREFOX_DRIVER_NAME,  Global_VARS.DRIVER_PATH + Global_VARS.FIREFOX_DRIVER_EXE);
                driver.set(new FirefoxDriver());
                OptionsManager.getFirefoxOptions();
                break;
            case "chrome" :
                Log.info("Initializing chrome browser. ");
                System.setProperty(Global_VARS.CHROME_DRIVER_NAME,  Global_VARS.DRIVER_PATH + Global_VARS.CHROME_DRIVER_EXE);
                driver.set(new ChromeDriver());
                OptionsManager.getChromeOptions();
                break;

        }
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Global_VARS.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
    }


    /**
     * Returns webdriver instance
     *
     */
    public  WebDriver getDriver () {
        return driver.get();
    }

    /**
     * closeDriver method to close active driver
     *
     */
    public void closeDriver() {
        try {
            getDriver().quit();
        }

        catch ( Exception e ) {
            Log.error("Error while quitting driver. ");
        }
    }


}
