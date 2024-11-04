package EST;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;

public class TestDemo {
	@Test
	public void start() {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://hbl-ncapp-admin-panel-dev.estuary.solutions/login");

		By emailBy = By.id("email");
		By passwordlBy = By.id("password");
		By buttonBy = By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div/div[1]/div/div/form/div[4]");

		driver.findElement(emailBy).sendKeys("quetran.nguyen@estuary.solutions");
		driver.findElement(passwordlBy).sendKeys("123456aA@");
		driver.findElement(buttonBy).click();

		By otpBy1 = By.xpath("(//div[contains(@role,'button')])[1]");
		By otpBy2 = By.xpath("(//div[contains(@role,'button')])[2]");
		By otpBy3 = By.xpath("(//div[contains(@role,'button')])[3]");
		By otpBy4 = By.xpath("(//div[contains(@role,'button')])[4]");
		By otpBy5 = By.xpath("(//div[contains(@role,'button')])[5]");
		By otpBy6 = By.xpath("(//div[contains(@role,'button')])[6]");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// OTP Page

		Actions action = new Actions(driver);
		By otpbtnBy = By.cssSelector(".enter-otp > button");

		action.sendKeys(driver.findElement(otpBy1), Keys.NUMPAD0).build().perform();
		action.sendKeys(driver.findElement(otpBy2), Keys.NUMPAD0).build().perform();
		action.sendKeys(driver.findElement(otpBy3), Keys.NUMPAD0).build().perform();
		action.sendKeys(driver.findElement(otpBy4), Keys.NUMPAD0).build().perform();
		action.sendKeys(driver.findElement(otpBy5), Keys.NUMPAD0).build().perform();
		action.sendKeys(driver.findElement(otpBy6), Keys.NUMPAD0).build().perform();

		driver.findElement(By.cssSelector(".enter-otp > button")).isEnabled();
		driver.findElement(otpbtnBy).click();

		By itemUser = By.xpath("(//span[normalize-space()='User Details'])[1]");
		By itemNCO = By.xpath("(//span[@class='ant-menu-title-content'])[4]");
		By searchID = By.id("herbalife_id");
		By searchBtn = By.xpath("(//button[@type='submit'])[1]");
		By resetBtn = By.xpath("(//button[@type='button'])[1]");
		By itemNCC = By.xpath("(//span[@class='ant-menu-title-content'])[5]");

		driver.findElement(itemUser).click();
		driver.findElement(itemNCO).click();
		driver.findElement(searchID).sendKeys("hs");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(searchBtn).click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(resetBtn).click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			driver.findElement(itemNCC).click();

		}
	}
}
