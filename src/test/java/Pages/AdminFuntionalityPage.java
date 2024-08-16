package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static utils.CommonMethods.driver;

public class AdminFuntionalityPage {
    //---------------

    @FindBy(xpath = "//div[contains(@class, 'menu-sub-accordion')]//a[@class='menu-link' and contains(@href, '/warehouse/inventory')]")
    public static WebElement inventoryLink;

    @FindBy(xpath = "//div[@class='table-responsive']")
    public static WebElement inventoryTable;


    @FindBy(xpath = "//div[@class='table-responsive']/div/table/thead/tr/th")
    public static List<WebElement> inventoryTableHeadings;

    @FindBy(id = "AdvancedSearchFormLink")
    public static WebElement advancedOptionButton;


    @FindBy(xpath = "//input[@id='Keywords']")
    public static WebElement searchField;
    @FindBy(xpath = "//div[text()='Active Status'] | //div[@id='SearchPanel']/div/div/div/div/label")
    public static List<WebElement> underAdvancedOptions;
    //-------------------------------


    //----------------------------


    @FindBy(xpath = "//div[contains(@class, 'menu-item')]//span[contains(@class, 'menu-title') and text()='Call Center']")
    public static WebElement callCenterLink;



    @FindBy(xpath = "//div[@class='menu-item']//a[@href='/callcenter/customers']")
    public static WebElement customerLink;

    @FindBy(xpath = "//div[@class='card card-flush']")
    public static WebElement customerTable;

    @FindBy(xpath = "(//tbody[@id='ContentSearchResults']/tr/td/div/a/span)[position () <5]")
    public static List<WebElement> customerNames;
    //-------------------------------------------------

    @FindBy(xpath = "//span[contains(@class, 'menu-title') and text()='Store Settings']")
    public static WebElement storeSettingLink;

    @FindBy(xpath = "//a[@href='/admin/roles']//span[contains(@class, 'menu-title') and text()='Roles']")
    public static WebElement rolesLink;

    @FindBy(xpath = "//tbody[@id='ContentSearchResults']//a[contains(@class, 'text-gray-800')]")
    public static List<WebElement> rolesTable;


    //--------------------------------------------

    @FindBy(xpath = "//div[@class='menu-item']//span[text()='Shipping Methods']")
    public static WebElement shippingMethodLink;

    @FindBy(xpath = " (//table[@id='DataTables_Table_0']/thead/tr/th)[position () >= 2]")
    public static List<WebElement> shippingTablHeading;



    @FindBy(xpath = "//div[@class='menu-item']//span[text()='Tax Nexus']")
    public static WebElement taxNexusLink;

    @FindBy(xpath = " (//table[@id='DataTables_Table_0']/thead/tr/th)[position () >= 2]")
    public static List<WebElement> taxNexusTableHeading;


    //--------------------------------------------

    @FindBy(xpath = "//a[@class='menu-link' and .//span[@class='menu-title' and text()='Payments']]")
    public static WebElement payementLink;

    @FindBy(xpath = " //tbody[@id='ContentSearchResults']/tr/td[2]")
    public static List<WebElement> payemntMethods;


//----------------------------------------

    @FindBy(xpath = "//a[@href='/callcenter/cash-register' and .//span[text()='Cash Register']]")
    public static WebElement cashRegisterLink;

    @FindBy(xpath = "(//div[@class='card card-flush py-4']/div/div/h2)[1]")
    public static WebElement orderDetailsHeading;

//--------------------------------------------------

    @FindBy(xpath = " //a[@href='/admin/mailinglists' and .//span[text()='Mailing Lists']]")
    public static WebElement mailingListLink;


    @FindBy(xpath = "(//div[@id='ma_app_toolbar_container']/div[2])/a")
    public static WebElement mailingButton;



    @FindBy(xpath = " //a[@class='menu-link' and .//span[@class='menu-title' and text()='Apps']]")
    public static WebElement appsLinkk;


    @FindBy(xpath = " (//div[@class='ms-5']//a)[1]")
    public static WebElement reverseConnector;
//------------------------------

    @FindBy(xpath = " (//a[@class='menu-link' and .//span[@class='menu-title' and text()='Sales']])[3]")
    public static WebElement salesLinks;

    @FindBy(xpath = "//div[contains(@class, 'flex-grow-1')]//span[contains(@class, 'fw-bold') and text()='Sales Demand']")
    public static WebElement salesDemand;


    @FindBy(xpath = " //h1[@class='flex-align-center flex-nowrap fs-3 fw-bold my-0 page-heading']")
    public static WebElement salesDemandHeading;


    //--------------------------------------

    @FindBy(xpath = " //a[@class='menu-link' and contains(@href, 'category=fulfill')]")
    public static WebElement fullfilmentLink;

    @FindBy(xpath = "(//a[@class='col mb-6'][.//span[contains(text(), 'Returned Orders')]]/div/div/span)[1]")
    public static WebElement returenedOrderLink;

    @FindBy(xpath = " //h1[@class='flex-align-center flex-nowrap fs-3 fw-bold my-0 page-heading']")
    public static WebElement returnedOrderHeading;

//-----------------------------------------------------

    @FindBy(xpath = "//a[contains(@href, 'category=product')]//span[text()='Merchandising']")
    public static WebElement merchandisingLink;

    @FindBy(xpath = "  //span[@class='fw-bold fs-6 text-body'][normalize-space()='Categorized Products']")
    public static WebElement categorizeProductLink;

    @FindBy(xpath = " //h1[@class='flex-align-center flex-nowrap fs-3 fw-bold my-0 page-heading']")
    public static WebElement categorizeProductHeading;


//--------------------------------------

    public AdminFuntionalityPage() {
        PageFactory.initElements(driver,this);
    }
}

