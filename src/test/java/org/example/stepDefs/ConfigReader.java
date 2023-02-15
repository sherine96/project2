package org.example.stepDefs;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    String fileName = "Config.properties";
    FileInputStream fis;
    Properties prop;

    FileOutputStream fos;

    public void set(String key, String value)
    {

        try {
             fis = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        prop = new Properties();

        try {
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        prop.setProperty(key,value);

        try {
            fos = new FileOutputStream(fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        try {
            prop.store(fos,"");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



    public String get(String key)
    {

        try {
            fis = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        prop = new Properties();

        try {
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

     String value  = prop.getProperty(key);
        return value;


    }


}
