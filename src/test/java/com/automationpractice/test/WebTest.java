package com.automationpractice.test;

import com.automationpractice.framework.TestBase;
import com.automationpractice.framework.Global_VARS;
import com.automationpractice.framework.utilities.JSONDataProvider;
import com.automationpractice.framework.utilities.Log;
import com.automationpractice.pageobjects.*;
import com.automationpractice.pageobjects.productmanagement.cartdetails.*;
import com.automationpractice.pageobjects.productmanagement.ProductDetails;
import com.automationpractice.pageobjects.productmanagement.Category;
import com.automationpractice.pageobjects.productmanagement.ShoppingCart;
import com.automationpractice.pageobjects.usermanagement.AccountCreation;
import com.automationpractice.pageobjects.usermanagement.LoginPage;
import com.automationpractice.pageobjects.usermanagement.MyAccountPage;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;

/**
 * @author Sajeer Savad
 *
 * Browser Test cases
 *
 */

public class WebTest extends TestBase {

    /**
     * Test : tc001_signInTest
     * Description : Validate user account creation
     *
     * @throws Exception
     */
    @Test
    public void tc001_signInTest() throws Exception {
        String timestamp = String.valueOf(new Date().getTime());
        String email = "gk_" + timestamp + "@gk" + timestamp.substring(7) + ".com";
        String firstName = "Firstname";
        String lastName = "Lastname";
        String userName = firstName + " " + lastName;

        MainPage mainPage = new MainPage();
        mainPage.headerPanel().clickLogin();
        LoginPage loginPage = new LoginPage();
        loginPage.createNewAccount(email);

        // New account creation
        AccountCreation accountCreation = new AccountCreation();
        accountCreation.waitForPageLoad();
        accountCreation.selectMrs();
        accountCreation.setCustomerFirstName(firstName);
        accountCreation.setCustomerLastName(lastName);
        accountCreation.setPassword("qwerty");
        accountCreation.setDateofBirth(1,1,2000);
        accountCreation.setCompany("Company");
        accountCreation.setAddress1("Qwerty, 123");
        accountCreation.setAddress2("zxcvb");
        accountCreation.setCity("Qwerty");
        accountCreation.setState("Colorado");
        accountCreation.setPostcode("12345");
        accountCreation.setOther("Qwerty");
        accountCreation.setPhone("12345123123");
        accountCreation.setPhoneMobile("12345123123");
        accountCreation.setAlias("gk");
        accountCreation.submitAccount();

        MyAccountPage myAccountPage = new MyAccountPage();
        myAccountPage.waitForPageLoad();
        Assert.assertEquals(myAccountPage.getHeading() , "MY ACCOUNT", "Incorrect heading. ");
        Assert.assertEquals(myAccountPage.headerPanel().getAccountName() , userName, "Incorrect account name. ");
        Assert.assertTrue(myAccountPage.getAccountInfo().contains("Welcome to your account."), "Incorrect Account info. ");
        Assert.assertTrue(myAccountPage.headerPanel().isLogoutVisible() ,"Logout button not visible. ");
        Assert.assertTrue(myAccountPage.getCurrentURL().contains("controller=my-account"),"Malformed URL. ");
        myAccountPage.headerPanel().signOut();
    }

    /**
     * Test : tc002_logInTest
     * Description : Validates existing user log in
     *
     * @throws Exception
     */
    @Test
    public void tc002_logInTest() throws Exception {
        String userName = "Ankit Nigam";
        MainPage mainPage = new MainPage();
        mainPage.headerPanel().clickLogin();
        LoginPage loginPage = new LoginPage();
        loginPage.existingUserLogin(Global_VARS.EXISTING_USER_NAME,Global_VARS.EXISTING_PASSWORD);
        MyAccountPage myAccountPage = new MyAccountPage();
        myAccountPage.waitForPageLoad();
        Assert.assertEquals(myAccountPage.getHeading() , "MY ACCOUNT", "Incorrect heading. ");
        Assert.assertEquals(myAccountPage.headerPanel().getAccountName() , userName, "Incorrect user name. ");
        Assert.assertTrue(myAccountPage.getAccountInfo().contains("Welcome to your account."), "Incorrect Account info. ");
        Assert.assertTrue(myAccountPage.headerPanel().isLogoutVisible() ,"Logut button not visible. ");
        Assert.assertTrue(myAccountPage.getCurrentURL().contains("controller=my-account"),"Malformed URL. ");
        myAccountPage.headerPanel().signOut();
    }

    /**
     * Test : tc003_checkoutTest
     * Description : Validates product check out
     * @param rowId
     * @param descrption
     * @param testData
     *
     * @throws Exception
     */
   @Test(dataProvider="fetchData_JSON",dataProviderClass= JSONDataProvider.class)
    public void tc003_checkoutTest(String rowId ,String descrption , JSONObject testData){
        Log.info("Executing test case wth row id : " + rowId +" and description " + descrption + " . ");
        MainPage mainPage = new MainPage();
        mainPage.headerPanel().clickLogin();
        LoginPage loginPage = new LoginPage();
        loginPage.existingUserLogin(Global_VARS.EXISTING_USER_NAME,Global_VARS.EXISTING_PASSWORD);
        MyAccountPage myAccountPage = new MyAccountPage();
        myAccountPage.waitForPageLoad();
        myAccountPage.categoryPanel().waitForCategoryLoad();
        myAccountPage.categoryPanel().selectWomenCategory();

        //item selection
        Category womenCategory = new Category();
        womenCategory.selectItem(testData.get("shoppingItem").toString());
        womenCategory.addItem();
        ProductDetails productDetails = new ProductDetails();
        productDetails.setQuantity(testData.get("quantity").toString());
        productDetails.addToCart();
        productDetails.checkOut();

        //shopping cart
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.waitForPageLoad();
        ShoppingCartSummary shoppingCartSummary = shoppingCart.shoppingCartSummary();
        shoppingCartSummary.waitForRefresh();
        shoppingCartSummary.proceedToCheckOut();
        AddressSummary addressSummary = shoppingCart.addressCart();
        addressSummary.waitForRefresh();
        addressSummary.processAddress();
        ShippingSummary shippingDetailsSummary = shoppingCart.shippingDetailsCart();
        shippingDetailsSummary.waitForRefresh();
        shippingDetailsSummary.acceptTerms();
        shippingDetailsSummary.processCarrier();
        PaymentSummary paymentSummary = shoppingCart.paymentSummary();
        paymentSummary.waitForRefresh();
        paymentSummary.selectBankWire();
        paymentSummary.waitForOrderRefresh();
        paymentSummary.confirmOrder();;

        //assertions
        String heading = shoppingCart.getheading();
        Assert.assertEquals(heading,"ORDER CONFIRMATION" , "Heading mismatch. ");
        Assert.assertTrue(paymentSummary.isCurrentStepDisplayed() , "Invalid current step in DOM. ");
        Assert.assertTrue(paymentSummary.isLastStepDisplayed() , "Invalid last step in DOM. ");
        Assert.assertTrue(paymentSummary.getOrderInfo().contains("Your order on My Store is complete.") , "Invalid order details. ");
        Assert.assertTrue(shoppingCart.getCurrentURL().contains("controller=order-confirmation") , "malformed URL. ");

        shoppingCart.headerPanel().signOut();
    }

}
