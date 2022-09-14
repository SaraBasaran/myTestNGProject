package techproed.tests.smoketest.login;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;
public class Day16_PositiveLogin {
    HomePage homePage;
    LoginPage loginPage;
    @Test
    public void customerLogin(){
//        going to the url
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
//        click on login button
        homePage = new HomePage();
        loginPage=new LoginPage();
//        clicking home login button
        homePage.homeLoginButton.click();
//        type email, password, and click login button
        loginPage.username.sendKeys(ConfigReader.getProperty("app_customer_username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("app_customer_password"));
        loginPage.loginButton.click();
//        Verify if login is successful
//        boolean isTrue= homePage.userID.isDisplayed();
//        Assert.assertTrue(isTrue);
        ReusableMethods.verifyElementDisplayed(homePage.userID);
        Driver.closeDriver();
    }

}