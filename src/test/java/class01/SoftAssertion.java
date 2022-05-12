package class01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {
    public static WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void OpenBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
    }

    @Test(groups = "regression")
    public void VerifyCredentials(){

        SoftAssert soft = new SoftAssert();

        String expectedText = "Invalid credentials";

        WebElement username = driver.findElement(By.id("txtUsername"));
        username.sendKeys("Admin");

        boolean displayed = username.isDisplayed();

        driver.findElement(By.id("txtPassword")).sendKeys("123456");
        driver.findElement(By.id("btnLogin")).click();
        String text = driver.findElement(By.id("spanMessage")).getText();

        // assertion to make sure that the message is correct
        soft.assertEquals(text, expectedText);

        // validate the display is true or not
        System.out.println("hello world");
//        displayed=false;
        soft.assertTrue(displayed);

        // check all assertions
        System.out.println("hi");
        soft.assertAll();

    }

    @Test(groups = "smoke")
    public void loginTest2(){
        System.out.println("I am test for login under smoke");
    }


    @AfterMethod (alwaysRun = true)
    public  void  CloseBrowser(){
        driver.quit();
    }

}
