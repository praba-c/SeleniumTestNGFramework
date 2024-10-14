package com.automation.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportListener implements ITestListener {
    ExtentReports extentReports;
    ExtentTest extentTest;

    @Override
    public void onStart(ITestContext context) {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("report/extent-report.html");
        sparkReporter.config().setReportName("Automation");

        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
    }

    @Override
    public void onTestStart(ITestResult result) {
        extentTest = extentReports.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.log(Status.PASS, "Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.log(Status.PASS, "Fail");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.log(Status.PASS, "Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
    }

}
