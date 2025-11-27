📱 Wikipedia App Automation – Appium Hybrid Framework (Java + TestNG + Allure Reports)

This project is a complete mobile automation framework built for the Wikipedia Android app using Appium, Java, TestNG, ADB commands, Screenshot Listeners, POM, and full Allure Reporting.

Framework includes Regression, Negative, Interrupt, and Permission Handling test suites — covering real-world user workflows + advanced mobile testing scenarios.

🚀 Project Overview
✅ 1. Regression Flow (Main E2E Flow)

Open app drawer

Launch Wikipedia

Search article

Open article

Scroll to section

Navigate through Table of Contents

Change theme, font & reading mode

Return to home screen

⚠️ 2. Negative Search Tests

Empty input

Special characters

Boundary value long input

Random meaningless keywords

Valid but rare queries

Validate “No results” message

📶 3. Interrupt Tests (Network ON/OFF via ADB)

Disable mobile data

Perform network-dependent actions

Validate “Retry” handling

Re-enable network

Complete action successfully

📂 4. Storage Permission Tests

Trigger “Picture of the day → Download”

Handle Android system permission popup:

ALLOW → verify image downloaded in /sdcard/Pictures/Wikipedia/

DENY → verify correct error message

🖼️ 5. Automatic Screenshots on Failure

A custom TestNG Listener:

Captures PNG on any test failure

Saves under /screenshots/

Displays screenshot inside Allure report

📊 Allure Reporting Integration

Allure reporting is fully integrated and generates rich reports with:

✔ Step-wise logs
✔ Failure screenshots
✔ Categories
✔ Environment info
✔ Timeline & history

Run Allure report:
allure serve allure-results


This automatically:

Reads latest results

Opens a full interactive dashboard in browser

Report Components Included:

✔ Detailed test steps

✔ Attachments & screenshots

✔ Fail/pass statistics

✔ Suite breakdown (Regression, Negative, Interrupt, Permission)

🏛️ Framework Architecture
Wikipedia-Automation/
│
├── base/
│   ├── BaseTest.java
│   ├── RegressionBaseTest.java
│
├── config/
│   ├── CapabilitiesManager.java
│
├── listeners/
│   ├── ScreenshotListener.java
│   ├── AllureTestListener.java
│
├── pages/
│   ├── HomePage.java
│   ├── WikipediaSearchPage.java
│   ├── ArticlePage.java
│   ├── InterruptPage.java
│   ├── StoragePermissionPage.java
│
├── negativetests/
│   ├── NegativeSearchTest.java
│   ├── InterruptTest.java
│   ├── StoragePermissionTest.java
│
├── tests/
│   ├── HomeTest.java
│   ├── WikipediaSearchTest.java
│   ├── ArticleTest.java
│
├── testng_regression.xml
├── testng_negative.xml
├── testng_interrupt.xml
├── testng_storage_permission.xml
│
├── allure-results/
├── screenshots/
│
└── README.md

🔧 Tech Stack

Appium Java Client

Java + TestNG

Allure Reports

POM (Page Object Model)

Explicit Waits

ADB commands

TouchAction (Gestures)

Android Real Device

Maven

🗂️ How to Run Tests
👉 Regression Suite
mvn test -DsuiteXmlFile=testng_regression.xml

👉 Negative Suite
mvn test -DsuiteXmlFile=testng_negative.xml

👉 Interrupt Suite
mvn test -DsuiteXmlFile=testng_interrupt.xml

👉 Storage Permission Suite
mvn test -DsuiteXmlFile=testng_storage_permission.xml

📸 Screenshot Storage

On failure, screenshots are stored automatically at:

/screenshots/


And attached in Allure Report.

🌟 Why This Project Stands Out

Covers 4 major mobile testing types

Uses real device + real app from Play Store

Includes ADB-based network simulation

Handles system permission popups

Clean POM architecture

Beautiful Allure reporting

Professional GitHub project structure

Great for showcasing QA automation skill in interviews + LinkedIn

🚧 Future Enhancements (Optional)

Parallel execution using TestNG

Retry logic for flaky tests

Integrate Jenkins CI

Add video recording

Integrate BrowserStack / Saucelabs
