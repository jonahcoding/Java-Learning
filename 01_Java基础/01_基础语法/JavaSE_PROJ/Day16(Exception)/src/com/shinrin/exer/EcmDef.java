package com.shinrin.exer;

public class EcmDef {

    public static void main(String[] args) {
        try{
            int i = Integer.parseInt(args[0]);
            int j = Integer.parseInt(args[1]);
            int result = ecm(i,j);
        }catch (NumberFormatException e){
            System.out.println("参数类型不一致！");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("参数不足！");
        }catch (ArithmeticException e){
            System.out.println("分母不能为0！");
        }catch (EcDef e){
            System.out.println(e.getMessage());
        }
    }
    public static int ecm(int i, int j) throws EcDef {
        if (i<0 || j<0){
            throw new EcDef("分子或分母不能为负数！");
        }
        return i / j;
    }
}
