package com.yaoge.property;

import java.util.Properties;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileInputStream;

import org.omg.CORBA.portable.InputStream;

/**
 * i Created by yaoge on 15/8/22.
 */
public class PropertyHttpUtils {

    public static String getPath(Class<?> c , String propertiesName) {
        return c.getResource(File.separator+propertiesName).getPath();
    }
    
    public static InputStream getPathInputStream(Class<?> c,String propertiesName) {
        return (InputStream) c.getResourceAsStream(File.separator+propertiesName) ;
    }
    
    public static FileInputStream getFileInputStream(Class<?> c , String propertiesName) {
        try {
            return new FileInputStream(getPath(c,propertiesName));
        } catch (FileNotFoundException e) {
            return null;
        }
    }
    public void demo() {
        Properties property = new Properties();
        try {
            property.load(new FileInputStream(getPath(PropertyHttpUtils.class,"prac.properties")));
            FileInputStream file = getFileInputStream(PropertyHttpUtils.class,"prac.properties") ;
            byte[] arrays = new byte[10];
            file.read(arrays);
            System.out.println(new String(arrays));
            System.out.println(property.getProperty("value"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
