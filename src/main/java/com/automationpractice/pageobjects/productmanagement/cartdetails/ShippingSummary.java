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
 *  Shipping summary in cart
 *
 */


public class ShippingSummary {

    public ShippingSummary(){
        PageFactory.initElements(CreateDriver.getInstance().getDriver(),this);
        ;
    }


    @FindBy(how = How.ID,id = "uniform-cgv") private WebElement acceptTerms;
    @FindBy(how = How.NAME,name = "processCarrier") private WebElement processCarrier;


    public void waitForRefresh(){
        Log.debug("Waiting for the page to refresh. ");
        BrowserUtils.waitForElement(this.acceptTerms);
    }

    public void acceptTerms(){
        Log.info("Accepting terms and conditions. ");
        this.acceptTerms.click();
    }

    public void processCarrier(){
        Log.info("Clicking process carrier. ");
        this.processCarrier.click();
    }

}
