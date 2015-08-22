package com.yaoge.property;

import java.io.FileReader;
import java.util.Properties;
import java.io.FileOutputStream;
import java.io.FileInputStream;
/**i
 * Created by yaoge on 15/8/22.
 */
public class PropertyHttpUtils {
    public  static  void main(String args[]) {
        Properties property = new Properties();
        try{
            property.load(new FileInputStream("/Users/yaoge/workplace/github/prac/src/main/resources/prac.properties"));
            System.out.println(property.getProperty("value"));
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
