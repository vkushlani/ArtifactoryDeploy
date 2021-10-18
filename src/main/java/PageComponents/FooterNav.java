package PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import AbstractComponents.AbstractComponent;

public class FooterNav extends AbstractComponent {

	WebDriver driver;
	By flights = By.cssSelector("[title*='Flights']");
	By links = By.cssSelector("a");
	public FooterNav(WebDriver driver, By sectionElement) {
		// TODO Auto-generated constructor stub
		
		super(driver,sectionElement);
	}
	
	public String getFlightAttribute()
	{
		
		//Design and create a customized findElement
		
		return findElement(flights).getAttribute("class");
		
		//Below will click on first available flights link on the page and not on flights link present in footer section
		//driver.findElement(flights).click();
	}
	
	public int getLinkCount()
	{
		
		//Design and create a customized findElement
		
		return findElements(links).size();
		
	}

}
