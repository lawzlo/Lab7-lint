package com.example.tests;

import org.openqa.selenium.server.SeleniumServer;
import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;


public class task7 extends SeleneseTestCase {
	static SeleniumServer server = null;

	@Before
	public void setUp() throws Exception {
		try {
			if (server == null) {
				server = new SeleniumServer();
				server.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		setUp("http://webtesting.idyll.org/", "*chrome");
	}


	@Test
	public void testTask7() throws Exception {
		selenium.open("/");
		selenium.click("css=input.default-text.DefaultText7205");
		selenium.click("css=em");
		selenium.waitForPageToLoad("30000");
		selenium.type("UserID", "lint");
		selenium.type("css=input[name=PIN]", "0ne-piece");
		selenium.click("css=p > input[type=submit]");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Student");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Schedule Lookup Page (NOT Live Data)");
		selenium.waitForPageToLoad("30000");
		selenium.type("id1", "lint");
		selenium.click("bt1");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium
				.isTextPresent("CSSE376-02	3413	Software Quality Assurance"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
