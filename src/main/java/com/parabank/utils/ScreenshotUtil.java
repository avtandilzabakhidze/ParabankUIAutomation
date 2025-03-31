package com.parabank.utils;

import com.parabank.base.BaseAction;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class ScreenshotUtil extends BaseAction implements ITestListener {
    public ScreenshotUtil() throws IOException {
        super();
    }

    public void onTestFailure(ITestResult tr) {
        try {
            takeScreenShot();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}