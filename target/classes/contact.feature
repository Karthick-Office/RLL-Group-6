Feature: Ecom

  Scenario: Sign In functionality
    Given  I click on Sign In icon
    And I enter EmailId and Password
    Then I click on Sign In button

  Scenario: User submits the Contact Us
    Given User navigates to the Contact Us page
    When User fills in the contact form
    And User submits the form
    Then User should see a confirmation message
