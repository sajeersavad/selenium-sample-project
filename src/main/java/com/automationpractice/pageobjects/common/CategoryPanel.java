package com.automationpractice.pageobjects.common;

import com.automationpractice.framework.Global_VARS;
import com.automationpractice.framework.driver.CreateDriver;
import com.automationpractice.framework.utilities.BrowserUtils;
import com.automationpractice.framework.utilities.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Sajeer Savad
 * Category panel common to all tha pages
 *
 */

public class CategoryPanel {

    public CategoryPanel( ){
        PageFactory.initElements(CreateDriver.getInstance().getDriver(),this);
    }

    @FindBy(how= How.LINK_TEXT, linkText="Women")  private WebElement women;
    @FindBy(how= How.LINK_TEXT, linkText="Dresses")  private WebElement dresses;

    public void waitForCategoryLoad(){
        Log.debug("waiting for category to be visible. ");
        BrowserUtils.waitForElement(women);
    }

    public  void  selectWomenCategory(){
        Log.info("selecting category as women.  ");
        this.women.click();
    }

    public  void  selectDressesCategory(){
        Log.info("selecting category as dress.  ");
        waitForCategoryLoad();
        this.women.click();
    }


}
