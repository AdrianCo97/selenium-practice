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
    public void loginTest() throws InterruptedException{

        //Login
        driver.get("http://localhost:3000/");
       driver.findElement(By.id("email")).sendKeys("test@test.com");
       driver.findElement(By.id("password")).sendKeys("password");

       element = driver.findElement(By.xpath("//*[@id=\"root\"]/form/button"));
       element.click();

       Thread.sleep(1000);

       element = driver.findElement(By.xpath("//*[@class='input']"));

       Assert.assertTrue("Assert that the input for searching for songs/artists is displayed.", element.isDisplayed());

       //SearchPage
       element = driver.findElement(By.xpath("//*[@class='input']"));

       //Search for a song
       element.sendKeys("My friends over you");

       //Click on the search button
       driver.findElement(By.xpath("//*[@class='search-button']")).click();

       //Wait for result
       Thread.sleep(1000);

       //Find the first result
       element = driver.findElement(By.xpath("//*[@id='0']"));

       //Match the expected value with the result
       Assert.assertEquals("My Friends Over You", element.findElement( By.className("song-name")).getText());

       Thread.sleep(1000);

    }
}
