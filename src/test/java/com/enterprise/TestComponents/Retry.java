package com.enterprise.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
	int count = 0;
	int maxTry = 1;

	@Override
	public boolean retry(ITestResult result) {
		if (count < maxTry) {
			count++;
			System.out.println("Retrying test: " + result.getName() + " (Attempt " + count + ")");
			return true;
		}
		return false;
	}

}
