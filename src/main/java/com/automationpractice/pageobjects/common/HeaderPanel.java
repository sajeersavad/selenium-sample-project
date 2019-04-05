package com.automationpractice.pageobjects.common;

import com.automationpractice.framework.driver.CreateDriver;
import com.automationpractice.framework.utilities.BrowserUtils;
import com.automationpractice.framework.utilities.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Sajeer Savad
 * Header panel common to all tha pages
 *
 */


public class HeaderPanel {

    public HeaderPanel(){
        PageFactory.initElements(CreateDriver.getInstance().getDriver(),this);
    }

    //Using FindBy for locating elements
    @FindBy(how= How.CLASS_NAME, className="login") private WebElement login;
    @FindBy(how=How.CLASS_NAME, className="account")  private WebElement accountName;
    @FindBy(how=How.CLASS_NAME, className="logout")  private WebElement logout;

    public void waitForLoginButton(){
        Log.debug("Waiting for login button. ");
        BrowserUtils.waitForElement(login);
    }

    // This method to click on loginName
    public void clickLogin(){
        Log.info("Clicking login button. ");
        waitForLoginButton();
        this.login.click();
    }

    public void  signOut(){
        Log.info("Signing out of the application. ");
        this.logout.click();
    }


    public  boolean  isLogoutVisible(){
        Log.info("Checking visibility of logout button. ");
        return  logout.isDisplayed();
    }

    public  String  getAccountName(){
        Log.info("Fetching account name. ");
        return  accountName.getText();
    }

}
