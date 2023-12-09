@contact
Feature: Contact Us Form Submission

  Scenario: User submits the Contact Us
    Given User navigates to the Contact Us page
    When User fills in the contact form
    And User submits the form 
    Then User should see a confirmation message
