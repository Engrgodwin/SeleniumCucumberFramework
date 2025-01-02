@userRegistration @functional @e2e
Feature: user registration

  Background: User receives a confirmation email upon successful registration
  User cannot register with duplicate credentials

  @functional @regression @smoke @integration
  Scenario Outline: Confirmation email upon successful registration
     Given the user is on the registration page of Saucedemo
     When the user enters a valid "<username>" "<password>" "<email>"
     And clicks on the "Sign Up" button
     And the registration is successful
     Then the user receives a confirmation email

     Examples:
        | username | password | email                  |
        | godwin   | XXXXXX   | autopractise@gmail.com |

  @functional @negativeTest
  Scenario Outline: User cannot register with duplicate credentials
     Given the user is on the registration page of Saucedemo
     When the user enters an already registered "<email>"
     And clicks on the "Sign Up" button
     Then an error message is displayed stating "This email is already registered."

    Examples:
      | email                  |
      | autopractise@gmail.com |