package com.shinrin.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) {
        FileInputStream file = null;
        try {
            Properties pros = new Properties();
            file = new FileInputStream("./Day23/src/com/shinrin/java/jdbc.properties");
            pros.load(file);
            String name = pros.getProperty("Name");
            String password = pros.getProperty("PassWord");
            System.out.println("Name: " + name + " , PassWord: " + password );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (file != null){
                try {
                    file.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
