import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class LocatingElementsTest {

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

        @Test
        public void SauceDemoTest() {
        //1. Instantiate the driver
            WebDriver driver = new ChromeDriver();
        //2. Navigate to the URL
        driver.get("https://www.saucedemo.com/");
        //3. Find element //4. Check the state
            WebDriverWait wait = new WebDriverWait(driver, 5);
            WebElement element = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.id("user-name")));
            //5. take action //6.record the result
            assertTrue(element.isDisplayed());
        //7. Quit the driver
            driver.quit();
    }
}
