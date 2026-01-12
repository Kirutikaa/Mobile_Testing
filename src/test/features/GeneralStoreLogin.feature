Feature: AS a user,i want to validate the GeneralStore Mobile application.
  Scenario: 1. As a user i want to validate the GeneralStore application Basic check
    When the GeneralStore application is displayed check the title of the page
    Then check the country dropdown list is displayed and enable
    And check the name text box is displayed and enable to enter the text
    Then check the gender radio button are enable with options
      | Male   |
      | Female |
    Then check for Lets Shop button

  Scenario: 2. As a user i want to validate the GeneralStore application error message
    When the GeneralStore application is displayed check the title of the page
    Then click the let's shop button
    And error message should displayed

  Scenario: 3. As a user i want to validate the GeneralStore application LoginAction
    When the GeneralStore application is displayed check the title of the page
    Then select the country in dropdown
    And Enter the name in textbox
    And select the gender radio button
    And click the let's shop button



  

