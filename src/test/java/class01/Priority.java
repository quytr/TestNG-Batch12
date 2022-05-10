package class01;

import org.testng.annotations.Test;

public class Priority {

    @Test(priority = 3)
    public void firstTest(){
        System.out.println("1st");
    }

    @Test(priority = 2)
    public void secondTest(){
        System.out.println("2nd");
    }

    @Test(priority = 1)
    public void thirdTest(){
        System.out.println("3rd");
    }
}
