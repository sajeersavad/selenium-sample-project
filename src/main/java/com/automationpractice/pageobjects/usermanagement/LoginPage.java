package com.automationpractice.pageobjects.usermanagement;

import com.automationpractice.framework.utilities.Log;
import com.automationpractice.pageobjects.MainPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


/**
 * @author Sajeer Savad
 * Login Page PO
 *
 */
public class LoginPage extends MainPage {

    public LoginPage(){
        super();
    }

    //Using FindBy for locating elements
    @FindBy(how=How.ID, id="email_create") private WebElement emailCreate;
    @FindBy(how=How.ID, id="SubmitCreate") private WebElement submitCreate;
    @FindBy(how=How.ID, id="email") private WebElement emailExisting;
    @FindBy(how=How.ID, id="passwd") private WebElement password;
    @FindBy(how=How.ID, id="SubmitLogin") private WebElement submitLogin;



    private void setEmailCreate(String email){
        Log.info("Setting email for create account. ");
        this.emailCreate.sendKeys(email);
    }


    private void submitCreate(){
        Log.info("clicking submit button for create account. ");
        this.submitCreate.click();
    }

    private void setEmailExisting(String email) {
        Log.info("Setting email for existing account. ");
        this.emailExisting.sendKeys(email);
    }

    private void setPasswordExisting(String password){
        Log.info("Setting password for existing account. ");
        this.password.sendKeys(password);
    }

    private void loginExisting(){
        Log.info("Clicking login button. ");
        this.submitLogin.click();
    }

    public void createNewAccount(String email) {
        this.setEmailCreate(email);
        this.submitCreate();
    }

    public void existingUserLogin(String userName ,String password) {
    setEmailExisting(userName);
    setPasswordExisting(password);
    loginExisting();
    }

}
