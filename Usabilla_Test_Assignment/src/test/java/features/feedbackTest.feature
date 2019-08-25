Feature: Usabilla Feedback tests coverage
  In this test feature all cases related to Generic option of Feedback button will be covered

  @tag1
  Scenario: User should be able to see Submit button for Generic Feedback
    Given User is on website "https://usabilla.com"
    And User clicks on feedback button
    And User selects Generic Feedback button
    When What do you think of us smiley selected
    And User selects "Compliment" subject 
    Then User should see Submit button
        
  @tag1
  Scenario: User should be able to select Specific feedback button
    Given User is on website "https://usabilla.com"
    When User clicks on feedback button
    Then User should be able to select Specific Feedback button

 @tag1
  Scenario Outline: User should be able to fill Generic Feedback form
    Given User is on website "https://usabilla.com"
    And User clicks on feedback button
    And User selects Generic Feedback button
    When What do you think of us smiley selected
    And User selects "Compliment" subject 
    And Feedback form details are filled such as "<toShare>" and "<email>" details
    Then User should see Submit button
    
 Examples:
 |toShare             | email         |
 |Usabilla great work | ABC@gmail.com |
 |Usabilla Team work  | XYZ@gmail.com |
 
