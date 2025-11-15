package tests;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ArticlePage;


public class ArticleTest extends BaseTest{
		@Test
		public void article()
		{
			ArticlePage ap = new ArticlePage(driver);
			ap.scrollPage();
			ap.contentsIcon();
			ap.allcontainsOptions();
			
		}
}
	
