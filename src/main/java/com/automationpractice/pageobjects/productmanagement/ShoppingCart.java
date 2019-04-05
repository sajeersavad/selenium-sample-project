package com.automationpractice.pageobjects.productmanagement;

import com.automationpractice.framework.utilities.BrowserUtils;
import com.automationpractice.framework.utilities.Log;
import com.automationpractice.pageobjects.MainPage;
import com.automationpractice.pageobjects.productmanagement.cartdetails.AddressSummary;
import com.automationpractice.pageobjects.productmanagement.cartdetails.PaymentSummary;
import com.automationpractice.pageobjects.productmanagement.cartdetails.ShippingSummary;
import com.automationpractice.pageobjects.productmanagement.cartdetails.ShoppingCartSummary;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Sajeer Savad
 *  Shopping cart summary PO
 *
 */

public class ShoppingCart extends MainPage {

    public ShoppingCart(){
        super();
    }

    @FindBy(how= How.CSS, using="h1")  private WebElement heading;

    public void waitForPageLoad(){
        Log.debug("Waiting for the shopping cart page to refresh. ");
        BrowserUtils.waitForElement((this.heading));
    }

    public String getheading(){
        Log.info("Fetching the title. ");
        return  this.heading.getText();
    }

    public ShoppingCartSummary shoppingCartSummary() {
        return new ShoppingCartSummary();
    }

    public AddressSummary addressCart() {
        return new AddressSummary();
    }

    public ShippingSummary shippingDetailsCart(){
        return new ShippingSummary();
    }

    public PaymentSummary paymentSummary(){
        return new PaymentSummary();
    }


}
