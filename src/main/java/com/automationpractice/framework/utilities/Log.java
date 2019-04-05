package com.automationpractice.framework.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Sajeer Savad
 *
 * Logger class for log4j2
 *
 *
 */

public class Log {

// Initialize Log4j logs
    private static Logger Log = LogManager.getLogger(com.automationpractice.framework.utilities.Log.class.getName());

    public static void info(String message) {
        Log.info(message);
    }

    public static void warn(String message) {
        Log.warn(message);
    }

    public static void error(String message) {
        Log.error(message);
    }

    public static void fatal(String message) {
        Log.fatal(message);
    }

    public static void debug(String message) {

        Log.debug(message);

    }

}