package end_to_end_testing;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class myTestCases extends parameter {

	String name_of_email[] = { "mo@yahoo.com", "ms@yahoo.com", "mv@yahoo.com", "mb@yahoo.com" };
	Random random = new Random();
	int index = random.nextInt(4);
	Faker faker = new Faker();
	String name = faker.name().fullName();

	@Test(priority = 1)
	public void title() {
		String acctuialtitle = driver.getTitle();
		assertprocess.assertEquals(acctuialtitle, expectedtitle);
		assertprocess.assertAll();
	}

	@Test(priority = 2)
	public void Register_user() {
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();

		Faker faker = new Faker();
		String name = faker.name().fullName();
		String firstname = faker.name().firstName();
		String lastname = faker.name().lastName();
		String address = faker.address().city();
		String address2 = faker.address().country();

		String name_of_email[] = { "mo@yahoo.com", "ms@yahoo.com", "mv@yahoo.com", "mb@yahoo.com" };
		Random random = new Random();
		int index = random.nextInt(4);
		int userid = (int) (Math.random() * 100);
		StringBuilder username = new StringBuilder();
		username.append(userid);
		String useridstring = username.toString();
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]")).sendKeys(name);
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]"))
				.sendKeys(name_of_email[index]);
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button")).click();

		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("1222324");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");
		Select sel1 = new Select(driver.findElement(By.xpath("//*[@id=\"days\"]")));
		sel1.selectByIndex(3);
		Select sel2 = new Select(driver.findElement(By.xpath("//*[@id=\"months\"]")));
		sel2.selectByIndex(3);
		Select sel3 = new Select(driver.findElement(By.xpath("//*[@id=\"years\"]")));
		sel3.selectByIndex(3);
		driver.findElement(By.xpath("//*[@id=\"newsletter\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"optin\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"first_name\"]")).sendKeys(firstname);
		driver.findElement(By.xpath("//*[@id=\"last_name\"]")).sendKeys(lastname);
		driver.findElement(By.xpath("//*[@id=\"company\"]")).sendKeys("tund application");
		driver.findElement(By.xpath("//*[@id=\"address1\"]")).sendKeys(address);
		driver.findElement(By.xpath("//*[@id=\"address2\"]")).sendKeys(address2);
		driver.findElement(By.xpath("//*[@id=\"country\"]")).click();
		List<WebElement> country = driver.findElements(By.className("option"));
		for (int i = 0; i < country.size(); i++) {
			country.get(i).click();
		}

		driver.findElement(By.xpath("//*[@id=\"state\"]")).sendKeys("united states");
		driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys(address2);
		driver.findElement(By.xpath("//*[@id=\"zipcode\"]")).sendKeys(useridstring);
		driver.findElement(By.xpath("//*[@id=\"mobile_number\"]")).sendKeys("0798720341");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/form/button")).click();
		String msg = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b")).getText();
		boolean checkmsgaccount = msg.contains("Account");
		assertprocess.assertEquals(checkmsgaccount, false);

		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a")).click();
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")).click();
		String msgdelete = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b")).getText();
		boolean checkdelete = msgdelete.contains("Deleted!");

		assertprocess.assertAll();

	}

	@Test(priority = 3)
	public void Login_User_with_correct_email_and_password() {
		driver.navigate().to(url);
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]"))
				.sendKeys(name_of_email[index]);
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")).sendKeys("1222324");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button")).click();
		String msglog = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a/b"))
				.getText();
		boolean checklog = msglog.contains("Lottie");
		assertprocess.assertEquals(checklog, false);
		assertprocess.assertAll();
	}

	@Test(priority = 4)
	public void Contac_tUs_Form() {
		driver.navigate().to("https://www.automationexercise.com/");
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[1]/input")).sendKeys(name);
		driver.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[2]/input")).sendKeys(name_of_email[index]);
		driver.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[3]/input")).sendKeys("help me");
		driver.findElement(By.xpath("//*[@id=\"message\"]")).sendKeys("mljskjdknksfsdfs");
		driver.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[5]/input")).sendKeys(filexpath);
		String mymsg = driver.findElement(By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/div[2]")).getText();
		boolean checkmsg = mymsg.contains("Success!");

		assertprocess.assertEquals(checkmsg, true);
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a")).click();

		assertprocess.assertAll();

	}

	@Test(priority = 5)
	public void Verify_Test_Cases_Page() {
		driver.navigate().to(url);
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[6]/a")).click();
		String expexted = "https://www.automationexercise.com/test_cases";
		String acctuialurl = driver.getCurrentUrl();
		assertprocess.assertEquals(acctuialurl, expexted);
		assertprocess.assertAll();

	}
	/*@Test(priority = 6)
	public void Verify_All_Products_and_product_detail_page()
	{
		driver.navigate().to(url);
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")).click();
		
		
		driver.findElement(By.tagName("a")).click();
		List<WebElement> details=driver.findElements(By.tagName("p"));
		assertprocess.assertEquals(details.contains(details), true);
		assertprocess.assertAll();
	}*/
	@Test(priority = 6)
	public void Verify_Subscription_in_home_page()
	{
		String name_of_email[] = { "mohammed@yahho.com", "ali@yahoo.com", "khaled@yahoo.com", "anas@yahoo.com" };
		Random random = new Random();
		int index = random.nextInt(4);
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,8500)");
		driver.findElement(By.id("susbscribe_email")).sendKeys(name_of_email[index]);
		driver.findElement(By.xpath("//*[@id=\"subscribe\"]")).click();
		String msg=driver.findElement(By.xpath("//*[@id=\"success-subscribe\"]")).getText();
		boolean checkmsg=msg.contains("subscribed!");
		assertprocess.assertEquals(checkmsg, true);
		assertprocess.assertAll();
	}
	@Test(priority = 7)
	public void Drawaer_image() {
		driver.navigate().to(url);
		List<WebElement> drawar = driver.findElements(By.className("girl"));
		boolean checkimage1 = drawar.get(0).getAttribute("src") == drawar.get(1).getAttribute("src");
		boolean checkimage2 = drawar.get(1).getAttribute("src") == drawar.get(2).getAttribute("src");
		boolean checkimage3 = drawar.get(2).getAttribute("src") == drawar.get(0).getAttribute("src");
		assertprocess.assertEquals(checkimage1, false);
		assertprocess.assertEquals(checkimage2, false);
		assertprocess.assertEquals(checkimage3, false);
		assertprocess.assertAll();

		
	}
	@Test(priority = 8)
	public void Verify_Subscription_in_Cart_page()
	{
		driver.navigate().to(url);
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,8500)");
		driver.findElement(By.id("susbscribe_email")).sendKeys(name_of_email[index]);
		driver.findElement(By.xpath("//*[@id=\"subscribe\"]")).click();
		String msg=driver.findElement(By.xpath("//*[@id=\"success-subscribe\"]")).getText();
		boolean checkmsg=msg.contains("subscribed!");
		assertprocess.assertEquals(checkmsg, true);
		assertprocess.assertAll();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
