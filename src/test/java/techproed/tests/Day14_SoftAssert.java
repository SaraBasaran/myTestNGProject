package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
public class Day14_SoftAssert {


    @Test
    public void softAssert() {
         //Soft Assert is used to do multiple assertion in the same class==>also known as "verification"
        //Hard Assertion is more common
        /*
        When do you use softAssert?
        We can use it if we want to see each test method result.We use especially when I do scratch test cases to see
        all the steps on my test case.
         */
        SoftAssert sa=new SoftAssert();

        System.out.println("Line A");
        sa.assertEquals("Hello", "HelloX");

        System.out.println("Line B");
        sa.assertTrue(false);

        System.out.println("Line C");
        sa.assertEquals(1, 1);

       sa.assertAll();

    }











}
