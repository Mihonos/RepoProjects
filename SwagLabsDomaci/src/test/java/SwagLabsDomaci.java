import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SwagLabsDomaci {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver103.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/");
    }
    @AfterMethod
        public void tearDown(){
        driver.quit();
        }

        @Test
        @Parameters({"USERNAME","PASSWORD"})
    public void SwagLabsLogin(String username,String password){

        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
            driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
driver.findElement(By.id("login-button")).click();
Object object = driver.findElement(By.xpath("//span[@class='title']")).getText();
System.out.println(object);
Assert.assertEquals(object,"PRODUCTS");


        }


    }




