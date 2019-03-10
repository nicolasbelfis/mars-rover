Feature: command rover
  Scenario Outline: send a valid command line to the rover
    Given a command line <command>
    When I call POST on <uri>
    Then I get http response code <code>
    And I get response body <body>

  Examples:
      | command  | uri           | code | body |
      | FFLFLBRB | /commandRover | 201  | {"rover position":"0,4"} |
      | BBBB     | /commandRover | 201  | {"rover position":"3,4","obstacle position":"4,4"}|
      | FEDD     | /commandRover | 400  | |
