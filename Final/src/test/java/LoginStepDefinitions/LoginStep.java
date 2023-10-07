package LoginStepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep{
	private WebDriver driver;
	String username;
	String password;
	@Given("I navigate to the test login page")
	public void LoginPage() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Arjun/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        }
	@When("User enters sheetname and rownumber")
	public void UsernameAndPasswordFromExcel() {
		String excelFilePath = "C:\\Loginread.xlsx";
		int sheetIndex = 0;
		try (FileInputStream fis = new FileInputStream(excelFilePath);
				XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
			XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
			XSSFRow row = sheet.getRow(1);
			username = row.getCell(0).getStringCellValue();
			password = row.getCell(1).getStringCellValue();
			}
		catch (IOException e) {
			e.printStackTrace();
			}
		}
	@And("I click the test login button")
	public void LoginButton() throws InterruptedException{
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(username);

		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
		Thread.sleep(2000);
		}
	@Then("I should be logged into test")
	public void LoggedInToTest() {
		System.out.println("Test successful");
		driver.close();
		}
	}



