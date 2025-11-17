package tests;
import org.testng.annotations.Test;
import base.RegressionBaseTest;
import pages.WikipediaSearchPage;

public class WikipediaSearchTest  extends RegressionBaseTest{
	
	@Test
	public void search() {
		WikipediaSearchPage WikiSearchPage = new  WikipediaSearchPage(driver);
		WikiSearchPage.openSearch();	
		WikiSearchPage.performSearch("Artificial Intelligence");
	}
}
