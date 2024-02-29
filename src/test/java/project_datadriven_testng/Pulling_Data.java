package project_datadriven_testng;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pulling_Data {
	WebDriver driver;
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); 
		driver.get("https://demo.nopcommerce.com/");
	    driver.manage().window().maximize();
	    
	}
	@DataProvider(name="fetch")
    public Object[][] fetch() throws EncryptedDocumentException, IOException {
		Datadriven_Project data=new Datadriven_Project();
		Object[][] result = data.readfile();
		return result;		
	}
	
	@Test(dataProvider = "fetch", priority = 0)
	public void login_test(String Gender,String firstname,String lastname,String Day,String Month,String Year,String email,
			String company,String pass,String confirm) throws InterruptedException {
		driver.findElement(By.linkText("Register")).click();
		
		WebElement male=driver.findElement(By.id("gender-male"));
		WebElement female=driver.findElement(By.id("gender-female"));
		
		if(Gender.equals(male.getAttribute("value"))) {
			male.click();
		}
		else if(Gender.equals(female.getAttribute("value"))) {
			female.click();
		}
		
		WebElement Firstname=driver.findElement(By.id("FirstName"));
		Firstname.sendKeys(firstname);

		WebElement Lastname=driver.findElement(By.id("LastName"));
		Lastname.sendKeys(lastname);
		
		WebElement day=driver.findElement(By.name("DateOfBirthDay"));
		Select select=new Select(day);
		select.selectByVisibleText(Day);
		Thread.sleep(2000);
		
		WebElement month=driver.findElement(By.name("DateOfBirthMonth"));
		Select select1=new Select(month);
		select1.selectByVisibleText(Month);
		Thread.sleep(2000);
		
		WebElement year=driver.findElement(By.name("DateOfBirthYear"));
		Select select2=new Select(year);
		select2.selectByVisibleText(Year);
		Thread.sleep(2000);
		
		WebElement Email=driver.findElement(By.id("Email"));
		Email.sendKeys(email);
		WebElement Company=driver.findElement(By.id("Company"));
		Company.sendKeys(company);
		WebElement Password=driver.findElement(By.id("Password"));
		Password.sendKeys(pass);
		WebElement Confirm_Password=driver.findElement(By.id("ConfirmPassword"));
		Confirm_Password.sendKeys(confirm);
		Thread.sleep(2000);
		driver.findElement(By.id("register-button")).click();
		Thread.sleep(2000);
			
	}
	@Test(priority = 1)
	public void login() throws InterruptedException {
		driver.findElement(By.linkText("Log in")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("Email")).sendKeys("meghaaspk@gmail.com");
		Thread.sleep(2000);

		driver.findElement(By.id("Password")).sendKeys("Meghana@pk");
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]")).click();
		Thread.sleep(2000);

				
		//Digital Downloads
		driver.findElement(By.linkText("Digital downloads")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Science & Faith")).click();
		
		//Send a Friend a mail		
		driver.findElement(By.className("email-a-friend")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("FriendEmail")).sendKeys("pavan@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.id("PersonalMessage")).sendKeys("Hi pk");
		Thread.sleep(1000);
		driver.findElement(By.name("send-email")).click();
		Thread.sleep(1000);
		
		//Navigate back
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		
	 
		//Back to addtoCart
		driver.findElement(By.id("add-to-cart-button-36")).click();
		Thread.sleep(2000);
		
		//Click Books
		driver.findElement(By.linkText("Books")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("First Prize Pies")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("add-to-cart-button-38")).click();
		
		
//       shoppingcart
		driver.findElement(By.linkText("Shopping cart")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("updatecart")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("termsofservice")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("checkout")).click();
		
			
	}
	@AfterTest
	public void teardown() {
		driver.quit();
		
	}
	

}
