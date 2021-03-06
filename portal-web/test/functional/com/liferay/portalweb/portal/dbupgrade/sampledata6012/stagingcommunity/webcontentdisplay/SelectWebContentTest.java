/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portalweb.portal.dbupgrade.sampledata6012.stagingcommunity.webcontentdisplay;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SelectWebContentTest extends BaseTestCase {
	public void testSelectWebContent() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForElementPresent("link=Control Panel");
		selenium.clickAt("link=Control Panel", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Communities", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.type("_134_name",
			RuntimeVariables.replace(
				"Community Staging Community Web Content Display"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Staging"),
			selenium.getText("//td[1]/a[2]"));
		selenium.clickAt("//td[1]/a[2]", RuntimeVariables.replace("Staging"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible(
			"link=Page Staging Community Web Content Display");
		selenium.clickAt("link=Page Staging Community Web Content Display",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent(
				"//body[@class='blue staging controls-visible signed-in public-page dockbar-ready']"));
		selenium.clickAt("//img[@alt='Select Web Content']",
			RuntimeVariables.replace(""));
		selenium.waitForVisible("//td[1]/a");
		assertTrue(selenium.isElementPresent("//td[1]/a"));
		assertEquals(RuntimeVariables.replace("WC Web Content Name"),
			selenium.getText("//td[2]/a"));
		assertTrue(selenium.isElementPresent("//td[3]/a"));
		assertTrue(selenium.isElementPresent("//td[4]/a"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//td[5]/a"));
		selenium.clickAt("//td[2]/a",
			RuntimeVariables.replace("WC Web Content Name"));
		selenium.waitForPartialText("//form[@id='_86_fm1']/div",
			"Displaying Content:");
		assertTrue(selenium.isPartialText("//form[@id='_86_fm1']/div",
				"Displaying Content:"));
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"You have successfully updated the setup."),
			selenium.getText("//div[@class='portlet-msg-success']"));
	}
}