package com.shinrin.java;

public class CustomExceptionTest {
    public static void main(String[] args) {
        try{
            Student stu = new Student();
            stu.regist(-1001);
            System.out.println(stu);
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}

class Student{
    private int id;
    public void regist(int id) throws Exception{
        if (id > 0){
            this.id = id;
        }else {
            throw new ExceptionByCustom("ID不能为负数！");
        }
    }

    @Override
    public String toString(){
        return "Student [ID: " + id + "]";
    }
}