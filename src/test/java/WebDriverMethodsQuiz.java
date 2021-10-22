import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

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

    @Test
    public void hover(){
        driver.get("http://the-internet.herokuapp.com/hovers");
        element = driver.findElement(By.className("figure"));
        Actions actions = new Actions(driver);

        //move to element figure
        actions.moveToElement(element).perform();

        //find the h5 element
        element = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/h5"));

        //assert that element is displayed
        Assert.assertTrue("The text 'user1' should appear once the test hovers over the img ", element.isDisplayed());
    }

    @Test
    public void rightClick(){
        driver.get("http://the-internet.herokuapp.com/context_menu");
        element = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);

        //perform a right click on the element
        actions.contextClick(element).perform();

        //Switch to the alert window and click accept
        driver.switchTo().alert().accept();
    }

    @Test
    public void keyPresses(){
        driver.get("http://the-internet.herokuapp.com/key_presses");
        element = driver.findElement(By.id("target"));
        //click on the target
        element.click();

        //Press the right arrow key
        Actions actions = new Actions(driver);
        actions
                .sendKeys(Keys.ARROW_RIGHT).
                pause(1000).
                perform();

        element = driver.findElement(By.id("result"));
        Assert.assertEquals("You entered: RIGHT", element.getText());

    }
}
