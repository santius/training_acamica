package com.automation.training.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static java.lang.String.format;
import com.automation.training.pages.ArticlePage;
import com.automation.training.pages.SearchPage;
import com.automation.training.pages.WikiHomePage;

public class WikiTests extends BaseTests {

	@Test(description = "")
	@Parameters({ "searchCriteria" })
	public void testWikiSearch(String searchCriteria) {
		WikiHomePage homePage = getWikiHomePage();
		SearchPage searchPage = homePage.openSearch().search(searchCriteria);
		Assert.assertTrue(searchPage.getResultsSize() > 0, "Expected that the search returns some articles.");

		ArticlePage articlePage = searchPage.openArticleByIndex(0);
		String actualTitle = articlePage.getArticleTitle();
		Assert.assertEquals(actualTitle, searchCriteria,
				format("Expected that the article title is [%s] but was [%s]", searchCriteria, actualTitle));
	}

}
