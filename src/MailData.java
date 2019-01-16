import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class MailData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.navigate().to("https://accounts.google.com/AccountChooser?service=mail&continue=https://mail.google.com/mail/");
		
		
		
		//login credential
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("Email_here@gmail.com");
		driver.findElement(By.xpath("//div[@id='identifierNext']")).click();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("password_here");
		driver.findElement(By.xpath("//div[@id='passwordNext']")).click();
		
		WebElement arrow=driver.findElement(By.xpath("//span[@class='T-Jo J-J5-Ji']//..//div[@class='G-asx T-I-J3 J-J5-Ji']"));
		WebElement unread=driver.findElement(By.xpath("//div[@class='SK AX']//div[@class='J-N' and @selector='unread']"));
		Actions a=new Actions(driver);
 		
		a.moveToElement(arrow).click().pause(1500).moveToElement(unread).click().build().perform();
		
		
		
		
		List<WebElement>checkbox=driver.findElements(By.xpath("//div[@role='checkbox']"));
		String pre="PhonePe";
		String mail;
		System.out.println(checkbox.size());
		
		for(int i=1; i<=checkbox.size(); i++)
		{
			
			WebElement tik=driver.findElement(By.xpath("//div[@role='checkbox']//..//..//..//tr["+i+"]//td[5]//div[2]"));
			WebElement subject=driver.findElement(By.xpath("//div[@role='checkbox']//..//..//..//tr["+i+"]//td[5]//div[2]//span//span"));
			System.out.println(subject.getText());
			
			
			if(pre.equals(subject.getText()))
			{
				Actions b=new Actions(driver);
				b.moveToElement(driver.findElement(By.xpath("//div[@role='checkbox']//..//..//..//tr[i]"))).click().build().perform();
				
				mail=driver.findElement(By.xpath("//td[@class='c2']//h3//span[@class='go']")).getText();
				System.out.println(mail.replace("<", "").replace(">", ""));
			}
		}
		
		

	}

}
