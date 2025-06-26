package utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class SeleniumEventHelpers{
	
	static WebDriver driver;
	
	public SeleniumEventHelpers(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public static void DoClick(WebElement ele)
	{
		ele.click();
	}
	
	public static void MouseHover(WebElement ele)
	{
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
	}
	
	public static void DoubleClick(WebElement ele)
	{
		Actions act = new Actions(driver);
		act.doubleClick(ele).perform();
	}
	
	public static void RightClick(WebElement ele)
	{
		Actions act = new Actions(driver);
		act.contextClick(ele).perform();
	}
	
	public static void ScrollTo(WebDriver driver, WebElement element )
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	
	}
	
	

}
