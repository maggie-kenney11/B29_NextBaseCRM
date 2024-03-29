@us04
Feature: User should be able to add link in message

  Background: User is already in the log in page
    Given the user is on the login page

  Scenario: Verify users can attach a link in message
    Given the user logged in as "hr"
    When user opens a new message
    And user clicks the Link icon
    And user enters "google" in the Link text field
    And user enters "https://www.google.com" in the Link URL field
    And user clicks Save button
    And user clicks SEND button
    Then user is able to see the message with the Link text in Activity Stream


  Scenario: Verify users can navigate to the correct URL by clicking on the link
    Given the user logged in as "help desk"
    When user opens a new message
    And user clicks the Link icon
    And user enters "google" in the Link text field
    And user enters "https://www.google.com" in the Link URL field
    And user clicks Save button
    And user clicks SEND button
    And user clicks on the attached link
    Then user navigate to the correct URL



  Scenario: Verify link is opening in a new tab
    Given the user logged in as "marketing"
    When user opens a new message
    And user clicks the Link icon
    And user enters "google" in the Link text field
    And user enters "https://www.google.com" in the Link URL field
    And user clicks Save button
    And user clicks SEND button
    And user clicks on the attached link
    Then the correct URL is opening in a new tab