package StepDef;

import Pages.flightSearchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.IOException;


public class MMTTestStepDef {

    flightSearchPage page = new flightSearchPage();

    @Given("user launches MMT website")
    public void i_am_on_the_mmt_website() {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.makemytrip.com/flights/");


    }

    @When("user search for flights from {string} to {string}")
    public void searchFlights(String source, String destination) {
        page.enterSource(source);
        page.enterDestination(destination);
    }

    @When("user sort the results by departure")
    public void sortResultsByDeparture() {
        page.sortByDeparture();

        // Wait for the results to load (you may need to adjust the sleep duration)
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("user should see the airline name and price of the second lowest price flight")
    public void verifySecondLowestPriceFlight() {
        String airlineName = page.getAirlineName(1);
        String price = page.getPrice(1);

        Assert.assertNotNull("Airline name is null", airlineName);
        Assert.assertNotNull("Price is null", price);

        System.out.println("Airline: " + airlineName);
        System.out.println("Price: " + price);
    }

    }
