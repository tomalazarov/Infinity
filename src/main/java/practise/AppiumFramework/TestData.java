package practise.AppiumFramework;

import org.testng.annotations.DataProvider;

public class TestData {
	
	@DataProvider(name="InputData")
	public Object[][] getDataforEditField() {
		//sets of data, "hello", "!@#$%"
		Object[][] obj = new Object[][] {
			{"hello"}, {"!@#$%"}
		};
		
		return obj;
	}
}
