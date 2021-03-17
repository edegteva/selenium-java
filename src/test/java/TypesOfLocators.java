import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;

import static org.junit.Assert.assertTrue;

public class TypesOfLocators {
    WebDriver driver;


    @Before
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        //7. Quit the driver
        driver.quit();
    }

    @Test
    public void SauceDemoTest() {
        //1. Instantiate the driver
       // WebDriver driver = new ChromeDriver();
        //2. Navigate to the URL
        driver.get("https://www.saucedemo.com/");
        //3. Find element
        WebElement element;
        //ID
        element = driver.findElement(By.id("user-name"));
        //Name
        //driver.findElement(By.name("name of the locator"));
        //Classname
        driver.findElement(By.className("form_input"));
        //Tagname
        driver.findElement(By.tagName("input"));
        //CSS selector
        driver.findElement(By.cssSelector("#user-name"));
        //Xpath
        driver.findElement(By.xpath("//*[@id=\"user-name\"]"));

//
//
        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
        //Link text
        driver.findElement(By.linkText("Click me using this link text!"));
        //Partial link text
        driver.findElement(By.partialLinkText("this link text!"));




        // 4. Check the state
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        WebElement element = wait.until(
//                ExpectedConditions.presenceOfElementLocated(By.id("user-name")));
//        //5. take action //6.record the result
//        assertTrue(element.isDisplayed());
//
    }
}
