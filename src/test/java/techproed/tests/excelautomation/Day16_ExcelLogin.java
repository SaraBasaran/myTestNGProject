package techproed.tests.excelautomation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtil;
import techproed.utilities.ReusableMethods;

import javax.security.auth.login.LoginContext;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Day16_ExcelLogin {

    ExcelUtil excelUtil;
    HomePage homePage;
    LoginPage loginPage;
    List<Map<String, String>> testdata; //we will store excel data in this map list

    public void login(){

        Driver.getDriver().get(ConfigReader.getProperty("app_url"));

        //initializing the pages
        homePage=new HomePage();
        loginPage=new LoginPage();

        //GOING TO THE LOGIN PAGE

        try{                                //if there is any exception, then keep going.will be used only at the first
            homePage.homeLoginButton.click(); //login since homeLoginButton is available
        }catch (Exception e){

        }
        //GOING TO THE LOGIN PAGE AFTER 1st TIME

        try {
            homePage.userID.click(); //if there is any exception, then keep going.will be used at the second enterance
            homePage.logoutLink.click();
            homePage.OK.click();  //logout will be done
            homePage.homeLoginButton.click();

        }catch (Exception e){

        }


    }

    @Test

    public void customerLogin() throws IOException {

        String path = "C:/Users/BEKİR/IdeaProjects/myTestNGProject/src/test/java/resources/mysmoketestdata.xlsx";

        //customer sheet name

        String customerSheet = "customer_info";

        //use Excel Util
        excelUtil = new ExcelUtil(path,customerSheet);
//        getting the data from the excel using excel util method
        List<Map<String, String>> testData = excelUtil.getDataList();
        System.out.println(testData);
        for (Map<String ,String> eachData: testData) {
            login();
//            Not that we are on login page, we can send username, password, and click on login button
            loginPage.username.sendKeys(eachData.get("username"));
            loginPage.password.sendKeys(eachData.get("password").substring(0, 5));
            loginPage.loginButton.click();
            ReusableMethods.verifyElementDisplayed(homePage.userID);
            ReusableMethods.getScreenshot(eachData.get("username"));


        }
    }

    @AfterMethod
    public void tearDown(){

        Driver.closeDriver();

    }
}









//"C:/Users/BEKİR/IdeaProjects/myTestNGProject/src/test/java/resources/mysmoketestdata.xlsx"

//login 4 times
//    customer@bluerentalcars.com   12345
//    customer1@bluerentalcars.com  12346
//    customer2@bluerentalcars.com  12347
//    customer3@bluerentalcars.com  12348
/*
SUDO CODE
1st login:customer@bluerentalcars.com   12345
try{//using try catch cause 2nd time login button will not be there
click homepage login  ->>> 2nd time no such element exception,
if you don't use try catch test case fails and stops
}catch(Exception e){
}
---------------------------------
2nd, 3rd, 4th login
try{
click on user id ->>> 2st login  these elements will not be there throws no such element exception, so used try catch
click on log out
click on OK
click homepage login
}catch(Exception e){
}
-----------------------------------
//for all steps
for{
send username -> get excel data
send password -> get excel data
click login button
do assertion
take screenshot
}
-------
 */

