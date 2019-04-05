package com.automationpractice.framework.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Sajeer Savad
 *
 * Properties manager
 * Fetches the properties from configuration.properties
 *
 */

public class PropertiesManager {
    private static PropertiesManager instance;
    private static final Object lock = new Object();
    private static String propertyFilePath = System.getProperty("user.dir")+
            "\\src\\test\\resources\\configuration.properties";
    private static String browser;
    private static String siteURL;
    private static String waitTimeout;
    private static String pollingInterval;
    private static String userName;
    private static String password;
    private static String testOutputPath;

    //Creates a Singleton instance
    public static PropertiesManager getInstance () {
        if (instance == null) {
            synchronized (lock) {
                instance = new PropertiesManager();
                instance.loadData();
            }
        }
        return instance;
    }

    //Get all configuration data and assign to related fields.
    private void loadData() {
        //Declare a properties object
        Properties prop = new Properties();
        //Read configuration.properties file
        try {
            prop.load(new FileInputStream(propertyFilePath));
            Log.info("Loading properties. ");
        } catch (IOException e) {
            Log.error("Properties file not found. ");
        }

        //Get properties from configuration.properties
        browser = prop.getProperty("browser");
        siteURL = prop.getProperty("siteURL");
        waitTimeout = prop.getProperty("waitTimeout");
        pollingInterval = prop.getProperty("pollingInterval");
        userName = prop.getProperty("userName");
        password = prop.getProperty("password");
        testOutputPath = prop.getProperty("testOutputPath");
    }

    public String getBrowser () {
        return browser;
    }

    public String getSiteURL () {
        return siteURL;
    }

    public String getWaitTimeout () {
        return waitTimeout;
    }

    public String getPollingInterval () {
        return pollingInterval;
    }

    public String getUserName () {
        return userName;
    }

    public String getPassword () {
        return password;
    }

    public String getTestOutputPath() {
        return System.getProperty("user.dir")+ "\\" + testOutputPath + "\\";
    }


}
