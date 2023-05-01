Feature: Build car as per requirements

  Scenario: Validate A Class models price are between £15,000 and £60,000
    Given the user is on Mercedes-benz United Kingdom market
    And Under “Our Models” - Select “Model: Hatchbacks”
    And Mouse over the “A Class” model available and proceed to “Build your car”
    And Filter by Fuel type “Diesel”
    And Take and save a screenshot of the results
    When Save the value “£” of the highest and lowest price results in a text file
    Then Validate A Class models price are between 15000 and 60000