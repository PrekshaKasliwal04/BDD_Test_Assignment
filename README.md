"# Usabilla_Test_Assignment" 
This Maven project is based on Behavior Driven Development using Gherkin with Cucumber.

It executes the test scripts, which have been defined in the feedbackTest.feature file.The language, in which this executable feature files is written is Gherkin.

Below is explanation of various aspetcs of project directory 
pom.xml - It is an XML file that contains information about the Usabilla test assignment project and configuration details used by Maven to build the cucumber project. 

testng.xml- This XML file is used to invoke TestNG, suite name is specified along with testname. It will execute class files mentioned in class tags.

RunTest.java - Cucumber executions tests are written in this file. This is the class which is mentioned in testng.xml . Cucumber feature file execution is initiated from @Test annotation mentioned here.

FeedbackTest.java - Cucumber steps are defined in this file. Chrome and firefox browser can be initiated with written methods which will then navigate to URL mentioned in feedbackTest.feature file.
  
feebackTest.feature - Gherkin based feature file, here I have covered three basic tests for feedback feature. Here I have tried to encorporate scenarios with different types of input. 

So this was all about basic project structure. 

Now, Let's move on how to Run this project
There are various ways by which we can execute tests
Import project in eclipse  

There are following ways to execute from eclipse

1.1 Right click on pom.xml and select - Run As - maven clean, maven install, maven test . 
1.2 Right click on testng.xml - Run As - TestNG Suite


After the execution, we can check Test Report from - target/suerfire-reports/index.html .
