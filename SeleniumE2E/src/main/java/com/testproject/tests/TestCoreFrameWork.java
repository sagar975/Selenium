package com.testproject.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.testproject.common.TestProjectAbstractSeleniumTest;
import com.testproject.core.listener.AutomationListner;

public class TestCoreFrameWork extends TestProjectAbstractSeleniumTest {

	private static final Logger logger = Logger.getLogger(TestCoreFrameWork.class);

	@Test(enabled = true, description = "this is test project")
	public void testFrameworkChanges() {

		logger.info("coreframework worked");

	}

}
