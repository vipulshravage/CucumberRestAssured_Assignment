Feature: Validate the POST call with Celsius to Fahrenheit conversion Scenarios

  @assignment1
  Scenario Outline: Do User POST call validation
    Given user provide the Celsius value "<celsius>"
    Then user create a conversion
    When user send a post call "<url>"
    And user see the status code as "<status_code>"
    And user see the result as CelsiustoFerhenheit "<result>"

    Examples:
      |celsius|url|status_code|result|
      |100      |https://www.w3schools.com/xml/tempconvert.asmx|200|212|
      |37      |https://www.w3schools.com/xml/tempconvert.asmx|200|98.6|