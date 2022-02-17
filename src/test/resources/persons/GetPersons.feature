#noinspeciton NonAsciiCharacters
Feature: GET "/api/persons" endpoint step definitions

  Scenario: TC_001_When the rest api application is first initialized, the persons list should be empty.
    Given GET "/api/persons" endpoint returns 200 and body list
      | id | personName  | phoneNumber    |
    When GET "/api/persons" endpoint is called without parameters
    Then HTTP status code should be 200
    And Persons should be
      | id | personName  | phoneNumber    |

  Scenario: TC_002_When "/api/persons" endpoint is called, then stored persons list should be returned.
    Given GET "/api/persons" endpoint returns 200 and body list
      | id | personName  | phoneNumber    |
      | 1  | Cansu Üstek | 05555555555    |
      | 2  | Mr.Brown    | (530) 892-1201 |
      | 3  | Mrs.Brown   | (301) 638-5772 |
    When GET "/api/persons" endpoint is called without parameters
    Then HTTP status code should be 200
    And Persons should be
      | id | personName  | phoneNumber    |
      | 1  | Cansu Üstek | 05555555555    |
      | 2  | Mr.Brown    | (530) 892-1201 |
      | 3  | Mrs.Brown   | (301) 638-5772 |

  Scenario: TC_003_When "/api/persons/<id>" endpoint is called, then matching data is returned according to given id
    Given GET "/api/persons/1" endpoint returns 200 and body list
      | id | personName  | phoneNumber    |
      | 1  | Cansu Üstek | 05555555555    |
    When GET "/api/persons/1" endpoint is called
    Then HTTP status code should be 200
    And Persons should be
      | id | personName  | phoneNumber    |
      | 1  | Cansu Üstek | 05555555555    |

  Scenario: TC_004_When "api/persons/<id>" endpoint is called with non-matching id according to given list, then returns 404 not found
    Given GET "/api/persons/4" endpoint returns 404 and body list
      | id | personName  | phoneNumber    |
    When GET "/api/persons/4" endpoint is called
    Then HTTP status code should be 404

  Scenario Outline: TC_005_When "api/persons/<id>" endpoint is called with non-matching id according to given list, then returns 404 not found
    Given GET "/api/persons/4" endpoint returns 404 and body list
      | id | personName  | phoneNumber    |
    When GET "/api/persons/<id>" endpoint is called
    Then HTTP status code should be 404

    Examples:
    | id          |
    | Cansu       |
    | 05555555555 |