@addEvent
Feature: creat an event


  Background:
    Given the user is on homepage
    Given the user accesses "Event" tab

  @OP-975
  Scenario Outline: Add start and ending date and time and specify the time zone
    Given the user enters start "<start date>" and ending "<end date>" dates
    And the given "<start date>" "<end date>" dates should be displayed
    When the user enters start "<start time>" and ending "<end time>" times
    Then the given "<start time>" "<end time>"times should be displayed
    And the user specify time zone



    Examples:
      | start date | end date   | start time | end time |
      | 02/19/2022 | 03/19/2022 | 09:15 am   | 11:00 am |

  @OP-977
  Scenario Outline: User should be able to set reminder
    Given the user select set reminder
    When the user set the reminder with "<time>"
    Then reminder count box should display "<time>"
    When the user clicks unit dropdown
    Then the unit dropdown should have following options
      | minutes |
      | hours   |
      | days    |

    Examples:
      | time |
      | 23   |

  @OP-978
  Scenario: User should be able to select event location
    Given the user clicks location dropdown
    Then the location dropdown should have following options
      | Central Meeting Room |
      | East Meeting Room    |
      | West Meeting Room    |
#BUG from dropdown impossible to select an option
  # impossible to select or as list of loacators
  # and when user try to select locator options are not active but visible


  @OP-979
  Scenario Outline: User should be able to add attendees
    When the user clicks on members input box
    Given the user clicks on "<option>"
    Then the user select group "<group name>" from options
    Examples:
      | option    | group name  |
      | My Groups | Soccer team |

  @OP-980
  Scenario: User should be able to click on More to see the event details
    Given the user clicks on dropdown more
    Then the more dropdown should be displayed
    Then opened more dropdown should have following options
      | Availability |
      | Repeat       |
      | Calendar     |
      | Importance   |
    Given the user clicks  send button

