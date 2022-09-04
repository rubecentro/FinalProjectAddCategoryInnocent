package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.HomePagePage;
import util.BrowserFactory;

public class HomePageTest {

	WebDriver driver;
	
	@Test
	public void userShouldBeAbleToAddCategory() {
		
		 driver = BrowserFactory.init();
		 HomePagePage homepage = PageFactory.initElements(driver, HomePagePage.class);
		 homepage.addCategoryName();
		 homepage.validateDuplicatedCategory();
		 homepage.monthDropDown2();
		 
		 BrowserFactory.tearDown();
	}
	
}
