Feature: Product Categories Page

  Background:
    Given the user is logged in as an admin
    When the user navigates to 'Content Management'
    And the user selects 'Categories'
    Then the 'Product Categories' page should be displayed

  Scenario: View content management sections
    When the user clicks on "Content Management"
    Then the user should see the following sections:
      | Categories    |
      | Products      |
      | Stores        |
      | Advertisements|
      | Incentives    |
      | Blogs         |
      | Landing Pages |

  @smoke
  Scenario: Verify the Product Categories page loads successfully
    Then the page should have a search bar for filtering categories
    And the table should include rows for each category with accurate details
    And the page should display a table with columns:
      | Name       | Type   | Status | Publishing | Actions |


  Scenario: Publish a draft category
    When the user clicks the 'Actions' button next to 'Nike'
    And the user selects 'Publish' from the dropdown menu
    Then the category status should be updated from 'draft' to 'scheduled'
    And the category should be visible to user

  @regression
  Scenario: Verify the type of a category
    When the user searches for 'Mens Athletic Shoes'
    And the user clicks on 'search' button
    Then the user should see 'Mens Athletic Shoes'

  @regression
  Scenario: Verify the navigation to multiple category pages
    When the user clicks on 'Category'
    Then the user should be navigated to the 'Product Category'
      | Adidas                |
      | Clearance Apparel     |
      | Clearance Shoes       |
      | Kids Athletic Shoes   |
      | Mens Accessories      |
      | Mens Athletic Shoes   |
      | Mens Boots            |
      | Mens Casual Shoes     |
      | Mens Dress Shoes      |
      | New Arrivals          |
      | Nike                  |
      | steve4                |
      | Women's Dress Shoes   |
      | Womens Accessories    |
      | Womens Athletic Shoes |
      | Womens Boots          |
      | Womens Casual Shoes   |
