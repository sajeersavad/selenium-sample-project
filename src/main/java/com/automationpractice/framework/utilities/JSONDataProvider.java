package com.automationpractice.framework.utilities;


import com.automationpractice.framework.Global_VARS;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sajeer Savad
 *
 * TestNG JSON DataProvider Utility Class
 *
 */
public class JSONDataProvider {
    private static String dataFile = Global_VARS.DATA_FILE;
    public static String testCaseName = "NA";

    public JSONDataProvider() throws Exception {
    }

    /**
     * fetchData method to retrieve test data for specified method
     *
     * @param method
     * @return Object[][]
     * @throws Exception
     */
    @DataProvider(name = "fetchData_JSON")
    public static Object[][] fetchData(Method method) throws Exception {
        Object rowID, description;
        Object[][] result;
        testCaseName = method.getName();
        Log.info("Fetching data from file " + dataFile + "for test case" + testCaseName + " . ");
        List<JSONObject> testDataList = new ArrayList<JSONObject>();
        JSONArray testData = (JSONArray) extractData_JSON(dataFile).get(method.getName());

        for ( int i = 0; i < testData.size(); i++ ) {
            testDataList.add((JSONObject) testData.get(i));
        }

        // create object for data provider to return
        try {
            result = new Object[testDataList.size()][testDataList.get(0).size()];

            for ( int i = 0; i < testDataList.size(); i++ ) {
                rowID = testDataList.get(i).get("rowID");
                description = testDataList.get(i).get("description");
                result[i] = new Object[] { rowID, description,  testDataList.get(i) };
            }
        }

        catch(IndexOutOfBoundsException ie) {
            Log.error("Exception thrown while fetching json data. ");
            result = new Object[0][0];
        }

        return result;
    }

    /**
     * extractData_JSON method to get JSON data from file
     *
     * @param file
     * @return JSONObject
     * @throws Exception
     */
    public static JSONObject extractData_JSON(String file) throws Exception {
        FileReader reader = new FileReader(file);
        JSONParser jsonParser = new JSONParser();

        return (JSONObject) jsonParser.parse(reader);
    }





}
