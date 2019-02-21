Feature: : Oxford English Dictionary Entry

  Scenario: Search for valid words in the dictionary

    Given the use connects to the API for English entries
    When the user enters the word id "test"
    Then the response returned is "200"

#    Examples:
#    |Word|
#    |test|
#    |apple|
    
    Scenario: Search for invalid words in the dictionary


      Given the use connects to the API for English entries
      When the user enters the word id "notindictionary"
      Then the response returned is "404"

