package negativetests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.WikipediaSearchPage;

public class NegativeSearchTest extends BaseTest{
	
	@Test
	public void search() {
		WikipediaSearchPage WikiSearchPage = new  WikipediaSearchPage(driver);
		WikiSearchPage.openSearch();	
		WikiSearchPage.performSearch("asdkjasdk123123_no_result");
		WikiSearchPage.verifyNoResultsDisplayed("No results");
	}

}
