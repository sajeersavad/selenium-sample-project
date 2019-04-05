package com.automationpractice.pageobjects.usermanagement;

import com.automationpractice.framework.utilities.BrowserUtils;
import com.automationpractice.framework.utilities.Log;
import com.automationpractice.pageobjects.MainPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MyAccountPage extends MainPage {


    public MyAccountPage(){
        super(); }

    @FindBy(how=How.CSS, using="h1") private WebElement heading;
    @FindBy(how=How.CLASS_NAME, className="info-account") private WebElement accountInfo;

    public void waitForPageLoad(){
        Log.debug("Waiting for the page to refresh. ");
        BrowserUtils.waitForElement(this.heading);
    }

    public  String  getHeading(){
        Log.info("Fetching heading. ");
       return  this.heading.getText();
    }


    public  String  getAccountInfo(){
        Log.info("Fetching account info. ");
        return  this.accountInfo.getText();
    }


}
