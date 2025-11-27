package pages;
import org.openqa.selenium.By;
import org.testng.Assert;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import utils.WaitUtil;

public class WikipediaSearchPage {
	
	By searchButton = By.xpath("//*[@text='Search']");
	By searchInputContainer = By.id("org.wikipedia:id/search_card");
	By searchTextBox = By.id("org.wikipedia:id/search_src_text");
	By firstSuggestionOption = By.xpath("(//android.view.ViewGroup[@clickable='true'])[1]"); 
	By searchSuggestion = By.id("org.wikipedia:id/results_text");
	
	private WaitUtil waitUtil;
	private AndroidDriver<MobileElement> driver;
	
	public WikipediaSearchPage(AndroidDriver<MobileElement> driver)
	{
		this.driver = driver;
		this.waitUtil = new WaitUtil(driver);
	}
	@Step("Opening Search Module")
	public void openSearch()
	{
		MobileElement searchOption = waitUtil.waitForVisible(searchButton);
		searchOption.click();
		System.out.println(" SEARCH MODULE");
		System.out.println("    -Search bar opened");
	}
	@Step("Searching for: {text}")
	public void performSearch(String text)
	{
		MobileElement searchCard = waitUtil.waitForClickable(searchInputContainer);
		searchCard.click();
		System.out.println("    -Search field activated");
		MobileElement searchQuery = waitUtil.waitForClickable(searchTextBox);
		searchQuery.sendKeys(text);
		System.out.println("    -Query entered:"+text+"");
		try
		{
		MobileElement firstOption = waitUtil.waitForClickable(firstSuggestionOption);
		firstOption.click();
		System.out.println("    -First suggestion selected\n");
		}
		catch(Exception e)
		{
			
		}
	}
	public void verifyNoResultsDisplayed(String text)
	{
		MobileElement searchResult = waitUtil.waitForVisible(searchSuggestion);
		String result = searchResult.getText();
		Assert.assertEquals(result, text);
		System.out.println("Actual result is:"+result);
		System.out.println("Expected result is:"+text);
	}
}