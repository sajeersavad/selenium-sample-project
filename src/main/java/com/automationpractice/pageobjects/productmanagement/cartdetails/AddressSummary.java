package com.automationpractice.pageobjects.productmanagement.cartdetails;

import com.automationpractice.framework.driver.CreateDriver;
import com.automationpractice.framework.utilities.BrowserUtils;
import com.automationpractice.framework.utilities.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Sajeer Savad
 *  Address summary in cart
 *
 */

public class AddressSummary {

    public AddressSummary(){
        PageFactory.initElements(CreateDriver.getInstance().getDriver(),this);
    }


    @FindBy(how = How.NAME,name = "processAddress") private WebElement processAddress;

    public void waitForRefresh(){
        Log.debug("Waiting for the page to refresh. ");
        BrowserUtils.waitForElement(this.processAddress);
    }

    public void processAddress(){
        Log.info("Processing address. ");
        this.processAddress.click();
    }


}
