package com.automationpractice.pageobjects.productmanagement.cartdetails;

import com.automationpractice.framework.driver.CreateDriver;
import com.automationpractice.framework.utilities.BrowserUtils;
import com.automationpractice.framework.utilities.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Sajeer Savad
 * Shopping cart summry
 *
 */

public class ShoppingCartSummary {

    public ShoppingCartSummary(){
        PageFactory.initElements(CreateDriver.getInstance().getDriver(),this);

    }


    @FindBy(how= How.XPATH, using="//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']") private WebElement proceedToCheckout;

    public void waitForRefresh(){
        Log.debug("Waiting for the page to refresh. ");
        BrowserUtils.waitForElement(this.proceedToCheckout);
    }

    public void proceedToCheckOut(){
        Log.info("Clicking proceed to checkout option. ");
        this.proceedToCheckout.click();
    }

}
