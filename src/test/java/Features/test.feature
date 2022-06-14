Feature: Create a distinct flows

  Scenario: Vivienda Nueva

    Given i am in the index page
    When sign in like ejecutivo de cuentas
    And create a flow Vivienda Nueva
    Then we have a new item in the inbox of Vivienda nueva
