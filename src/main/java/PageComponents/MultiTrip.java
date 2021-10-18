package PageComponents;

import java.util.HashMap;
import java.util.function.Consumer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import AbstractComponents.AbstractComponent;
import AbstractComponents.SearchFlightAvail;

public class MultiTrip extends AbstractComponent implements SearchFlightAvail{

	public MultiTrip(WebDriver driver, By sectionElement) {
		super(driver, sectionElement);
		// TODO Auto-generated constructor stub
	}

	private By multicityrdoBtn = By.id("ctl00_mainContent_rbtnl_Trip_2");
	private By fromCity = By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']");
	private By toCity = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
	private By fromCity2 = By.id("ctl00_mainContent_ddl_originStation2_CTXT");
	private By toCity2 = By.id("ctl00_mainContent_ddl_destinationStation2_CTXT");
	private By chckbox = By.id("ctl00_mainContent_chk_IndArm");
	private By searchBtn=By.id("ctl00_mainContent_btn_FindFlights");
	private By modalPopup=By.id("MultiCityModelAlert");
	
	@Override
	public void checkAvail(HashMap<String, String> reservationDetails) {
		// TODO Auto-generated method stub
		
		
		//Execute Around Method and make state ready for next functions to execute
		makeStateReady(s->selectOriginCity(reservationDetails.get("origin")));
		
		selectDestinationCity(reservationDetails.get("destination"));
		selectOriginCity2(reservationDetails.get("origin2"));
		selectDestinationCity2(reservationDetails.get("destination2"));
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
	
	public void selectOriginCity2(String origin2)
	{
		findElement(fromCity2).click();
		findElement(By.xpath("(//a[@value='"+origin2+"'])[3]")).click();
	}

	public void selectDestinationCity2(String destination2)
	{
		findElement(toCity2).click();
		findElement(By.xpath("(//a[@value='"+destination2+"'])[4]")).click();
	}
	
	public void makeStateReady(Consumer<MultiTrip> consumer)
	{
		//Below 3 lines are common and pre-requisites. These will be executed first as these are prerequisite
		//After below lines are executed control goes to execute around statement(makeStateReady(s->selectOriginCity(origin))) to continue executing next set of code.functions 
		System.out.println("Inside Multi Trip");
		findElement(multicityrdoBtn).click();
		findElement(modalPopup).click();
		//waitForElementToDisappear
		consumer.accept(this);
		System.out.println("Test completed");
	}
	
}
