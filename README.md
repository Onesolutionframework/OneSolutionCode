# Selenium Framework

**Table of contents**

* [Summary](#summary)
* [Intended Audience](#audience)
* [Prerequisites](#prerequisites)
* [Key Components](#components)
* [Automation Framework Approach](#approach)
* [Framework Highlights](#highlights)
* [Folder Structre](#structure)
* [Troubleshooting](#troubleshooting)
* [Questions and comments](#questions)
* [Additional resources](#additional-resources)

<a name="summary"></a>
## Summary ##
A hybrid framework for selenium based automation.

This framework comes with various features to Batch run, to provide test data from excel files, to generate screenshots, to generate reports in html format and to validate expected result with actual result

<a name="audience"></a>
## Intended Audience ##
Who works on selenium based automation testing and want to jump start the automation with test data, batch run, and reporting capabilities

<a name="prerequisites"></a>
## Prerequisites ##

This Prerequisite requires the following:

  - Selenium expertise.
  - Selenium and TestNG configured
  - POM dependencies

<a name="components"></a>
## Key Components ##

  - Batch test runner
  - Environment setup
  - Data Driven support
  - Object repository
  - Validations
  - Extent reporting
  - Utilities
  - Logs

<a name="approach"></a>
## Automation Framework ##
![framework diagram](https://user-images.githubusercontent.com/41419116/42936143-f9202290-8b68-11e8-9e8f-0e0cf0d1f847.png)

<a name="highlights"></a>
## Highlights ##

  - Easy to use Framework
  - Re-use of the web scripts mostly without any modification
  - Multi browser capability - Runs on IE, Chrome, Firefox at the same time
  - Parallel execution is enabled using TestNG capability.
  - Auto capture of screenshots for failure and success test run
  - Highly Customizable Test Reporting i.e. HTML reporter, Charts
  - Debug logs generated for failure analysis
  - Improved performance of script execution
  - Provides advantage of scalability and reusability
  - Global exception handler
  - Can be integrated into CI (Jenkins) server and executed depending upon the need.
  - Enabled Sauce lab integration for testing in Cloud

<a name="structure"></a>
## Folder Structure ##


```
_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
AutoCodeBase
│   README.md
│   testng.xml
│   pom.xml
│
└───ObjectRepo
│   │   file011.txt
│   │   file012.txt
│   │
│   └───subfolder1
│       │   file111.txt
│       │   file112.txt
│       │   ...
│
└───Screenshots
│   │
│   │
└───src
│   │
│   └───com.<<projectname>>
|   │   │
|   │   └───base
|   │       │   PageInitialize.java
|   │   │
|   │   └───browser
|   │   │
|   │   └───pages
|   │   │
|   │   └───tests
|   │   │
|   │   └───utilities
|   │   │
|   │   └───zEnhancements
|   │   │
|   │   └───base
|   │   │
|   │   └───base
│   │
│   └───com.resources
│       │   chromedriver.exe
│       │   extent-config.xml
│       │   web.config
│
│
└───TestData
│   │   file1.xlsx
│   │   file2.xlsx
│
│
└───TestReport
│   │   Report.html
_ _ _ _ _ __ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
```
