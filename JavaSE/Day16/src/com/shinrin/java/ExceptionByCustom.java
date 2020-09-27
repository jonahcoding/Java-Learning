package com.shinrin.java;

/*
--------------------
六、自定义异常：
规则：
    1.继承于现有的异常结构：RuntimeException 、Exception
    2.提供全局常量：serialVersionUID
    3.重载构造器
--------------------
*/

public class ExceptionByCustom extends Exception {

    static final long serialVersionUID = -7034897193246939L;

    ExceptionByCustom(){

    }

    ExceptionByCustom(String msg){
        super(msg);
    }
}
