package class02;

import org.testng.annotations.*;

public class Testing {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before suite :D");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After suite :D");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("I am before Test :)");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("I am after Test :)");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("I am before class");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("I am after class");
    }


    @BeforeMethod
    public void before(){
        System.out.println("this is my before method");
    }

    @AfterMethod
    public void after(){
        System.out.println("this is my after method");
    }

    @Test
    public void Test(){
        System.out.println("drive me crazy, driver me mad");
    }

    @Test
    public void Test1(){
        System.out.println("drive me nuts");
    }


}
