package techproed.tests;

import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day14_FirstConfigProperties {

    @Test
    public void firstConfigTest(){

        Driver.getDriver().get(ConfigReader.getProperty("url_test_techproed"));
        Driver.closeDriver();

    }


}
