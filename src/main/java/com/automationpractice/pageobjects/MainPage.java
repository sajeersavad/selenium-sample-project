package com.automationpractice.pageobjects;

import com.automationpractice.framework.driver.CreateDriver;
import com.automationpractice.framework.utilities.BrowserUtils;
import com.automationpractice.framework.utilities.Log;
import com.automationpractice.pageobjects.common.CategoryPanel;
import com.automationpractice.pageobjects.common.HeaderPanel;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Sajeer Savad
 * landing page PO
 * Common methods are stored here.
 * Other pages extends this class
 *
 */

public class MainPage {

    public MainPage(){
        PageFactory.initElements(CreateDriver.getInstance().getDriver(),this);
    }


    public HeaderPanel headerPanel() {
        return new HeaderPanel() ;
    }

    public CategoryPanel categoryPanel() {
        return new CategoryPanel() ;
    }

    public String getCurrentURL(){
        Log.info("Fetching current URL");
        return CreateDriver.getInstance().getDriver().getCurrentUrl();
    }

    public void waitForURL(){
        BrowserUtils.waitForURL(getCurrentURL());
    }


}
