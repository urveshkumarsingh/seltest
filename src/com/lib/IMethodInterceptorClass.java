package com.lib;
import java.util.List;

import org.testng.IMethodInstance;
import org.testng.ITestContext;
import org.testng.ITestNGListener;

public interface IMethodInterceptorClass extends ITestNGListener{
	 List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context);

}
