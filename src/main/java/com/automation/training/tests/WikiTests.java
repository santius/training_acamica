package com.automation.training.tests;

import org.testng.annotations.Test;

import com.automation.training.pages.WikiHomePage;

public class WikiTests extends BaseTests{
	
	@Test
	public void testWikiSearch() {
		WikiHomePage home = getWikiHomePage();
	}

}
