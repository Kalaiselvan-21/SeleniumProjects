package SeleniumTests;

import org.testng.annotations.*;

public class AnnotationsHierarchy {

    @Test
    public void test()
    {
        System.out.println("I'm test");
    }

    @BeforeTest
    public void beforetest()
    {
        System.out.println("I'm beforetest");
    }

    @AfterTest
    public void aftertest()
    {
        System.out.println("I'm aftertest");
    }

    @BeforeSuite
    public void beforesuite()
    {
        System.out.println("I'm beforesuite");
    }

    @AfterSuite
    public void aftersuite()
    {
        System.out.println("I'm aftersuite");
    }

    @BeforeClass
    public void beforeclass()
    {
        System.out.println("I'm beforeclass");
    }

    @AfterClass
    public void afterclass()
    {
        System.out.println("I'm afterclass");
    }

    @BeforeMethod
    public void beforemethod()
    {
        System.out.println("I'm beforemethod");
    }

    @AfterMethod
    public void aftermethod()
    {
        System.out.println("I'm aftermethod");
    }

    @Test
    public void test2()
    {
        System.out.println("I'm test2");
    }

}
