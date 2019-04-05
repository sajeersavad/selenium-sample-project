package com.automationpractice.framework.listeners;


import com.automationpractice.framework.Global_VARS;
import com.automationpractice.framework.driver.CreateDriver;
import com.automationpractice.framework.reports.ExtentManager;
import com.automationpractice.framework.reports.ExtentTestManager;
import com.automationpractice.framework.utilities.Log;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.automationpractice.framework.TestBase;

import java.io.File;
import java.io.IOException;

/**
 * @author Sajeer Savad
 *
 * Test Listener class
 *
 */


public class TestListener extends TestBase implements ITestListener {

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        Log.info("Executing onStart method " + iTestContext.getName());
        iTestContext.setAttribute("WebDriver", CreateDriver.getInstance().getDriver());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        Log.info("Executing onFinish method " + iTestContext.getName());
        //Do tier down operations for extentreports reporting!
        ExtentTestManager.endTest();
        ExtentManager.getReporter().flush();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        Log.info(getTestMethodName(iTestResult) + " start");
        //Start operation for extentreports.
        ExtentTestManager.startTest(iTestResult.getMethod().getMethodName(),"");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Log.info(("Executing onTestSuccess method " +  getTestMethodName(iTestResult) + " succeed"));
        //Extentreports log operation for passed tests.
        ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult)  {
        Log.info("Executing onTestFailure method " +  getTestMethodName(iTestResult) + " failed");
        String filePath =  Global_VARS.SNAPSHOT_PATH + "Screenshot_" +System.currentTimeMillis()+".png";
        //Get driver from BaseTest and assign to local webdriver variable.
        Object testClass = iTestResult.getInstance();
        WebDriver webDriver = CreateDriver.getInstance().getDriver();

        //Convert web driver object to take Screenshot
        TakesScreenshot scrShot =((TakesScreenshot)webDriver);

        //Call getScreenshot As method to create image file
        File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        File destFile=new File(filePath);
        //Copy file to destination
        try{
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e ) {
            Log.error("Exception while taking screenshot "+e.getMessage());
        }

        Log.debug("Test Case failed. Screenshot saved at : " + filePath);
        //Take base64Screenshot screenshot.
        String base64Screenshot = "data:image/png;base64,"+(scrShot).
                getScreenshotAs(OutputType.BASE64);

        //Extentreports log and screenshot operations for failed tests.
        ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed",
                ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Log.info("Executing onTestSkipped method "+  getTestMethodName(iTestResult) + " skipped");
        //Extentreports log operation for skipped tests.
        ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        Log.info("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }

}
