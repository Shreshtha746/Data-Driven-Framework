package testcases;



import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;

/* for registration the user, I am taking email and password through excel sheet
 * using Data provider. I have created an excel sheet with 2 columns, one as email
 * and other as password, giving the values. 
 * I have created an ExcelReader file in my utility package, I have taken that file
 * from some other project.
 */


public class RegisterTest extends TestBase {

	@Test(dataProvider="getData")
	public void register(String email, String password)
	{
		//Here, I have created two variables, email and password which I am calling 
		//through excel sheet.
		driver.findElement(By.xpath(OR.getProperty("email"))).sendKeys(email);
		driver.findElement(By.xpath(OR.getProperty("password"))).sendKeys(password);
		driver.findElement(By.xpath(OR.getProperty("registerBtn"))).click();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		String sheetName = "RegisterTest"; //was getting NegativeArraySizeException because my sheetName variable and sheetName in excel sheet wasn't same
		//also I have kept the sheet name same as the class name.
		/*It is actually going to read the row count and the column count. 
		 * And then it's going to add it into object 2D array for rows and columns
		 */
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		Object[][] data = new Object[rows-1][cols];
		//have kept row number as 2 as the data provider, it will start reading the data from
		//row 2, as in my excel sheet the data starts from row 2.
		for(int rowNum = 2; rowNum <= rows; rowNum++) 
		{
			for(int colNum = 0; colNum < cols; colNum++) //column starts from 0
			{
				//here data will be stored in the form of data[0][0] for first data
				//using excel method get cell data which will get the sheet name, column and row name.
				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
			}
		}
		return data;
		
	}
}