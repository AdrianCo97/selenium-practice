import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
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
        //find the dropdown list
        element = driver.findElement(By.id("dropdown"));
        //click on the list
        element.click();

        WebElement option1 = driver.findElement(By.cssSelector("option[value='1'"));
        WebElement option2 = driver.findElement(By.cssSelector("option[value='2'"));

        //click on option1
        option1.click();

        Assert.assertTrue(option1.isSelected());
        Assert.assertFalse(option2.isSelected());
    }
}
