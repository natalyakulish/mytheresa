Feature: Find a Product

  @positive
  Scenario:Search by product name
    Given User opens "Home" page
    And User accepts "Cookie" popup
    And User clicks on "Women" link
    And User is on "Women" page
    When User searches for "Gucci bags"
    Then User is on "Search" page
    Then User sees positive amount of products