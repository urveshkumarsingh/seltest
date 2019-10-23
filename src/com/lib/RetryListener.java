package com.lib;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Set;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;

public class RetryListener implements IAnnotationTransformer, ITestListener{
	
	
	public void transform(ITestAnnotation testannotation, Class testClass,
			Constructor testConstructor, Method testMethod)	{
		IRetryAnalyzer retry = testannotation.getRetryAnalyzer();

		if (retry == null)	{
			testannotation.setRetryAnalyzer(Retry.class);
		}

	}

		 public void onFinish(ITestContext context) {
				Set<ITestResult> failedTests = context.getSkippedTests().getAllResults();
				for (ITestResult temp : failedTests) {
					ITestNGMethod method = temp.getMethod();
					if (context.getFailedTests().getResults(method).size() > 1) {
						failedTests.remove(temp);
					} else {
						if (context.getPassedTests().getResults(method).size() > 0) {
							failedTests.remove(temp);
						}else{
							if(context.getSkippedTests().getResults(method).size()>0){
								failedTests.remove(temp);
							}
						}
					}
				}
			}


	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}



	
}
