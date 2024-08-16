package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CommonMethods extends PageInitializers {
    public static WebDriver driver;

    public static void openBrowserAndLaunchApplication()  {
        switch (ConfigReader.getProperty("browser")) {
            case "Chrome":
              //  ChromeOptions chromeOptions = new ChromeOptions();
                // chromeOptions.addArguments("--headless");
                //driver = new ChromeDriver(chromeOptions);
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            case "FireFox":
                driver = new FirefoxDriver();
                break;
            case "Edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Invalid Browser Name");
        }
        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get(ConfigReader.getProperty("URL"));
        initializePageObjects();

        // Load cookies from file
        loadCookies("cookies.data");
    }

    private static void loadCookies(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("Cookie file not found: " + file.getAbsolutePath());
            return;
        } SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] token = line.split(";");
                String name = token[0];
                String value = token[1];
                String domain = token[2];
                String path = token[3];
                Date expiry = null;
                if (!token[4].equals("null") && !token[4].isEmpty()) {
                    expiry = sdf.parse(token[4]);
                }
                boolean isSecure = Boolean.parseBoolean(token[5]);
                boolean isHttpOnly = Boolean.parseBoolean(token[6]);

                Cookie cookie = new Cookie(name, value, domain, path, expiry, isSecure, isHttpOnly);
                driver.manage().addCookie(cookie);
            }
            driver.navigate().refresh();  // Refresh to apply cookies
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private static void saveCookies(String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            Set<Cookie> cookies = driver.manage().getCookies();
            for (Cookie cookie : cookies) {
                bw.write((cookie.getName() != null ? cookie.getName() : "") + ";"
                        + (cookie.getValue() != null ? cookie.getValue() : "") + ";"
                        + (cookie.getDomain() != null ? cookie.getDomain() : "") + ";"
                        + (cookie.getPath() != null ? cookie.getPath() : "") + ";"
                        + (cookie.getExpiry() != null ? cookie.getExpiry() : "") + ";"
                        + cookie.isSecure() + ";"
                        + cookie.isHttpOnly());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }}

    public void closeBrowser() {
        if(driver!= null) {
            saveCookies("cookies.data");
            // driver.quit();
        }
    }

    //we use this method instead of send keys method throughout the framework
    public static void sendText(WebElement element, String textToSend) {
        element.clear();
        element.sendKeys(textToSend);
    }

    //to get web-driver wait
    public static WebDriverWait getWait() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait;
    }

    //this method will wait for the element to be clickable
    public static void waitForClickability(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }public static void pageLoadandClick(WebElement element)
    {
        if(getJSExecutor().executeScript("return document.readyState").equals("loaded")
                || getJSExecutor().executeScript("return document.readyState").equals("complete")==true){
            scrollIntoviewAndclick(element);
        }
    }


    //this method will perform click operation but before perform click, it will wait
    //for the element to be clickable
    public static void click(WebElement element) {
        waitForClickability(element);
        element.click();
    }

    //this method will return JavascriptExecutor Object

    public static JavascriptExecutor getJSExecutor() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }

    //this function will perform click on element using javascript executor
    public static void jsClick(WebElement element) {
        getJSExecutor().executeScript("arguments[0].scrollIntoView;", element);
        getJSExecutor().executeScript("arguments[0].click();", element);
    }

    //selecting the dropdown using text
    public static void selectDropdown(WebElement element, String text) {
        Select s = new Select(element);
        s.selectByVisibleText(text);
    }

    public static void moveToElement(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }
    public static void scrollToelement(WebElement element){
        Actions actions=new Actions(driver);
        actions.scrollToElement(element).perform();

    }
    //to get current time
    public  static  String getCurrentdate(){
        Date currentDate=new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("MM/dd/yyyy");
        String getDate=dateFormat.format(currentDate);
        return getDate;

    }
    //to scroll Window
    public static void scrollWebsiteWindow(int x, int y) {
        getJSExecutor().executeScript("window.scrollBy(" + x + "," + y + ")");

    }
    //to scroll to an element
    public static void scrollintoview(WebElement element){
        getJSExecutor().executeScript("arguments[0].scrollIntoView();",element);
    }
    //to scroll and click  an element
    public static void scrollIntoviewAndclick(WebElement element) {
        getJSExecutor().executeScript("arguments[0].scrollIntoView();",element);
        getJSExecutor().executeScript("arguments[0].click();",element);

    }

    public static void subLinksVerification(List<WebElement> element1, WebElement element2,
                                            WebElement element3, String titleValue) {
        List<WebElement> list =  element1;
        for (int i = 0; i < list.size(); i++) {
            WebElement element = list.get(i);
            element.click();
            String expectedTitle = titleValue;
            String actualTitle = element2.getText();
            Assert.assertEquals(actualTitle, expectedTitle);
            driver.navigate().back();
            moveToElement(element3);
            list =  element1;


        }

    }

    public static void handleMultipleWindows(){
        String mainWindow=driver.getWindowHandle();
        Set<String> allWindowsHandle=driver.getWindowHandles();
        Iterator<String> it=allWindowsHandle.iterator();
        while(it.hasNext()){
            String handle=it.next();
            if(!mainWindow.equals(handle)){
                driver.switchTo().window(handle);
                driver.close();
            }

        }
    }
    //text assertion method
    public static void textAssertion(WebElement element, String data){
        String errorMessage=element.getText();
        boolean result=errorMessage.contains(data);
        Assert.assertTrue(result);
    }

    public static boolean isloadComplete(WebDriver driver)
    {
        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("loaded")
                || ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
    }
}
