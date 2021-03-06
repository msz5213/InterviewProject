package testCases;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import testPages.CheckboxesPage;
import utilities.Utils;

public class Three_CheckBoxes extends BaseTest {
	
	@Test
	public void checkBoxes(){
		
		CheckboxesPage cb = new CheckboxesPage(driver);
		driver.get(Utils.BASE_URLS + "/checkboxes");
		
		//Test checks and unchecks checkboxes.
		//Test uses assertions to make sure boxes were properly checked and unchecked
		
		driver.manage().deleteAllCookies();
		sleepTest(1000);
		boolean check = cb.getFirstCheckbox().isSelected();
		if(cb.getFirstCheckbox().isSelected()) {
			assertEquals(true, check);
		}else {
			cb.getFirstCheckbox().click();
			assertEquals(false, check);
		}
		sleepTest(1000);
		boolean secondCheck = cb.getScondCheckbox().isSelected();
		if(cb.getScondCheckbox().isSelected()) {
			assertEquals(true, secondCheck);
		}else {
			cb.getScondCheckbox().click();
			assertEquals(false, secondCheck);
		}
		sleepTest(1000);
				
	}
	
	

}
