package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class HomePagePage extends BasePage {

	WebDriver driver;
	String categoryName = "Paris";
	String resultRandomNumber = categoryName + generateRandomNumber(99);
	SoftAssert softAssertion= new SoftAssert();
	
	public HomePagePage (WebDriver driver) {
		this.driver=driver;
	}
	
	
	@FindBy (how = How.XPATH, using ="//input[@name='categorydata']")WebElement ADD_CATEGORY_NAME;
	@FindBy (how = How.XPATH, using ="//input[@value='Add category']")WebElement ADD_CATEGORY_BUTTON;
	@FindBy (how = How.XPATH, using ="/html/body")WebElement EXPECTED_MESSAGE;
	@FindBy (how = How.XPATH, using ="/html/body/a[2]")WebElement NEVERMIND_BUTTON;
	
	
	
	
	public void addCategoryName() {
	
		ADD_CATEGORY_NAME.sendKeys(resultRandomNumber);
		ADD_CATEGORY_BUTTON.click();
	

	}
	public void validateDuplicatedCategory() {
		ADD_CATEGORY_NAME.sendKeys(resultRandomNumber);
		ADD_CATEGORY_BUTTON.click();
		
		
		softAssertion.assertEquals("The category you want to add already exists:", EXPECTED_MESSAGE.getText());
	
				
	}


		public void monthDropDown2() {
			NEVERMIND_BUTTON.click();
			String[] arr = {"None","Jan","Feb","Mar", "Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
			WebElement element=	driver.findElement(By.xpath("//select[@name='due_month']"));
			 Select select = new Select(element);
			 List<WebElement> options = select.getOptions();

			 for(WebElement e : options){
			     for(int i = 0; i<arr.length; i++){
			         if(e.getText().equals(arr[i])){
			             System.out.println("Matched" );
			             break;
			         }
			     }
		}
			 softAssertion.assertAll();
}
}
