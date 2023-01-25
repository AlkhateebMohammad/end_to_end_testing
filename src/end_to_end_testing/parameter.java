package end_to_end_testing;

import java.time.Duration;

import org.bouncycastle.crypto.agreement.srp.SRP6Client;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class parameter {
	
	public WebDriver driver;
	String url="https://www.automationexercise.com/";
	String expectedtitle="Automation Exercise";
	SoftAssert assertprocess=new SoftAssert();
	String filexpath="C:\\Users\\user\\.p2\\pool\\plugins\\org.testng_7.4.0.r202105021533.jar";
	
	@BeforeTest()
	public void browzer()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		
		
		
	}
	

}
