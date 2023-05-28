package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class flightSearchPage {
    private WebDriver driver;

    public void FlightSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterSource(String source) {
        WebElement sourceInput = driver.findElement(By.id("fromCity"));
        sourceInput.clear();
        sourceInput.sendKeys(source);
        driver.findElement(By.xpath("//input[@placeholder='From']//parent::label/following-sibling::div//ul/li[1]")).click();
    }

    public void enterDestination(String destination) {
        WebElement destinationInput = driver.findElement(By.id("toCity"));
        destinationInput.clear();
        destinationInput.sendKeys(destination);
        driver.findElement(By.xpath("//input[@placeholder='To']//parent::label/following-sibling::div//ul/li[1]")).click();
    }

    public void sortByDeparture() {

        WebElement sortDropdown = driver.findElement(By.xpath("//span[text()='Sort By']"));
        sortDropdown.click();
        WebElement sortByDeparture = driver.findElement(By.xpath("//ul[@role='listbox']//li[@data-cy='sorting:last-child']"));
        sortByDeparture.click();
    }

    public String getAirlineName(int index) {
        List<WebElement> flightList = driver.findElements(By.xpath("//span[contains(@class,'airways-name')]"));
        if (index >= 0 && index < flightList.size()) {
            return flightList.get(index).getText();
        }
        return null;
    }

    public String getPrice(int index) {
        List<WebElement> priceList = driver.findElements(By.xpath("//div[@class='priceSection']//span[@class='actual-price']"));
        if (index >= 0 && index < priceList.size()) {
            return priceList.get(index).getText();
        }
        return null;
    }
}
