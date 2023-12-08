@contact
Feature: Contact Us Form Submission

  Scenario: User submits the Contact Us
    Given User navigates to the Contact Us page
    When User fills in the contact form with the following details
      | Name  | Email             | Phone      | Message              |
      | John  | john@example.com  | 1234567890 | Hello, this is John. |
    And User submits the form
    Then User should see a confirmation message
