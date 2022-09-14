package techproed.tests;

import org.testng.annotations.Test;
import techproed.pages.AddressLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day15_AddressLogin {
    AddressLoginPage addressLoginPage=new AddressLoginPage();
    @Test
    public void loginTest(){
//        going to the page
        Driver.getDriver().get(ConfigReader.getProperty("address_url"));
//        sending username
        addressLoginPage.username.sendKeys(ConfigReader.getProperty("address_username"));
//        sending password
        addressLoginPage.password.sendKeys(ConfigReader.getProperty("address_password"));
//        clicking on login button
        addressLoginPage.logInButton.click();
    }
}


              /*
              •Name:
	•US100208_Customer_Login
	•Description:
	•User should be able login as customer
	•Acceptance Criteria:
	•As customer, I should be able to log in the application
	•
	•Customer email: customer@bluerentalcars.com
	•Customer password: 12345
               */