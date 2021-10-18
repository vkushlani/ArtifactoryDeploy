package PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import AbstractComponents.AbstractComponent;

public class NavigationBar extends AbstractComponent{

	By flights = By.cssSelector("[title*='Flights']");

	public NavigationBar(WebDriver driver, By footerNavSectionElement) {
		// TODO Auto-generated constructor stub
		super(driver, footerNavSectionElement);
	}
	
	public String getFlightAttribute()
	{
		
		//Design and create a customized findElement
		
		return findElement(flights).getAttribute("class");
		
		//Below will click on first available flights link on the page and not on flights link present in footer section
		//driver.findElement(flights).click();
	}

}
