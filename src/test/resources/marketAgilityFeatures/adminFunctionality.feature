Feature: Advanced Inventory Management

  Background:
    Given the user is logged in as an admin

  @regression
  Scenario: Access inventory threshold settings
    When the user clicks on the Warehouse tab
    And the user navigates to the Inventory section
    Then the user should see the inventory table
    And there should be a Search input field
    And the user should see advanced search options
    When the user clicks on advanced option and see following search fields:
      | SKU           |
      | Style Id      |
      | Active Status |


  @regression
  Scenario: Verify inventory table contents and search functionality
    When the user navigates to the Inventory section
    Then the user should see the inventory table
    And the table should have the following columns:
      | SKU | VENDOR | NAME | PRIMARY | ALTERNATE | ORDERED | THRESHOLD | ATS |


  @regression
  Scenario: User views customer list
    Given the user is on the Customers page
    Then the user should see a table with customer information
    And the table should include customers like:
      | Ivan Silva  |
      | K Mcginn    |
      | Gabe Harris |
      | ivan silva  |

  @regression
  Scenario: User views available roles
    Given the user is on the Roles page
    Then the user should see a list of roles including:
      | System Admin                  |
      | Banking Manager               |
      | Call Center Manager           |
      | Call Center Agent             |
      | Marketing User                |
      | Reports Only                  |
      | Web & Catalog Manager         |
      | Warehouse Manager             |
      | Warehouse Manager - Lite      |
      | Returns Manager               |
      | Warehouse Agent               |
      | Marketing User + Pages        |
      | Marketing User + Reports      |
      | Go Shippo -test account       |
      | test role                     |
      | Graphic Designer - Consultant |
      | Brian                         |

  @regression
  Scenario: User views existing shipping methods
    Given the user is on the Shipping Methods page
    Then the user should see a table with columns:
      | NAME | TITLE | CARRIER CODE | BASE CHARGE | STATUS | PUBLISHING | ACTIONS |


  @regression
  Scenario: User adds a new tax nexus
    Given the user is on the Add Tax Nexus page
    When the user fills in the following details:
      | NEXUS ID | STATE/PROVINCE | COUNTRY | RATE | SHIP RATE | STATUS | PUBLISHING | ACTIONS |


  @regression
  Scenario: User views existing payment methods
    Given the user is on the Payment Methods page
    Then the user should see a table with payment methods including:
      | VISA       |
      | Mastercard |
      | Discover   |
      | Paypal     |
      | Applepay   |
      | Googlepay  |
      | test       |
      | test       |


  @regression
  Scenario: User accesses Cash Register functionality
    Given the user is on the Call Center page
    When the user clicks on the Cash Register sub-tab
    Then the order details heading should be displayed

  @regression
  Scenario: User views mailing lists
    Given the user is on the Store Settings page
    When the user clicks on the Mailing Lists sub-tab
    Then button to add mailing lists should be available


  @regression
  Scenario: User installs a new app
    Given the user clicks on the Apps sub link inside store setting
    Then the app "Revere Connector" should be display

  @regression
  Scenario: User view sales demand page
    Given the user clicks on the Reports tab
    When the user clicks on sales link
    And the user clicks on sales demand option
    Then page heading "Sales Demand Report" should be display

  @regression
  Scenario: User checks return order page
    Given the user clicks on the Reports tab
    When the user navigates to the fufillment link
    And the user selects returned order option
    Then the user see "Returned Orders Report" page

  @regression
  Scenario: User views top merchandising report
    Given the user clicks on the Reports tab
    When the user navigates to the merchandising link
    And the user selects categorized products option
    Then the user watch "Categorized Products Report" page
