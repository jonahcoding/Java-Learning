package com.shinrin.java;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileUtilsTest {

    @Test
    public void test(){
        File srcFile = new File("A.jpg");
        File destFile = new File("C.jpg");
        try {
            FileUtils.copyFile(srcFile,destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}