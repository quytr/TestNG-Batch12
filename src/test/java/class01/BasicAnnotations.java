package class01;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicAnnotations {

    @Test(groups = "smoke")
    public void cfirstTest(){
        System.out.println("This is my first testcase");
    }

    @Test
    public void asecondTest(){
        System.out.println("This is my second test case");
    }

    @Test
    public void bthirdTest(){
        System.out.println("This is my third test case");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("*********** I am Precondtion ***********");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("------------ I am Post condition --------------");
    }






}
