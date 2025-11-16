package negativetests;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.WikipediaSearchPage;

public class NegativeSearchTest extends BaseTest{
	@Test(priority=0)
	public void searchInvalidText() {
		WikipediaSearchPage WikiSearchPage = new  WikipediaSearchPage(driver);
		WikiSearchPage.openSearch();	
		WikiSearchPage.performSearch("asdkjasdk123123_no_result");
		WikiSearchPage.verifyNoResultsDisplayed("No results");
	}
	@Test(priority=1)
	public void searchSpecialCharacters()
	{
		WikipediaSearchPage WikiSearchPage = new  WikipediaSearchPage(driver);
		WikiSearchPage.openSearch();
		WikiSearchPage.performSearch("!@#$%^&*(){}[]??<>");
		WikiSearchPage.verifyNoResultsDisplayed("No results");
	}
	@Test(priority=2)
    public void searchVeryLongText() {
		WikipediaSearchPage WikiSearchPage = new  WikipediaSearchPage(driver);
		WikiSearchPage.openSearch();
        String longText = "a".repeat(200);
        WikiSearchPage.performSearch(longText);
        WikiSearchPage.verifyNoResultsDisplayed("No results");
        System.out.println("Negative Test: Very long input search executed");
    }
	  @Test(priority=3)
	    public void searchEmptyInput() {
		  WikipediaSearchPage WikiSearchPage = new  WikipediaSearchPage(driver);
		  WikiSearchPage.openSearch();
		  WikiSearchPage.performSearch("");
	      System.out.println("Negative Test: Empty input search executed");
	    }
	  @Test(priority=4)
	    public void searchSpacesOnly() {
		  WikipediaSearchPage WikiSearchPage = new  WikipediaSearchPage(driver);
		  WikiSearchPage.openSearch();
		  WikiSearchPage.performSearch("      ");
	      System.out.println("Negative Test: Spaces-only search executed");
	    }
}
