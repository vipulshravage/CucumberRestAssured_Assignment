Feature:Validate to get call using URL

  Scenario Outline: Do the validation for get call using URL
    Given User launch the url "<url>"
    Then User hit the url
    Then User check the status code "<status_code>"
    And User validate the id "<id>" and verify "<name>"


    Examples:
      |url|status_code|id|name|
      |https://api.restful-api.dev//objects|200|8|Apple Watch Series 8|
      |https://api.restful-api.dev//objects|200|11|Apple iPad Mini 5th Gen|
      |https://api.restful-api.dev//objects|200|2|Apple iPhone 12 Mini, 256GB, Blue|