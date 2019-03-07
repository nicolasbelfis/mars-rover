Feature: command rover
  Scenario Outline: send a valid command line to the rover
    Given a command line <command>
    When I call POST on <uri>
    Then I get http response code <code>
    And I get response body <body>

  Examples:
      | command | uri | code | body |
      | Friday | /commandRover | 201 | bobo |
