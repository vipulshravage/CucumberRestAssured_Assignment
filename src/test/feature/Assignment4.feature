Feature: Validate the GET Call to print the ArrayList

  Scenario Outline: Do the GET call to print the ArrayList
    Given User launch url "<url>"
    Then User hit a url
    Then User check the status code as "<status_code>"
    And User validate the currencies as "<name>"
    And User validate the forward types as "<name>"
    And User validate outcome types as "<name>"

    Examples:
      |url|status_code|name|name|name|
      |https://www.xignite.com/xCurrencies.asmx?wsdl|200|Currencies|ForwardTypes|OutcomeTypes|