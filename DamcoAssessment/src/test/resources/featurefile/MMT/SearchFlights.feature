Feature: Flight Search
  As a user
  I want to search for flights
  So that I can find the second lowest price flight from Delhi to Mumbai

  Scenario: Search for flights and find the second lowest price
    Given user launches MMT website
    When user search for flights from "Delhi" to "Mumbai"
    And user sort the results by departure
    Then user should see the airline name and price of the second lowest price flight
