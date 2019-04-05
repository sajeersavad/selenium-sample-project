package com.automationpractice.pageobjects.productmanagement;

import com.automationpractice.framework.utilities.BrowserUtils;
import com.automationpractice.framework.utilities.Log;
import com.automationpractice.pageobjects.MainPage;
import org.openqa.selenium.WebElement;

/**
 * @author Sajeer Savad
 *  Category PO
 *
 */

public class Category extends MainPage {

    private WebElement selectedItem;
    public Category(){
        super();
    }


    public void waitForPageLoad(){
        Log.debug("Waiting for the page to refresh. ");
        BrowserUtils.waitForElement(this.selectedItem);
    }

    public void addItem(){
        waitForPageLoad();
        Log.info("Clicking selected item. ");
        selectedItem.click();
        selectedItem.click(); // clicking the item twice
    }

    public void selectItem(String itemName){
        String itemXpath = "//a[@title='%s']/ancestor::li";
        selectedItem = BrowserUtils.dynamicXpathWebElement(itemXpath , itemName);
    }


}
