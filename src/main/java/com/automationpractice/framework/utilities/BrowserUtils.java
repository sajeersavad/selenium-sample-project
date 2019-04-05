package com.automationpractice.framework.utilities;

import com.automationpractice.framework.Global_VARS;
import com.automationpractice.framework.driver.CreateDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Sajeer Savad
 *
 * Browser Utility Class
 *
 */
public class BrowserUtils {




    /**
     * waitForURL method to poll page URL
     *
     * @param url
     * @throws Exception
     */
    public static void waitForURL(String url) {

        WebDriver driver = CreateDriver.getInstance().getDriver();
        WebDriverWait exists = new WebDriverWait(driver, Global_VARS.TIMEOUT_INTERVAL, Global_VARS.POLLING_INTERVAL);

        exists.until( ExpectedConditions.refreshed(ExpectedConditions.urlContains(url)) );
    }


    /**
     * waitFor web element
     *
     * @param webElement
     * @throws Exception
     */

    public static void waitForElement(WebElement webElement)
             {

        WebDriver driver = CreateDriver.getInstance().getDriver();
        WebDriverWait exists = new WebDriverWait(driver, Global_VARS.TIMEOUT_INTERVAL, Global_VARS.POLLING_INTERVAL);

        exists.until( ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(webElement)) );
    }

    /**
     * xpath look up
     *
     * @param xpathValue
     * @param itemName
     * @throws Exception
     */
    public static WebElement dynamicXpathWebElement (String xpathValue , String itemName ) {
        WebDriver driver = CreateDriver.getInstance().getDriver();
        return driver.findElement(By.xpath(String.format(xpathValue, itemName)));
    }



    /**
     * select method for selecting text from dropdown
     *
     * @param webElement
     * @param value
     */
    public static void selectVisibleText(WebElement webElement, String value) {

        Select select = new Select(webElement);
        select.selectByVisibleText(value);
    }

    /**
     * select method for selecting value from dropdown
     *
     * @param webElement
     * @param value
     */
    public static void selectValue(WebElement webElement, String value) {

        Select select = new Select(webElement);
        select.selectByValue(value);
    }

}
