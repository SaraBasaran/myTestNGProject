package techproed.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    //creating Properties object by making acc. mod. private not to let the other data get involved.

    private static Properties properties;

    //creating a static block to run FIRST of all other data

    static{
    //path of properties file
    String path= "configuration.properties";

        try {
            FileInputStream fileInputStream=new FileInputStream(path);
            properties=new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch ( IOException e) {
            e.printStackTrace();
        }


    }
    //creating a method that will accept a key and returns the value

    public static String getProperty(String key){
        return properties.getProperty(key);

    }
    public static void main(String[] args){

        System.out.println(properties.getProperty("url_test_techproed")); //we provide the key and returns the value
        System.out.println(properties.getProperty("url_uat_techproed"));
        System.out.println(properties.getProperty("usjnfıuhrfd"));//null ==> when there is no match==>if there is no data it will return null.NO EXCEPTION..

    }













}
