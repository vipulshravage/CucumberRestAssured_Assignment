Feature: Validate the POST call with name response

  Scenario Outline: Do User POST request validation
    Given User provide the name "<name>" and "<year>" and "<price>"
    Then User create a conversion
    When User send a post call "<url>"
    And User see the status code as "<status_code>"
    And User validate the year "<year>"
    And User validate the price  "<price>"
    And User validate the created date should not null

    Examples:
      |name|year|price|url|status_code|year|price|
      |Apple MacBook Pro 16|2019|1849.99|https://api.restful-api.dev//objects|200|2019|1849.99|