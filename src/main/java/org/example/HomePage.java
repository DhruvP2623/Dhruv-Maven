//A package in Java is used to group related classes.
package org.example;
//importing a package of selenium
import org.openqa.selenium.By;
//importing a package of selenium WbDriver
import org.openqa.selenium.WebDriver;
//importing a package of ChromeDriver
import org.openqa.selenium.chrome.ChromeDriver;
//importing a package of AfterMethod
import org.testng.annotations.AfterMethod;
//importing a package of BeforeMethod
import org.testng.annotations.BeforeMethod;
//importing a package of Test
import org.testng.annotations.Test;
//It allows for formatting (date -> text), parsing (text -> date), and normalization.
import java.text.SimpleDateFormat;

public class HomePage {

    // method simulates a mouse-click on an element
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    // verifying messages, errors, asserting WebElements, and many more.
//findElement command is used to uniquely identify a web element within the web page
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    //to input content in editable text fields or password fields in a webpage.
//findElement command is used to uniquely identify a web element within the web page
    public void typeText(By by, String text) {
        driver.findElement(by).sendKeys(text);

    }

    @BeforeMethod//Executes before each test method
    public void openBrowser() {
        //.setProperty command is used for sets the property of the system which is indicated by a key
        System.setProperty("webdriver.chrome.driver", "src/test/java/Drivers/chromedriver.exe");
        // To communicate test scripts with Google Chrome
        driver = new ChromeDriver();
        // To maximize the browser
        driver.manage().window().maximize();
        //.get() method is used to open URL and it will wait till the whole page gets loaded
        driver.get("https://demo.nopcommerce.com/");
    }

    @AfterMethod//Executes after each test method
    public void CloseBrowser() {
        driver.close();
    }

    protected static WebDriver driver;

    //Below code is for Register Page
    @Test//This a test method
    public void register() {
        //set the path of the driver for the chrome Browser
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
        //Printing Output for timeStamp
        System.out.println(timeStamp);
        // method simulates a mouse-click on an ico-register
        //By.className for(ico-register) Initializes a new instance of the By class.
        clickOnElement(By.className("ico-register"));
        // method simulates a mouse-click on an radio button of gender-male
        //By.id for(gender-male) locate a particular web element using the value of its id attribute.
        clickOnElement(By.id("gender-male"));
        //to input content in editable text fields for(FirstName) in a webpage.
        //By.id for(FirstName) locate a particular web element using the value of its id attribute.
        typeText(By.id("FirstName"), "Rajesh");
        //to input content in editable text fields for(LastName) in a webpage.
        //By.id for(LastName) locate a particular web element using the value of its id attribute.
        typeText(By.id("LastName"), "Patel");
        //to input content in editable text fields for(DateOfBirth) in a webpage.
        /*.xpath function for(DateOfBirth) is a built-in function of selenium webdriver which is used to locate
        elements based on text of a web element.*/
        typeText(By.xpath("//div[@class=\"date-picker-wrapper\"]/select[1]"), "8");
        //to input content in editable text fields for(MonthOfBirth) in a webpage.
        /*.xpath function for(MonthOfBirth) is a built-in function of selenium webdriver which is used to locate
        elements based on text of a web element.*/
        typeText(By.xpath("//div[@class=\"date-picker-wrapper\"]/select[2]"), "June");
        //to input content in editable text fields for(YearOfBirth) in a webpage.
        /*.xpath function for(YearOfBirth) is a built-in function of selenium webdriver which is used to locate
        elements based on text of a web element.*/
        typeText(By.xpath("//div[@class=\"date-picker-wrapper\"]/select[3]"), "1985");
        //to input content in editable text fields for(Email) in a webpage.
        //By.id for(Email) locate a particular web element using the value of its id attribute.
        typeText(By.id("Email"), "Rajesh" + timeStamp + "@gmail.com");
        //to input content in editable text fields for(Company) in a webpage.
        //By.id for(Company) locate a particular web element using the value of its id attribute.
        typeText(By.id("Company"), "Dp Company");
        // method simulates a mouse-click on a radio Button of NewsLetters
        //By.id for(Newsletter) locate a particular web element using the value of its id attribute.
        clickOnElement(By.id("Newsletter"));
        //to input content in editable text fields for(Password) in a webpage.
        //By.id for(Password) locate a particular web element using the value of its id attribute.
        typeText(By.id("Password"), "rajesh");
        //to input content in editable text fields for(ConfirmPassword) in a webpage.
        //By.id for(ConfirmPassword) locate a particular web element using the value of its id attribute.
        typeText(By.id("ConfirmPassword"), "rajesh");
        // method simulates a mouse-click on a register-button
        //By.id for(register-button) locate a particular web element using the value of its id attribute.
        clickOnElement(By.id("register-button"));
        //By.className for(result) Initializes a new instance of the By class.
        // verifying messages, errors, asserting WebElements, and many more.
        String regMsg = getTextFromElement(By.className("result"));
        //Printing output for regMsg
        System.out.println(regMsg);


    }
}