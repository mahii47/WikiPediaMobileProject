package tests;
import org.testng.annotations.Test;

import base.BaseTest;
import base.RegressionBaseTest;
import pages.ArticlePage;


public class ArticleTest extends RegressionBaseTest{
		@Test
		public void verifyArticleNavigationAndReaderSettings()
		{
			ArticlePage articlePage  = new ArticlePage(driver);
			articlePage.scrollToTargetSection();
	        articlePage.openTableOfContents();
	        articlePage.selectSectionFromContents();
	        articlePage.openAndApplyReaderTheme();
	        articlePage.returnToHomeScreen();
		}
}
	