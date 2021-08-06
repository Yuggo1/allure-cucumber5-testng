Feature: Nasa Rover Mars Photos Api

  Scenario Outline: Get first Mars photos
    When I request the <numOfPics> first photos made by <rover> on <date>
    Then I should get the <numOfPics> first photos made by <rover> on <date>
    Examples:
      | numOfPics |   rover     |   date      |
      |    10     | "curiosity" |   "1000"    |
      |    10     | "curiosity" | "2015-05-30" |

  Scenario: Retrieve and compare the first 10 Mars photos made by "Curiosity" on 1000 sol and on Earth date equal to 1000 Martian sol.
    When I request the 10 first photos made by "curiosity" on "1000"
    And I request the 10 first photos made by "curiosity" on "2015-05-30"
    Then The responses should be equals

  Scenario: Validate that the amounts of pictures that each "Curiosity" camera took on 1000 Mars sol is not greater than 10 times the amount taken by other cameras on the same date.
    When I request all photos made by "curiosity" on 1000 Mars sol
    Then No camera fired more than 10 times than the others