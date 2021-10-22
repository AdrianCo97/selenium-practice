import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptTests {

    public class SiteNavigationPractice {

        WebDriver driver;
        WebElement element;

        @Before
        public void setup(){
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
            driver = new ChromeDriver();
        }

        @After
        public void tearDown(){
            driver.quit();
        }

    }
