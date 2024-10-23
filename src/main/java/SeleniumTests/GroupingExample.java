package SeleniumTests;

import org.testng.annotations.Test;

public class GroupingExample {

    @Test(groups = {"Apple"})
    public void Apple1()
    {
        System.out.println("Apple1 Testing");
    }

    @Test(groups = {"Apple"})
    public void Apple2()
    {
        System.out.println("Apple2 testing");
    }
    @Test
    public void Samsung1()
    {
        System.out.println("Samsung1 Testing");
    }

    @Test
    public void Samsung2()
    {
        System.out.println("Samsung2 testing");
    }

    @Test(groups = {"OnePlus"})
    public void OnePlus1()
    {
        System.out.println("OnePlus1 Testing");
    }

    @Test(groups = {"OnePlus"})
    public void OnePlus2()
    {
        System.out.println("OnePlus2 testing");
    }
}
