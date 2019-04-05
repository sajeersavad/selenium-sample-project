package com.automationpractice.pageobjects.usermanagement;

import com.automationpractice.framework.utilities.BrowserUtils;
import com.automationpractice.framework.utilities.Log;
import com.automationpractice.pageobjects.MainPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Sajeer Savad
 * Account creation page PO
 *
 */

public class AccountCreation extends MainPage {


    public AccountCreation(){
        super();
    }



    //Using FindBy for locating elements
    @FindBy(how=How.ID, id="id_gender1") private WebElement titleMr;
    @FindBy(how=How.ID, id="id_gender2") private WebElement titleMrs;
    @FindBy(how=How.ID, id="customer_firstname") private WebElement customerFirstName;
    @FindBy(how=How.ID, id="customer_lastname") private WebElement customerLastName;
    @FindBy(how=How.ID, id="passwd") private WebElement password;
    @FindBy(how=How.ID, id="days") private WebElement days;
    @FindBy(how=How.ID, id="months") private WebElement months;
    @FindBy(how=How.ID, id="years") private WebElement years;
    @FindBy(how=How.ID, id="company") private WebElement company;
    @FindBy(how=How.ID, id="address1") private WebElement address1;
    @FindBy(how=How.ID, id="address2") private WebElement address2;
    @FindBy(how=How.ID, id="city") private WebElement city;
    @FindBy(how=How.ID, id="id_state") private WebElement idState;
    @FindBy(how=How.ID, id="postcode") private WebElement postcode;
    @FindBy(how=How.ID, id="other") private WebElement other;
    @FindBy(how=How.ID, id="phone") private WebElement phone;
    @FindBy(how=How.ID, id="phone_mobile") private WebElement phoneMobile;
    @FindBy(how=How.ID, id="alias") private WebElement alias;
    @FindBy(how=How.ID, id="submitAccount") private WebElement submitAccount;


    // Defining all the user actions (Methods) that can be performed in the Facebook home page

    public void waitForPageLoad(){
        BrowserUtils.waitForElement(this.titleMrs);
    }

    // This method to create user specified random email
    public void selectMr(){
        Log.info("Clicking Mr");
        titleMr.click();
    }

    public void selectMrs(){
        Log.info("Clicking Mrs");
        titleMrs.click();
    }

    public void setCustomerFirstName (String customerFirstName) {
        Log.info("Setting customer first name. ");
        this.customerFirstName.sendKeys(customerFirstName);
    }

    public void setCustomerLastName (String customerLastName) {
        Log.info("Setting customer last name. ");
        this.customerLastName.sendKeys(customerLastName);
    }

    public void setPassword (String password) {
        Log.info("Setting password. ");
        this.password.sendKeys(password);
    }


    // Set date of birth
    public void setDateofBirth(int date , int month , int year) {
        Log.info("Setting date of birth. ");
        BrowserUtils.selectValue(this.days, Integer.toString(date));
        BrowserUtils.selectValue(this.months, Integer.toString(month));
        BrowserUtils.selectValue(this.years, Integer.toString(year));
    }

    public void setCompany(String company){
        this.company.sendKeys(company);
    }

    public void  setAddress1(String address1){
        this.address1.sendKeys(address1);
    }

    public void setAddress2(String address2) {
        this.address2.sendKeys(address2);
    }

    public void setCity(String city) {
        this.city.sendKeys(city);;
    }

    public void setState(String state) {
        BrowserUtils.selectVisibleText(this.idState,state);
    }

    public void setPostcode(String postcode) {
        this.postcode.sendKeys(postcode);
    }

    public void setOther(String other) {
        this.other.sendKeys(other);;
    }

    public void setPhone(String phone) {
        this.phone.sendKeys(phone);;
    }

    public void setPhoneMobile(String phoneMobile) {
        this.phoneMobile.sendKeys(phoneMobile);;
    }

    public void setAlias(String alias) {
        this.alias.sendKeys(alias);;
    }


    // This method to click on Submit link
    public void submitAccount(){
        submitAccount.click();
    }

}
