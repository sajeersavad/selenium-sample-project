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
 *  Payment summary in cart
 *
 */

public class PaymentSummary {

    public PaymentSummary(){
        PageFactory.initElements(CreateDriver.getInstance().getDriver(),this);

    }

    @FindBy(how = How.CLASS_NAME,className = "bankwire") private WebElement bankwire;
    @FindBy(how = How.XPATH,xpath = "//*[@id='cart_navigation']/button") private WebElement orderConfirmButton;
    @FindBy(how = How.XPATH,xpath = "//*[@class='cheque-indent']/strong") private WebElement orderInfo;
    @FindBy(how = How.XPATH,xpath = "//li[@class='step_done step_done_last four']") private WebElement lastStep;
    @FindBy(how = How.XPATH,xpath = "//li[@id='step_end' and @class='step_current last']") private WebElement currentStep;


    public void waitForRefresh(){
        Log.debug("Waiting for the page to refresh. ");
        BrowserUtils.waitForElement(this.bankwire);
    }

    public void waitForOrderRefresh(){
        Log.debug("Waiting for the order tab to refresh. ");
        BrowserUtils.waitForElement(this.orderConfirmButton);

    }


    public void selectBankWire(){
        Log.info("Clocking bank wire. ");
        this.bankwire.click();
    }

    public void confirmOrder(){
        Log.info("Clicking confirm button. ");
        orderConfirmButton.click();
    }

    public String getOrderInfo(){
        Log.info("Fetching order info. ");
        return this.orderInfo.getText();
    }

    public boolean isLastStepDisplayed(){
        Log.info("Checking that last step is Displaying in the DOM. ");
        return this.lastStep.isDisplayed();
    }

    public boolean isCurrentStepDisplayed(){
        Log.info("Checking that current step is displayed in the DOM. ");
        return this.currentStep.isDisplayed();

    }


}
