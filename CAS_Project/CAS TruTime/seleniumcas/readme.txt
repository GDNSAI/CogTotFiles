Topic Name: TruTime

Problem Statement: Verify dates and days of current week  

Verify the dates and days of the week displayed on TruTime page. 
The dates displayed should be in accordance with current date in system. 
 
 
Detailed Description: 
-Login to be.cognizant.com with a valid registered Email ID 
-Verify if the name and designation of the employee is displayed on the Homepage.
-Navigate to OneCognizant->TruTime.
-Verify the dates and days of the week displayed on TruTime home page, and print them on console.
-Verify that the date under “Today” section matches the current date of the system.
-Take screenshot of each test case 


Key Automation Scope:  
-Extract menu items from frames & store in collections.
-Handling different browser windows.
-Handling search option.
-Taking screenshots.


About this Project:

src/test/java contains pageObjects,testCases and utilityMethods
-pageObjects package contains page object elements and methods.
-testCases package contains all the test cases.
-utilityMethods package contains extendReport and DateManager.
 
report folder contains
-automation-report.html is the report generated by using the Extent Reports.
 
pom.xml contains the dependencies required by the project
 
testng.xml file is for running the test cases.

test-output folder contains testng report and other files.

screenshots folder contains the screenshots.

Tools and Technologies used:
-Selenium with Java in Eclipse IDE
-TestNG
-Maven
-WebDriverManager
-ExtentReports


By: JibunHassan

