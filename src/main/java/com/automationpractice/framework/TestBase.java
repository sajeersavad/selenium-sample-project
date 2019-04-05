package com.automationpractice.framework;

import com.automationpractice.framework.driver.CreateDriver;
import com.automationpractice.framework.utilities.Log;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

/**
 * @author Sajeer Savad
 * Test setup and tear down methods
 *
 */

public class TestBase {

    /**
     * Suite Setup method
     *
     * @throws Exception
     */
    @BeforeSuite()
    protected  void suiteSetup(ITestContext context) {

    };


    /**
     * Suite Teardown method
     *
     * @throws Exception
     */
    @AfterSuite
    protected void suiteTearDown() {
        Log.info("Test execution completed. ");
        Log.info("Test report generated at : " + Global_VARS.REPORT_PATH);
    }

    /**
     * test setup method
     *
     * @throws Exception
     */
    @BeforeTest(alwaysRun = true)
    protected void testSetup() {
        Log.info("Executing test set up ");
    }

    /**
     * test Teardown method
     *
     * @throws Exception
     */
    @AfterTest(alwaysRun = true)
    protected void testTearDown() throws Exception {

    }

    /**
     * testClass Setup method
     *
     * @param context
     * @throws Exception
     */
    @BeforeClass(alwaysRun = true)
    protected void testClassSetup(ITestContext context) {
    }

    /**
     * testClassTeardown method
     *
     * @param context
     * @throws Exception
     */
    @AfterClass(alwaysRun = true)
    protected void testClassTeardown(ITestContext context) {
    }

    /**
     * testMethod Setup method
     *
     * @param method
     * @throws Exception
     */

    @BeforeMethod
    @Parameters("browser")
    protected void testMethodSetup(Method method, @Optional String browser ) {
        Log.info("Starting test case " + method.getName() + ". ");
        // Creating web driver instance
        CreateDriver.getInstance().setDriver(browser);
        // Navigating to home page
        CreateDriver.getInstance().getDriver().get(Global_VARS.TARGET_URL);
    }

    /**
     * testMethod Teardown method
     *
     * @param result
     * @throws Exception
     */
    @AfterMethod
    protected void testMethodTeardown(ITestResult result){
        Log.info("Test case " + result.getMethod().getMethodName() + " completed. ");
        //using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
        CreateDriver.getInstance().closeDriver();
    }


}
