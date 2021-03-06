import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptTests {

        WebDriver driver;
        WebElement element;
        JavascriptExecutor javascriptExecutor;

        @Before
        public void setup(){
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
            driver = new ChromeDriver();
            javascriptExecutor = (JavascriptExecutor) driver;
        }

        @After
        public void tearDown(){
            driver.quit();
        }

        @Test
        public void focusInput(){
            driver.get("https://example.cypress.io/commands/actions");

            element = driver.findElement(By.cssSelector(".action-focus"));

            element.click();

            Assert.assertTrue(driver.findElement(By.xpath("//*[@for='password1']")).getAttribute("style").contains("color: orange"));

        }

        @Test
        public void cookieTest(){
            driver.get("https://example.cypress.io/commands/cookies");
            element = driver.findElement(By.cssSelector(".set-a-cookie"));

            element.click();

            var cookie = driver.manage().getCookieNamed("token");

            Assert.assertEquals(cookie.getValue(), "123ABC");
        }

        @Test
        public void scrollToBottom() throws InterruptedException{
            driver.get("https://ultimateqa.com/complicated-page/");
            javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");

            Thread.sleep(1000);
        }
}
