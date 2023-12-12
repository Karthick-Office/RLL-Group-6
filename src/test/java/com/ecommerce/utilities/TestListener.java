package com.ecommerce.utilities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ecommerce.tests.ContactUsTest;
import com.ecommerce.tests.TestBase;



public class TestListener implements ITestListener{

	Logger log = LogManager.getLogger(TestBase.class);
	
	@Override
	public void onTestStart(ITestResult result) {

		log.info(result.getMethod().getMethodName() +" Started");
		log.info(result.getMethod().getDescription());	
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		log.info(result.getMethod().getMethodName() +" Passed");	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		log.info("Failed because of -"+result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		log.info("Skipped because of -"+result.getThrowable());
	}

	@Override
	public void onStart(ITestContext context) {

		log.info("============onStart:- " + context.getName() +"=============================");
	}

	@Override
	public void onFinish(ITestContext context) {
		
		log.info("============onFinish:- " + context.getName() +"=============================");
	}
	

}