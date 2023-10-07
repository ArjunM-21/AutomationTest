package stepDefinitionsSteps;

import  org.junit.Assert;
import org.testng.asserts.SoftAssert;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
public class FinalTestSteps {
	
	
	WebDriver driver;
	@Given("User is on Home page")
	public void user_is_on_Home_Page() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","C:/Users/Arjun/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}
	@Then("Getting the title of webpage")
	public void getting_the_title_of_webpage() throws InterruptedException{
		String actualTitle = driver.getTitle();
		String expectedTitle = "nopCommerce demo store";
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("Assert passed");
		Thread.sleep(2000);
		}
	@And("Getting the current url of the website")
	public void getting_url() throws InterruptedException{
		SoftAssert softAssert = new SoftAssert();
		String actUrl = driver.getCurrentUrl();
		String expUrl = "https://demo.nopcommerce.com/";
		softAssert.assertEquals(actUrl, expUrl);
		WebElement web = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[3]/div/div[2]/h2/a"));
		String actText = web.getText();
		String expText = "HTC One M8 Android L 5.0 Lollipop";
		softAssert.assertEquals(actText,expText);
		softAssert.assertAll();
	}
	@When("User searches for Speakers")
	public void searches() throws InterruptedException {
		driver.findElement(By.id("small-searchterms")).sendKeys("Portable Sound Speakers");
		driver.findElement(By.xpath("//*[@id=\"small-search-box-form\"]/button")).click();
		Thread.sleep(2000);
		}
	@Then("Selects the item to buy")
	public void choose_to_buy_the_first_item() throws InterruptedException {
		WebElement items = driver.findElement(By.linkText("Portable Sound Speakers"));
		items.click();
		Thread.sleep(2000);
			  
		driver.findElement(By.xpath("//*[@id=\"product_enteredQuantity_23\"]")).sendKeys("");
		
		WebElement addToCart = driver.findElement(By.xpath("//*[@id=\"add-to-cart-button-23\"]"));
		addToCart.click();
		Thread.sleep(2000);
		}
	@And("The product is added to cart")
	public void added() throws InterruptedException{
		Boolean Display = driver.findElement(By.xpath("//*[@id=\"bar-notification\"]")).isDisplayed();
		System.out.println("Notification displayed is : " + Display);
		Thread.sleep(2000);
	}
	@And("Checkout from cart")
	public void checkout_cart() throws InterruptedException {
		System.out.println("Product is added to cart");
		WebElement cart = driver.findElement(By.cssSelector("#topcartlink > a"));
		cart.click();
		Thread.sleep(2000);
		
		Select wrapping = new Select(driver.findElement(By.id("checkout_attribute_1")));
		wrapping.selectByValue("2");
		
		WebElement CheckBox = driver.findElement(By.id("termsofservice"));
		boolean isSelected = CheckBox.isSelected();
		if(isSelected == false) {
			CheckBox.click();
		}
		WebElement continueToCheckout = driver.findElement(By.id("checkout"));
		continueToCheckout.click();
		}
	@And("Enters details on checkout as guest page")
	public void details() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[1]/div[3]/button[1]")).click();
		Thread.sleep(5000);
		
		WebElement firstName = driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_FirstName\"]"));
		firstName.sendKeys("Arjun");
		
		WebElement lastName = driver.findElement(By.cssSelector("#BillingNewAddress_LastName"));
		lastName.sendKeys("M");
		
		WebElement emailAddress = driver.findElement(By.id("BillingNewAddress_Email"));
		emailAddress.sendKeys("abc@gmail.com");
	
		Select country = new Select(driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_CountryId\"]")));
		country.selectByValue("133");
		Thread.sleep(2000);
		
		WebElement city = driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_City\"]"));
		city.sendKeys("Chennai");
		
		WebElement address = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[1]/div[2]/form/div/div/div[2]/div/div/div[8]/input"));
		address.sendKeys("No.20,20th street,Porur");
		
		WebElement pincode = driver.findElement(By.cssSelector("#BillingNewAddress_ZipPostalCode"));
		pincode.sendKeys("600001");
		
		Thread.sleep(2000);
		WebElement phone = driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_PhoneNumber\"]"));
		phone.sendKeys("9876543210");
		
		WebElement contbtn = driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/button[4]"));
		contbtn.click();
		
		WebElement shipping = driver.findElement(By.xpath("//*[@id=\"shippingoption_2\"]"));
		shipping.isEnabled();
		System.out.println("Radio button is enabled for air shipping");
	    driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button")).click();
		System.out.println("The test is done till the payment method");
	    driver.close();
	
		}
}

		


	

