import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloSeleniumTest {


    @BeforeClass
    public static void setupClass(){
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void firstTest(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement element;

        element = driver.findElement(By.id("user-name"));

        //driver.findElement(By.name("name of locator"));

        //finds the element with the classname form_input
        driver.findElement(By.className("form_input"));

        //finds the element with the tagName input
        driver.findElement(By.tagName("input"));

        //finds the element with the cssSelector #user-name
        driver.findElement(By.cssSelector("#user-name"));

        //finds the element with the xpath //*[@id="user-name"]
        driver.findElement(By.xpath("//*[@id=\"user-name\"]"));

        driver.quit();
    }
}
