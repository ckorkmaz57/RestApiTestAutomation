#noinspeciton NonAsciiCharacters
Feature: PUT "/api/persons" endpoint step definitions

  Scenario: TC_001_When the rest api application is called with one person, then person should be inserted successfully
    Given PUT "/api/persons/" endpoint returns
      | id | personName  | phoneNumber    |
      | 1  | Cansu Üstek | 05555555555    |
    And PUT "/api/persons/" endpoint returns "200" status code
    When PUT "/api/persons/" endpoint is called
      | personName  | phoneNumber    |
      | Cansu Üstek | 05555555555    |
    Then HTTP status code should be "200"
    And Person should be
      | id | personName  | phoneNumber    |
      | 1  | Cansu Üstek | 05555555555    |

  Scenario: TC_002_When the rest api application is called with list of persons, then all rows should be inserted successfully
    Given PUT "/api/persons/" endpoint returns
      | id | personName  | phoneNumber    |
      | 1  | Cansu Üstek | 05555555555    |
      | 2  | Mr.Brown    | 05555555554    |
      | 3  | Mrs.Brown   | 6583020585     |
    And PUT "/api/persons/" endpoint returns "200" status code
    When PUT "/api/persons/" endpoint is called
      | personName  | phoneNumber    |
      | Cansu Üstek | 05555555555    |
      | Mr.Brown    | 05555555554    |
      | Mrs.Brown   | 6583020585     |
    Then HTTP status code should be "200"
    And Person should be
      | id | personName  | phoneNumber    |
      | 1  | Cansu Üstek | 05555555555    |
      | 2  | Mr.Brown    | 05555555554    |
      | 3  | Mrs.Brown   | 6583020585     |

  Scenario Outline: TC_003_When the rest api application's PUT /api/persons endpoint is called without phone number or username, then endpoint should return 400 and <messsage>
    Given PUT "/api/persons/" endpoint returns
      | id | personName   | phoneNumber      |
      | 1  | <personName> | <phoneNumber>    |
    And PUT "/api/persons/" endpoint returns "400" status code and Message is <message>
    When PUT "/api/persons/" endpoint is called
      | personName   | phoneNumber      |
      | <personName> | <phoneNumber>    |
    Then HTTP status code should be "400" and Message should be <message>

    Examples:
    |personName  |phoneNumber |message                                                           |
    |            |05555555555 |Kişi adı bilgisi zorunludur.                                      |
    |Cansu Üstek |            |Telefon numarası bilgisi zorunludur                               |
    |            |            |Kişi adı bilgisi zorunludur. Telefon numarası bilgisi zorunludur. |
    |""          |05555555555 |Kişi adı bilgisi zorunludur.                                      |
    |Cansu Üstek |""          |Telefon numarası bilgisi zorunludur                               |
    |""          |""          |Kişi adı bilgisi zorunludur. Telefon numarası bilgisi zorunludur. |

  Scenario : TC_004_When the rest api application's PUT /api/persons endpoint is called with same person name,then endpoint should return 400 and "Bu isimle kayıtlı bir kişi var!"
    Given PUT "/api/persons/" endpoint returns
      | id | personName   | phoneNumber      |
      | 1  | Cansu Üstek  | 05555555555      |
      | 2  | Cansu Üstek  | 05555555545      |
    And PUT "/api/persons/" endpoint returns "400" status code and Message is <message>
    When PUT "/api/persons/" endpoint is called
      | personName   | phoneNumber      |
      | Cansu Üstek  | 05555555555      |
      | Cansu Üstek  | 05555555545      |
    Then HTTP status code should be "400" and Message should be "Bu isimle kayıtlı bir kişi var!"

  Scenario : TC_005_When the rest api application's PUT /api/persons endpoint is called with id,then endpoint should return 400 and "Id bilgisi kullanılarak kişi eklenemez"
    Given PUT "/api/persons/1" endpoint returns
      | id | personName   | phoneNumber      |
      | 1  | Cansu Üstek  | 05555555555      |
    And PUT "/api/persons/1" endpoint returns "400" status code and Message is <message>
    When PUT "/api/persons/1" endpoint is called
      | personName   | phoneNumber      |
      | Cansu Üstek  | 05555555555      |
    Then HTTP status code should be "400" and Message should be "Id bilgisi kullanılarak kişi eklenemez"