Selenium-Grid---TestNG-Project
==============================

Setup a Selenium Grid with nodes and a hub. Then create tests to run in parallel on nodes with webdriver.

These files can be used for QA testing of web applications. This is a skeleton setup, and only includes simple tests to confirm the setup.

## Requirements

* Java JDK / JRE (available on PATH)
* Eclipse IDE with TestNG plugin installed
* Firefox with Selenium IDE plugin
* Selenium java client library (available for use by Java)
* Selenium standalone server running in node mode, with appropriate webdrivers for Chrome / IE. This can be on a different machine. An example command:
``` 
java -jar selenium-server-standalone-2.41.0.jar -role node -hub  http://<HUB IP>:4444/grid/register -Dwebdriver.chrome.driver=chromedriver.exe -Dwebdriver.ie.driver=IEDriverServer.exe
```
* Selenium standalone server running in hub mode, available at http://localhost:4444/grid/console. Eg:
```
java -jar selenium-server-standalone-2.41.0.jar -role hub
```
* The node should be visible in the hub interface, with various browser icons corresponding to the number of browser instances that can be launched on that node.

## Basic Usage

* Open Eclipse
* Create a Eclipse java project
* Make sure the TestNG plugin is available and the Selenium library is available in your system library
* Create a new java package
* Create classes within the package. You can start with the two tests included here as a model
* In the root folder of the project, create the two files "TestFiles.xml" and testng.xml
* Make sure the correct test is referenced in TestFiles.xml
* Run testng as TestNG (Right click, run as...)

## Creating Custom Tests

* Start Firefox Selenium IDE
* Record a test of your choosing
* Export the test as JUnit4 / .java
* Paste in the instructions from your exported .java files (Not the whole file - just the individual steps)
* Replace ``` driver. ``` with ``` getDriver(). ```
