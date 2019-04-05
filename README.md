# All test cases are present under 'src\test\java\com\automationpractice\test\WebTest.java'
# testng.xml is configured to run the test cases. Tests will be executed in 2 threads in the specified browser. 
# User configurations can be set in 'src\test\resources\configuration.properties'
# Test case tc003_checkoutTest takes json data as input for executing the test cases. Json files are located in 'src\test\resources\testData'
# Optional paramter 'browser' can be added to test method. It can be set for individual methods in testng.xml for running the tests in multiple browsers
# Reports are generated using extentreport. It is generated in 'test-output\Reports' folder
# Screenshots will be present in the report for failed test cases. In addition , it will also be stored in 'test-output\Screenshots'
# Logs are generated using log4j2 and is stored in 'test-output\Logs' folder. 