package com.automationpractice.framework.reports;

import com.automationpractice.framework.Global_VARS;
import com.relevantcodes.extentreports.ExtentReports;

import java.io.File;


/**
 * @author Sajeer Savad
 *
 * ExtentManager class
 * ExtentReports extent instance created here. That instance can be reachable by getReporter() method.
 *
 */

public class ExtentManager {

    private static ExtentReports extent;

    public synchronized static ExtentReports getReporter(){
        if(extent == null){
            //Set HTML reporting file location
            extent = new ExtentReports(Global_VARS.REPORT_PATH, true);
            extent.loadConfig(new File(Global_VARS.REPORT_CONFIG_FILE));
        }
        return extent;
    }
}
