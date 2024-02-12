@us02

Feature: Sending message in Active Stream feature

  Background: User is already in the log in page
    Given the user is on the login page

# need to figure out how to assert something is displayed
  #not selecting recipient accurately
  #new locator for delete recipient button?
  Scenario: verify user is able to send a message by filling in the mandatory fields 'Message content & 'Recipient'
    Given the user logged in as "hr"
    When user opens a new message
    And user types message in Message field
    When User selects recipient
    And user clicks SEND button
    Then user sees message displayed under Activity Stream

  Scenario: verify user sees the message delivery should be to 'All employees' by default.
    Given the user logged in as "hr"
    When user opens a new message
    Then  To: field is set to "All employees"


  Scenario: verify user is able to cancel sending messages at any time before sending
    Given the user logged in as "hr"
    When user opens a new message
    And user clicks Cancel
    Then user sees message has been cancelled

@TC04
  Scenario: verify user sees accurate error message when attempting to send empty message
    Given the user logged in as "hr"
    When user opens a new message
    And user clicks SEND button
    Then user should see error message "The message title is not specified"



    Scenario: verify user sees accurate error message when attempting to send message without specified recipient
      Given the user logged in as "hr"
      When user opens a new message
      And user deletes default recipient
      When user types message in Message field
      And user clicks SEND button
      Then user should see error message "Please specify at least one person."
