package reviewClass01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTesting {

    public static WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void OpenBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");
    }

    @DataProvider(name = "Credentials")
    public Object[][] data(){
        Object[][] login ={
//                {"login@codility.com", "password", "Welcome to Codility"},
                {"unknown@codility.com", "password", "You shall not pass! Arr!"},
                {"unknowncodility.com", "password", "Enter a valid email"},
                {"", "password", "Email is required"},
                {"login@codility.com", "", "Password is required"}
        };
        return login;
    }

    // check the visibility of the elements
    @Test
    public void visibilityOfElements(){

        WebElement email = driver.findElement(By.id("email-input"));
        WebElement password = driver.findElement(By.id("password-input"));

        boolean isEmailDisplayed = email.isDisplayed();;
        boolean isPasswordDisplayed = password.isDisplayed();

        Assert.assertTrue(isEmailDisplayed);
        Assert.assertTrue(isPasswordDisplayed);

    }

    // validate for credentials
    @Test(dataProvider = "Credentials")
    public void validateCredentials(String email, String password, String expectedMsg){
        WebElement emailBox = driver.findElement(By.id("email-input"));
        emailBox.sendKeys(email);
        WebElement passwordBox = driver.findElement(By.id("password-input"));
        passwordBox.sendKeys(password);
        WebElement loginBtn = driver.findElement(By.id("login-button"));
        loginBtn.click();

        WebElement actualMsg = driver.findElement(By.id("messages"));
        String actualMsgText = actualMsg.getText();
        // Assert and check
        Assert.assertEquals(actualMsgText,expectedMsg);

    }

    // check for valid credentials
    @Test
    public void verifyCorrectCredentials(){
        WebElement emailBox = driver.findElement(By.id("email-input"));
        emailBox.sendKeys("login@codility.com");
        WebElement passwordBox = driver.findElement(By.id("password-input"));
        passwordBox.sendKeys("password");
        WebElement loginBtn = driver.findElement(By.id("login-button"));
        loginBtn.click();

        String expectedMsg = "Welcome to Codility";

        WebElement actualMsg = driver.findElement(By.id("container"));
        String actualMsgText = actualMsg.getText();
        // Assert and check
        Assert.assertEquals(actualMsgText,expectedMsg);

    }

    @AfterMethod(alwaysRun = true)
    public  void  CloseBrowser(){
        driver.quit();
    }
}
