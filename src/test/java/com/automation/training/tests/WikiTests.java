package com.automation.training.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automation.training.pages.ArticlePage;
import com.automation.training.pages.SearchPage;
import com.automation.training.pages.WikiHomePage;

public class WikiTests extends BaseTests{
	
	@Test(description="")
	@Parameters({"searchCriteria"})
	public void testWikiSearch(String searchCriteria) {
		WikiHomePage home = getWikiHomePage();
		SearchPage searchPage = home.openSearch().search(searchCriteria);
		Assert.assertTrue(searchPage.getResultsSize() > 0, "");
		
		ArticlePage articlePage = searchPage.openArticleByIndex(0);
		Assert.assertEquals(articlePage.getArticleText(), searchCriteria, "");		
	}

}
