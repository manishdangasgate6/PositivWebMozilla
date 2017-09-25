package PositivWebMozilla.PositivWebMozilla;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

public class PositivWebMozillaTest {

	// WebDriver driver;
	String baseUrl, nodeURL;

	

	
	// Firefox Windows
	public String st = System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
	public WebDriver driver = new FirefoxDriver();

	
	
	// @BeforeTest
	// public void setUp() throws MalformedURLException {
	// //baseUrl = "https://stage1.tascportal.org";
	// nodeURL = "http://10.1.0.144:5556/wd/hub";
	// DesiredCapabilities capability = DesiredCapabilities.chrome();
	// capability.setPlatform(Platform.WINDOWS);
	// driver = new RemoteWebDriver(new URL(nodeURL), capability);
	// driver.manage().window().maximize();
	// }

	@BeforeTest
	public void Before() {

		driver.manage().window().maximize();
	}

	// Linux firefox
	// public String st = System.setProperty("webdriver.gecko.driver",
	// "/home/mpatil/geckodriver");
	// public WebDriver driver = new FirefoxDriver();

	@Test(priority = 1)
	public void CheckApp_Status() {

		driver.get("http://positivradio.test.gate6.com/web/");
		driver.findElement(By.className("facebook"));
		System.out.print("Application is working");

	}

	@Test(priority = 2)
	public void BlankEmail() {

		driver.get("http://positivradio.test.gate6.com/web/register");
		driver.findElement(By.name("fullName")).sendKeys("Manish Dangas");
		driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.name("password")).sendKeys("Gate6@123");
		driver.findElement(By.xpath("//div[4]/div/div/button")).click();
		String URL = driver.getCurrentUrl();

		Assert.assertEquals(URL, "http://positivradio.test.gate6.com/web/register");

	}

	//
	@Test(priority = 3)
	public void BlankFullName() {

		driver.get("http://positivradio.test.gate6.com/web/register");
		driver.findElement(By.name("fullName")).sendKeys("");
		driver.findElement(By.id("email")).sendKeys("manish.dangas@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Gate6@123");
		driver.findElement(By.xpath("//div[4]/div/div/button")).click();
		String URL = driver.getCurrentUrl();

		Assert.assertEquals(URL, "http://positivradio.test.gate6.com/web/register");

	}

	@Test(priority = 4)
	public void InvalidEmail() {

		driver.get("http://positivradio.test.gate6.com/web/register");
		driver.findElement(By.name("fullName")).sendKeys("Manish Dangas");
		driver.findElement(By.id("email")).sendKeys("manish@.com");
		driver.findElement(By.name("password")).sendKeys("Gate6@123");
		driver.findElement(By.xpath("//div[4]/div/div/button")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("@.com");
		driver.findElement(By.name("password")).sendKeys("Gate6@123");
		driver.findElement(By.xpath("//div[4]/div/div/button")).click();

	}

	@Test(priority = 5)
	public void InvalidPassword() {

		driver.get("http://positivradio.test.gate6.com/web/register");
		driver.findElement(By.name("fullName")).sendKeys("Manish Dangas");
		driver.findElement(By.id("email")).sendKeys("manish.dangas@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Gate2");
		driver.findElement(By.xpath("//div[4]/div/div/button")).click();
		String URL = driver.getCurrentUrl();

		Assert.assertEquals(URL, "http://positivradio.test.gate6.com/web/register");

	}

	@Test(priority = 6)
	public void ValidSignup() {

		driver.get("http://positivradio.test.gate6.com/web/register");
		driver.findElement(By.name("fullName")).sendKeys("Manish Dangas");
		driver.findElement(By.id("email")).sendKeys("manish.danga1212s@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Gate6@123");
		driver.findElement(By.xpath("//div[4]/div/div/button")).click();
		String URL = driver.getCurrentUrl();

		Assert.assertEquals(URL, "http://positivradio.test.gate6.com/web/register");

	}

//	@Test(priority = 7)
//	public void FaceBookSignup() throws InterruptedException {
//
//		driver.get("http://positivradio.test.gate6.com/web/register");
//		driver.findElement(By.className("facebook")).click();
//
//		String parentWindowHandler = driver.getWindowHandle(); // Store your parent
//		// window
//		String subWindowHandler = null;
//
//		Set<String> handles = driver.getWindowHandles(); // get all window handles
//		Iterator<String> iterator = handles.iterator();
//		while (iterator.hasNext()) {
//			subWindowHandler = iterator.next();
//		}
//		driver.switchTo().window(subWindowHandler); // switch to popup window
//
//		Thread.sleep(5000);
//		String PopURL = driver.getCurrentUrl();
//		System.out.println("TEst" + PopURL);
//		// Now you are in the popup window, perform necessary actions here
//
//		driver.findElement(By.id("email")).sendKeys("manish.dangas@gate6.com");
//		driver.findElement(By.id("pass")).sendKeys("Gate6@321");
//		driver.findElement(By.name("login")).click();
//
//		driver.switchTo().window(parentWindowHandler);
//
//	}
//
//	@Test(priority = 8)
//	public void GoogleSignup() throws InterruptedException {
//
//		driver.get("http://positivradio.test.gate6.com/web/register");
//		driver.findElement(By.cssSelector("button.google")).click();
//
//		String parentWindowHandler = driver.getWindowHandle(); // Store your parent
//		// window
//		String subWindowHandler = null;
//		//
//		Set<String> handles = driver.getWindowHandles(); // get all window handles
//		Iterator<String> iterator = handles.iterator();
//		while (iterator.hasNext()) {
//			subWindowHandler = iterator.next();
//		}
//		driver.switchTo().window(subWindowHandler); // switch to popup window
//
//		Thread.sleep(5000);
//		String PopURL = driver.getCurrentUrl();
//		System.out.println("TEst" + PopURL);
//		// Now you are in the popup window, perform necessary actions here
//
//		driver.findElement(By.id("identifierId")).sendKeys("gate6.info@gate6.com");
//		driver.findElement(By.xpath(".//*[@id='identifierNext']/content/span")).click();
//		Thread.sleep(4000);
//		driver.findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input")).sendKeys("Goole2010A!!");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath(".//*[@id='passwordNext']/content/span")).click();
//
//		driver.switchTo().window(parentWindowHandler);
//
//	}

	@Test(priority = 9)
	public void Invalid_EmailLogin() {

		driver.get("http://positivradio.test.gate6.com/web/login");
		driver.findElement(By.name("email")).sendKeys("manish.dangas@gate62.com");
		driver.findElement(By.name("password")).sendKeys("gate6@123");
		driver.findElement(By.cssSelector("button.btn.custom-btn")).click();
		String URL = driver.getCurrentUrl();

		Assert.assertEquals(URL, "http://positivradio.test.gate6.com/web/login");

	}

	@Test(priority = 10)
	public void Invalid_PasswordLogin() {

		driver.get("http://positivradio.test.gate6.com/web/login");
		driver.findElement(By.name("email")).sendKeys("manish.dangas@gate6.com");
		driver.findElement(By.name("password")).sendKeys("gatesix#12");
		driver.findElement(By.cssSelector("button.btn.custom-btn")).click();
		String URL = driver.getCurrentUrl();

		Assert.assertEquals(URL, "http://positivradio.test.gate6.com/web/login");

	}

	@Test(priority = 11)
	public void Valid_Login() throws InterruptedException {

		driver.get("http://positivradio.test.gate6.com/web/login");
		driver.findElement(By.name("email")).sendKeys("manish.dangas@gate6.com");
		driver.findElement(By.name("password")).sendKeys("Gate6@123");
		driver.findElement(By.cssSelector("button.btn.custom-btn")).click();
		Thread.sleep(2000);

		String URL = driver.getCurrentUrl();

		Assert.assertEquals(URL, "http://positivradio.test.gate6.com/web/");

	}

	@Test(priority = 12)
	public void Logout_Test() throws InterruptedException

	{
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("button.btn-signout.radius8px")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("button.btn.default")).click();
	}

	@Test(priority = 13)
	public void Forgot_Password_with_registerd_user() throws InterruptedException {
		Thread.sleep(5000);
		driver.get("http://positivradio.test.gate6.com/web/sendotp");
		driver.findElement(By.name("email")).sendKeys("test12@gate6.com");
		driver.findElement(By.cssSelector("button.btn.custom-btn")).click();

		Thread.sleep(10000);
		String URL_OTP = driver.getCurrentUrl();

		Assert.assertEquals("http://positivradio.test.gate6.com/web/login", URL_OTP);

	}

	@Test(priority = 14)
	public void Forgot_Password_with_invalid__user() throws InterruptedException {
		Thread.sleep(5000);
		driver.get("http://positivradio.test.gate6.com/web/sendotp");
		driver.findElement(By.name("email")).sendKeys("t12est12@gate6.com");
		driver.findElement(By.cssSelector("button.btn.custom-btn")).click();

		Thread.sleep(10000);
		String URL_OTP = driver.getCurrentUrl();

		Assert.assertEquals("http://positivradio.test.gate6.com/web/sendotp", URL_OTP);

	}

	@Test(priority = 15)
	public void Edit_profile() throws InterruptedException, FindFailed {
		Thread.sleep(4000);
		driver.get("http://positivradio.test.gate6.com/web/login");
		driver.findElement(By.name("email")).sendKeys("manish.dangas@gate6.com");
		driver.findElement(By.name("password")).sendKeys("Gate6@123");
		driver.findElement(By.cssSelector("button.btn.custom-btn")).click();
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("button.btn")).click();

		Thread.sleep(4000);
		WebElement FullName = driver.findElement(By.name("fullName"));
		FullName.clear();
		FullName.sendKeys("Test account");
		WebElement Email = driver.findElement(By.name("email"));
		Email.clear();
		Email.sendKeys("manish.dangas@gate6.com");
		driver.findElement(By.xpath("//div[@class='action-button']//button[.='Save']")).click();

		Thread.sleep(10000);
		WebElement content = driver.findElement(By.xpath("//div[@class='p-b5']//strong[text()='Test account']"));
		String print = content.getText();

		Assert.assertEquals(print, "Test account");

	}

	@Test(priority = 16)
	public void changePassword() throws InterruptedException, FindFailed {

		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@class='action-button']//*[text()='Change Password']")).click();
		WebElement oldPassword = driver.findElement(By.name("oldPassword"));
		oldPassword.sendKeys("Gate6@123");
		WebElement NewPassword = driver.findElement(By.name("password"));
		NewPassword.sendKeys("Gate6@123");
		WebElement ConfirmPassword = driver.findElement(By.name("confirmPassword"));
		ConfirmPassword.sendKeys("Gate6@123");
		driver.findElement(By.xpath("//div[@class='action-button']//button[.='Save']")).click();

		// Screen s = new Screen();
		//
		// s.find("C:/Users/Owner/Desktop/PasswardSaved.png");

	}

	@Test(priority = 17)
	public void updateCard() throws InterruptedException, FindFailed {

		Thread.sleep(4000);
		driver.findElement(By.cssSelector("button.btn")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("updateCC")).click();

		WebElement nameCard = driver.findElement(By.name("nameOnCard"));
		nameCard.sendKeys("Gate6");
		WebElement cardNumber = driver.findElement(By.name("cardNumber"));
		cardNumber.sendKeys("4111111111111111");
		WebElement cardExpMonth = driver.findElement(By.name("cardExpMonth"));
		cardExpMonth.sendKeys("12");
		WebElement cardExpYear = driver.findElement(By.name("cardExpYear"));
		cardExpYear.sendKeys("19");
		WebElement cardCvv = driver.findElement(By.name("cardCvv"));
		cardCvv.sendKeys("123");
		WebElement zipCode = driver.findElement(By.name("zipCode"));
		zipCode.sendKeys("11252");
		Thread.sleep(4000);
		driver.findElement(By.id("updateCC")).click();

		Thread.sleep(4000);
		WebElement content = driver
				.findElement(By.xpath("//div[@class='col-md-5 text-center']//strong[text()='EXP  12/19']"));
		String print = content.getText();
		System.out.println(print);

		Assert.assertEquals(print, "EXP 12/19");

	}

	@AfterTest
	public void afterTest() {

		// driver.quit();
	}
}