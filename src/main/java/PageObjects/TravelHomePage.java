package PageObjects;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import AbstractComponents.FactoryStrategy;
import AbstractComponents.SearchFlightAvail;
import PageComponents.FooterNav;
import PageComponents.NavigationBar;

public class TravelHomePage {

	//sectionElement below gives whole footer section of the page
	By sectionElement = By.id("traveller-home");
	By footerNavSectionElement = By.id("buttons");
	
	SearchFlightAvail searchFlightAvail;
	 
	
	WebDriver driver;
	
	public TravelHomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	}
	
	public NavigationBar getNavigationBar()
	{
		return new NavigationBar(driver,footerNavSectionElement);
	}
	
	public FooterNav getFooterNav()
	{
		return new FooterNav(driver,sectionElement);
	}
	
	public void setBookingStrategy(String strategyType)
	{
		FactoryStrategy factoryStrategy = new FactoryStrategy(driver);
		searchFlightAvail= factoryStrategy.createStrategy(strategyType);
		
		this.searchFlightAvail=searchFlightAvail;
	}

	public void checkAvail(HashMap<String,String> reservationDetails)
	{
		
		searchFlightAvail.checkAvail(reservationDetails);
	}
	
}
