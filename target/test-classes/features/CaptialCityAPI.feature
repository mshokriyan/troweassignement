#Author: Mohammad Shokriyan
Feature: Testing API Response for Capital City

  Scenario Outline: Valid Country Name Testing
    When User Input valid country "<countryName>" 
    Then API Status code should be status Code "<statusCode>"
    And Capital City Should be capital city "<capital>"
   
    Examples:
      | countryName | statusCode | capital          |
      | usa         |        200 | Washington, D.C. |
      | Afghanistan |        200 | Kabul            |
      | Sweden      |        200 | Stockholm        |


  Scenario Outline: Invalid Country Name Testing
    When User Input valid country "<countryName>"
    Then API Status code should be status Code "<statusCode>"
    Examples:
      | countryName | statusCode |
      | Uadkf       |        404 |
      | england     |        404 |
      | unkris      |        404 |