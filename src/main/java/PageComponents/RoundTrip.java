package PageComponents;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import AbstractComponents.AbstractComponent;
import AbstractComponents.SearchFlightAvail;

public class RoundTrip extends AbstractComponent implements SearchFlightAvail{
	
	public RoundTrip(WebDriver driver, By sectionElement) {
		super(driver, sectionElement);
		// TODO Auto-generated constructor stub
	}

	private By rdoBtn = By.id("ctl00_mainContent_rbtnl_Trip_1");
	private By fromCity = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
	private By toCity = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
	private By chckbox = By.id("ctl00_mainContent_chk_IndArm");
	private By searchBtn=By.id("ctl00_mainContent_btn_FindFlights");

	@Override
	public void checkAvail(HashMap<String, String> reservationDetails) {
		// TODO Auto-generated method stub
		
		System.out.println("Inside Round Trip");
		findElement(rdoBtn).click();
		selectOriginCity(reservationDetails.get("origin"));
		selectDestinationCity(reservationDetails.get("destination"));
		findElement(chckbox).click();
		findElement(searchBtn).click();
	}
	
	public void selectOriginCity(String origin)
	{
		findElement(fromCity).click();
		findElement(By.xpath(" //a[@value='"+origin+"']")).click();
	}

	public void selectDestinationCity(String destination)
	{
		findElement(toCity).click();
		findElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
	}
}
