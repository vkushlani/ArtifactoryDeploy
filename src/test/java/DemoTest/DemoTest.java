package DemoTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageComponents.MultiTrip;
import PageComponents.RoundTrip;
import PageObjects.TravelHomePage;

public class DemoTest extends BaseTest {
	WebDriver driver;
	TravelHomePage travelHomePage;
	
	@BeforeTest
	public void setUp() {
		driver = initializeDriver();
		travelHomePage = new TravelHomePage(driver);

	}

	@Test(dataProvider = "getData")
	public void flightTest(HashMap<String, String> reservationDetails) {

		travelHomePage.goTo();
		driver.manage().window().maximize();
		System.out.println(travelHomePage.getFooterNav().getFlightAttribute());// gets FlightAttribute for 'Flights'
																				// link in footer section
		System.out.println(travelHomePage.getNavigationBar().getFlightAttribute());// gets FlightAttribute for 'Flights'
																					// link in Menu/Navigation Bar
																					// section
		System.out.println(travelHomePage.getFooterNav().getLinkCount());// gets link count in footer section

		// MultiTrip multiTrip=new MultiTrip() --> so return type for this can be
		// SearchFlightAvail beacuse MultiTrip() uses SearchFlightAvail interface
		// return type in setBookingStrategy can be SearchFlightAvail searchFlightAvail
		// WebDriver driver= new ChromeDriver() -->here WebDriver is an interface which
		// for ChromeDriver() class. This same interface also can be used for
		// FirefoxDriver() class. In same way
		// we are using SearchFlightAvail interface for MultiTrip() or RoundTrip()
		// classes
		// Return type is common i.e.SearchFlightAvail
		// travelHomePage.setBookingStrategy(new MultiTrip());

		// travelHomePage.setBookingStrategy(new RoundTrip(driver,sectionElement));

		// travelHomePage.setBookingStrategy(new MultiTrip(driver,sectionElement));
		
		//Jfrog - Create a Maven repository in jFrog, add settings.xml file to .m2 folder and add 'snapshot repository' dependency in .pom file which has the path given where the jar file of this project will be deployed. Run 'mvn deploy' which will then deploy this project as jar file to jFrog Artifactory

		travelHomePage.setBookingStrategy("multitrip");

		travelHomePage.checkAvail(reservationDetails);

	}

	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
		//System.out.println(System.getProperty("user.dir")+"\\src\\test\\java\\DataLoads\\reservationDetails.json");
		List<HashMap<String, String>> l = getJsonData(System.getProperty("user.dir")+"\\src\\test\\java\\DataLoads\\reservationDetails.json");
		
		return new Object[][] { { l.get(0) },

				{ l.get(1) } };

	}

}
