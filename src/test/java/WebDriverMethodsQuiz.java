import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverMethodsQuiz {

    WebDriver driver;
    WebElement element;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void teardown(){
        driver.quit();
    }

    @Test
    public void dropDownTest(){
        driver.get("http://the-internet.herokuapp.com/dropdown");
    }
}
