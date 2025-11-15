package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.WikipediaSearchPage;

public class WikipediaSearchTest  extends BaseTest{
	
	@Test
	public void search() {
		WikipediaSearchPage WikiSearchPage = new  WikipediaSearchPage(driver);
		WikiSearchPage.searchButton();	
		WikiSearchPage.searchArtticle("Artificial Intelligence");
	}
}
