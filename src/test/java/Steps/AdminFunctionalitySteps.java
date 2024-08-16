package Steps;
import Pages.AdminFuntionalityPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.CommonMethods;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;


public class AdminFunctionalitySteps extends CommonMethods {

    @When("the user navigates to the Inventory section")
    public void navigateToInventorySection() {
        try {
            getWait().until(ExpectedConditions.elementToBeClickable(AdminFuntionalityPage.inventoryLink));
            scrollintoview(AdminFuntionalityPage.inventoryLink);
            Actions actions = new Actions(driver);
            actions.moveToElement(AdminFuntionalityPage.inventoryLink).click().build().perform();
            System.out.println("Navigated to Inventory section");
        } catch (Exception e) {
            // If Actions fails, try JavaScript click
            jsClick(AdminFuntionalityPage.inventoryLink);
            System.out.println("Navigated to Inventory section using JavaScript click");
        }
    }

    @Then("the user should see the inventory table")
    public void verifyInventoryTableVisible() {
        Assert.assertTrue("Inventory table is not visible", adminFuntionalityPage.inventoryTable.isDisplayed());
    }

    @And("there should be a Search input field")
    public void verifySearchInputField() {

        assertTrue("Search input field is not visible", AdminFuntionalityPage.searchField.isDisplayed());
    }

    @And("the user should see advanced search options")
    public void verifyAdvancedSearchOptions() {
        assertTrue("Advanced search options button is not visible", AdminFuntionalityPage.advancedOptionButton.isDisplayed());
        click(AdminFuntionalityPage.advancedOptionButton);
    }

    @When("the user clicks on advanced option and see following search fields:")
    public void clickAdvancedOptionAndVerifyFields(DataTable dataTable) {
        List<String> expected = dataTable.asList();
        List<WebElement> actual = AdminFuntionalityPage.underAdvancedOptions;
        for (int i = 0; i < actual.size(); i++) {
            WebElement element = actual.get(i);
            Actions actions = new Actions(driver);
            actions.moveToElement(element).perform();
            Assert.assertEquals("tab dont match", expected.get(i), element.getText());
        }
    }

    //-------------------------------------------------------------
    @Then("the table should have the following columns:")
    public void the_table_should_have_the_following_columns(io.cucumber.datatable.DataTable dataTable) {
        List<String> expectedColumns = dataTable.row(0);
        List<WebElement> columnElements = AdminFuntionalityPage.inventoryTableHeadings;
        List<String> actualColumns = new ArrayList<>();
        for (WebElement element : columnElements) {
            actualColumns.add(element.getText());
        }
        Assert.assertEquals("Column headers do not match", expectedColumns, actualColumns);
    }

    //---------------------------------------------------------------
    @Given("the user is on the Customers page")
    public void userIsOnCustomersPage() {
        try {
            getWait().until(ExpectedConditions.elementToBeClickable(AdminFuntionalityPage.callCenterLink));
            scrollintoview(AdminFuntionalityPage.callCenterLink);
            Actions actions = new Actions(driver);
            actions.moveToElement(AdminFuntionalityPage.callCenterLink).click().build().perform();
            click(AdminFuntionalityPage.customerLink);
            System.out.println("Navigated to Call Center section");
        } catch (Exception e) {
            // If Actions fails, try JavaScript click
            jsClick(AdminFuntionalityPage.callCenterLink);
            jsClick(AdminFuntionalityPage.customerLink);
            System.out.println("Navigated to Call Center section using JavaScript click");
        }

    }

    @Then("the user should see a table with customer information")
    public void userShouldSeeCustomerTable() {
        Assert.assertTrue(AdminFuntionalityPage.customerTable.isDisplayed());
    }

    @And("the table should include customers like:")
    public void tableShouldIncludeCustomers(DataTable dataTable) {
        List<String> expected = dataTable.asList();
        List<WebElement> actual = AdminFuntionalityPage.customerNames;
        for (int i = 0; i < actual.size(); i++) {
            WebElement element = actual.get(i);
            Actions actions = new Actions(driver);
            actions.moveToElement(element).perform();
            Assert.assertEquals("tab dont match", expected.get(i), element.getText());


        }
    }

    //-----------------------------------------------------------------
    @Given("the user is on the Roles page")
    public void userIsOnRolesPage() {
        click(AdminFuntionalityPage.storeSettingLink);
        click(AdminFuntionalityPage.rolesLink);

    }

    @Then("the user should see a list of roles including:")
    public void userShouldSeeListOfRoles(DataTable dataTable) {
        List<String> expected = dataTable.asList();
        List<WebElement> actual = AdminFuntionalityPage.rolesTable;
        for (int i = 0; i < actual.size(); i++) {
            WebElement element = actual.get(i);
            Actions actions = new Actions(driver);
            actions.moveToElement(element).perform();
            Assert.assertEquals("tab dont match", expected.get(i), element.getText());


        }

    }

    //----------------------------------------------------
    @Given("the user is on the Shipping Methods page")
    public void userIsOnShippingMethodsPage() {
        click(AdminFuntionalityPage.storeSettingLink);
        click(AdminFuntionalityPage.shippingMethodLink);

    }

    @Then("the user should see a table with columns:")
    public void userShouldSeeTableWithColumns(DataTable dataTable) {
        List<String> expectedColumns = dataTable.row(0);
        List<WebElement> columnElements = AdminFuntionalityPage.shippingTablHeading;
        List<String> actualColumns = new ArrayList<>();
        for (WebElement element : columnElements) {
            actualColumns.add(element.getText());
        }
        // Compare expected and actual columns
        Assert.assertEquals("Column headers do not match", expectedColumns, actualColumns);


    }
//---------------------------------------------------------------------
    //----------------------------------------------------------

    @Given("the user is on the Add Tax Nexus page")
    public void userIsOnAddTaxNexusPage() {
        click(AdminFuntionalityPage.storeSettingLink);
        click(AdminFuntionalityPage.taxNexusLink);

    }

    @When("the user fills in the following details:")
    public void userFillsInDetails(DataTable dataTable) {
        List<String> expectedColumns = dataTable.row(0);
        System.out.println("expe"+expectedColumns.size());
        List<WebElement> columnElements = AdminFuntionalityPage.taxNexusTableHeading;
        System.out.println(columnElements.size());
        List<String> actualColumns = new ArrayList<>();
        for (WebElement element : columnElements) {
            actualColumns.add(element.getText());
            System.out.println(element.getText());
        }
        // Compare expected and actual columns
        Assert.assertEquals("Column headers do not match", expectedColumns, actualColumns);


    }
//-----------------------------------------------------------


    @Given("the user is on the Payment Methods page")
    public void userIsOnPaymentMethodsPage() {
        click(AdminFuntionalityPage.storeSettingLink);
        click(AdminFuntionalityPage.payementLink);

    }

    @Then("the user should see a table with payment methods including:")
    public void userShouldSeePaymentMethods(DataTable dataTable) {
        List<String> expected = dataTable.asList();
        List<WebElement> actual = AdminFuntionalityPage.payemntMethods;
        for (int i = 0; i < actual.size(); i++) {
            WebElement element = actual.get(i);
            Actions actions = new Actions(driver);
            actions.moveToElement(element).perform();
            Assert.assertEquals("tab dont match", expected.get(i), element.getText());

        }


    }
    @Given("the user is on the Call Center page")
    public void userIsOnCallCenterPage() {
        click(AdminFuntionalityPage.callCenterLink);

    }

    @When("the user clicks on the Cash Register sub-tab")
    public void the_user_clicks_on_the_cash_register_sub_tab() {
        click(AdminFuntionalityPage.cashRegisterLink);

    }

    @Then("the order details heading should be displayed")
    public void the_order_details_heading_should_be_displayed() {
        Assert.assertTrue(AdminFuntionalityPage.orderDetailsHeading.isDisplayed());
    }

    //----------------------------------------
    @Given("the user is on the Store Settings page")
    public void userIsOnStoreSettingsPage() {
        click(AdminFuntionalityPage.storeSettingLink);

    }

    @When("the user clicks on the Mailing Lists sub-tab")
    public void the_user_clicks_on_the_mailing_lists_sub_tab() {
        click(AdminFuntionalityPage.mailingListLink);

    }

    @Then("button to add mailing lists should be available")
    public void button_to_add_mailing_lists_should_be_available() {
        Assert.assertTrue(AdminFuntionalityPage.mailingButton.isDisplayed());
    }


    //----------------------------------


    @Given("the user clicks on the Apps sub link inside store setting")
    public void the_user_clicks_on_the_apps_sub_link_inside_store_setting() {
        click(AdminFuntionalityPage.storeSettingLink);
        click(AdminFuntionalityPage.appsLinkk);


    }
    @Then("the app {string} should be display")
    public void the_app_should_be_display(String expected) {
        System.out.println();
        String text= AdminFuntionalityPage.reverseConnector.getText();
        System.out.println(text);
        Assert.assertEquals("tab not match",text,expected);

    }

//--------------------------------------------------------------------

    @When("the user clicks on sales link")
    public void the_user_clicks_on_sales_link() {
        click(AdminFuntionalityPage.salesLinks);

    }

    @When("the user clicks on sales demand option")
    public void the_user_clicks_on_sales_demand_option() {
        click(AdminFuntionalityPage.salesDemand);

    }

    @Then("page heading {string} should be display")
    public void page_heading_should_be_display(String expected) {
        System.out.println();
        String actualText= AdminFuntionalityPage.salesDemandHeading.getText();
        System.out.println(actualText);
        Assert.assertEquals("tab not match",actualText,expected);

    }

//--------------------------------------------------

    @When("the user navigates to the fufillment link")
    public void the_user_navigates_to_the_fufillment_link() {
        click(AdminFuntionalityPage.fullfilmentLink);

    }
    @When("the user selects returned order option")
    public void the_user_selects_returned_order_option() {
        click(AdminFuntionalityPage.returenedOrderLink);

    }
    @Then("the user see {string} page")
    public void the_user_see_page(String expected) {
        System.out.println();
        String actualText= AdminFuntionalityPage.returnedOrderHeading.getText();
        System.out.println(actualText);
        Assert.assertEquals("tab not match",actualText,expected);


    }
//------------------------------------------------------------------


    @When("the user navigates to the merchandising link")
    public void the_user_navigates_to_the_merchandising_link() {
        click(AdminFuntionalityPage.merchandisingLink);

    }
    @When("the user selects categorized products option")
    public void the_user_selects_categorized_products_option() {
        click(AdminFuntionalityPage.categorizeProductLink);

    }
    @Then("the user watch {string} page")
    public void the_user_watch_page(String expected) {
        System.out.println();
        String actualText= AdminFuntionalityPage.categorizeProductHeading.getText();
        System.out.println(actualText);
        Assert.assertEquals("tab not match",actualText,expected);

    }
}
