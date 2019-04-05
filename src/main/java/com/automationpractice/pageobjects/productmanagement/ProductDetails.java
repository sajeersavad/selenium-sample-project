package com.automationpractice.pageobjects.productmanagement;

import com.automationpractice.framework.utilities.BrowserUtils;
import com.automationpractice.framework.utilities.Log;
import com.automationpractice.pageobjects.MainPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Sajeer Savad
 * Product details  PO
 *
 */

public class ProductDetails extends MainPage {
    public ProductDetails(){
        super();
    }


    @FindBy(how= How.NAME, name="Submit") private WebElement submitButton;
    @FindBy(how= How.ID, id="quantity_wanted") private WebElement quantity;
    @FindBy(how= How.XPATH, xpath="//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']") private WebElement checkOutButton;

    public void setQuantity(String quantity){
        Log.info("Updating quantity. ");
        BrowserUtils.waitForElement(this.quantity);
        this.quantity.clear();
        this.quantity.sendKeys(quantity);
    }

    public void addToCart(){
        Log.info("Adding item to cart. ");
        BrowserUtils.waitForElement(this.submitButton);
        this.submitButton.click();
    }

    public void checkOut(){
        Log.info("Clicking checkout . ");
        BrowserUtils.waitForElement(this.checkOutButton);
        this.checkOutButton.click();
    }

}
