Feature:  Navigation in https://knp.org.pl/

  Scenario: User going on page
    Given a user in a knp.org.pl page, on start site
    When the user clicks button Dołącz do nas
    Then the user go to subpage with joining to party option
    And the user clicks button Wspieraj nas
    Then the user go to subpage with finance support option