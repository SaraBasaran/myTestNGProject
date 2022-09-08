package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Day14_DependsOnMethod {

    @Test
    public void homePage(){
        System.out.println("Home Page");

    }

    @Test
    public void loginPage(){
        System.out.println("Login Page");
        Assert.assertTrue(false);//if this method fails then checkout page method will not be executed

    }

    /*
    dependsOnMethods connects checkOutPage to loginPage
    If checkOutPage method is executed then loginPage runs first.
    If the login page passes then checkout page will be executed.If loginPage fails then
    checkoutpage willnot be executed.
     */

    @Test(dependsOnMethods = "loginPage")

    public void checkOutPage(){
        System.out.println("Check Out Page");

    }



}
