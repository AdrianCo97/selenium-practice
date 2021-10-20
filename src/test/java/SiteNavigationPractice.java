import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SiteNavigationPractice {

    WebDriver driver;

    @Before
    public void setup(){
       System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
       driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://www.saucedemo.com/");

        //Login
        //username input
        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        //password input
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        //Click the Login button
        driver.findElement(By.cssSelector("#login-button")).click();

        //Inventory
        //Click on the button for the Sauce Labs Backpack
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack")).click();

        //Click on the shopping cart button
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();

        //Click on the checkout button
        driver.findElement(By.cssSelector("#checkout")).click();

        //Input values into the form
        driver.findElement(By.cssSelector("#first-name")).sendKeys("Firstname");
        driver.findElement(By.cssSelector("#last-name")).sendKeys("Lastname");
        driver.findElement(By.cssSelector("#postal-code")).sendKeys("12345");

        //Click on the continue button
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();

        //Click on the finish button
        driver.findElement(By.id("finish")).click();

        //Assert that the container with the selector #checkout_complete_container is displayed
        Assert.assertTrue(driver.findElement(By.cssSelector("#checkout_complete_container")).isDisplayed());
    }
}
