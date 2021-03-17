import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.xml.xpath.XPath;

import static org.junit.Assert.*;

public class ActionsExam {
    WebDriver driver;
    WebElement element;


    @Before
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    //Go here
    //select option 1 from the dropdown
    //Assert that option 1 is selected
    //Assert that option 2 is NOT selected
    @Test
    public void dropdown() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        element = driver.findElement(By.id("dropdown"));
        element.click();
        WebElement option1 = element.findElement(By.cssSelector("option[value='1']"));
        WebElement option2 = element.findElement(By.cssSelector("option[value='2']"));
        option1.click();
        assertTrue(option1.isSelected());
        assertFalse(option2.isSelected());
    }

    //Go to
    //Hover over the first image
    //Assert that on hover there is text that is displayed below "name: user1"
    @Test
    public void hover() {
        driver.get("https://the-internet.herokuapp.com/hovers");
        element = driver.findElement(By.className("figure"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        element = driver.findElement(By.xpath("//*[contains(text(),'name: user1')]"));
        assertTrue("user 1 should appear because we hovered over that image",
                element.isDisplayed());
    }

    //Go to
    //Right click
    //Close alert
    //
    @Test
    public void rightClick() {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        element = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
        driver.switchTo().alert().accept();
    }

    //Go to
    //send right arrow key to the input box
    //assert that you got this text back "You entered: RIGHT"
    @Test
    public void keyPresses() {
        driver.get("https://the-internet.herokuapp.com/key_presses");
        element = driver.findElement(By.id("target"));
        element.click();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_RIGHT).
                pause(1000).
                perform();
        element = driver.findElement(By.id("result"));
        assertEquals("Clicked right arrow key", "You entered: RIGHT", element.getText());
    }
}
