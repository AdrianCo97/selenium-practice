import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LjudioTest {

    WebDriver driver;
    WebElement element;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void loginTest(){

        driver.get("http://localhost:3000/");
       driver.findElement(By.id("email")).sendKeys("test@test.com");
       driver.findElement(By.id("password")).sendKeys("password");

       element = driver.findElement(By.xpath("//*[@id=\"root\"]/form/button"));
       element.click();

       element = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/input"));

        Assert.assertTrue("Assert that the input for searching for songs/artists is displayed.", element.isDisplayed());



    }

}
