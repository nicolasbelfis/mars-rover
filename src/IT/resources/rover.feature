Feature: command rover
  Scenario Outline: send a valid command line to the rover
    Given a command line <command>
    When I call POST on <uri>
    Then I get http response code <code>
    And I get response body <body>

  Examples:
      | command         | uri           | code | body |
      | F-F-L-F-L-B-R-B | /commandRover | 201  | {"rover position":"0,3"} |
      | B-B-B-B-R-F-F-F | /commandRover | 201  | {"rover position":"4,3","obstacle position":"4,4"}|
      | F-E-D-D         | /commandRover | 400  | |
