package class02;

import org.testng.annotations.*;

public class Testing2 {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before suite in another class =.=");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After suite in another class =.=");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("I am before Test in another class >,<");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("I am after Test in another class >.<");
    }

    @Test
    public void testB(){
        System.out.println("hello testB");
    }

    @Test
    public void testA(){
        System.out.println("hello testA");
    }
}
