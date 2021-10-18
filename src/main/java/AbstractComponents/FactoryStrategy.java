package AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import PageComponents.MultiTrip;
import PageComponents.RoundTrip;

public class FactoryStrategy {

	WebDriver driver;
	By sectionElement= By.id("flightSearchContainer");
	


	public FactoryStrategy(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	//createStrategy is a Factory Method which creates object
	public SearchFlightAvail createStrategy(String strategyType)
	{
		if(strategyType.equalsIgnoreCase("multitrip"))
		{
			 return new MultiTrip(driver,sectionElement);
			
		}
		if(strategyType.equalsIgnoreCase("roundtrip"))
		{
			 return new RoundTrip(driver,sectionElement);
			
		}
			return null;
	}
}

