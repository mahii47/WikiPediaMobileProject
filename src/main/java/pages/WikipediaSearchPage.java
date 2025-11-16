package pages;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import utils.WaitUtil;

public class WikipediaSearchPage {
	
	By searchbutton = By.xpath("//*[@text='Search']");
	By searchContainer = By.id("org.wikipedia:id/search_card");
	By searchText = By.id("org.wikipedia:id/search_src_text");
	By recommendationoption = By.xpath("(//android.view.ViewGroup[@clickable='true'])[1]"); 
	
	private WaitUtil waitUtil;
	private AndroidDriver<MobileElement> driver;
	
	public WikipediaSearchPage(AndroidDriver<MobileElement> driver)
	{
		this.driver = driver;
		this.waitUtil = new WaitUtil(driver);
	}
	public void searchButton()
	{
		MobileElement searchoption = waitUtil.waitForVisible(searchbutton);
		searchoption.click();
		System.out.println(" SEARCH MODULE");
		System.out.println("    -Search bar opened");
	}
	public void searchArtticle(String text)
	{
		MobileElement searchCard = waitUtil.waitForClickable(searchContainer);
		searchCard.click();
		System.out.println("    -Search field activated");
		MobileElement searchQuery = waitUtil.waitForClickable(searchText);
		searchQuery.sendKeys(text);
		System.out.println("    -Query entered: Artificial Intelligence");
		MobileElement firstOption = waitUtil.waitForClickable(recommendationoption);
		firstOption.click();
		System.out.println("    -First suggestion selected\n");
	}
}
