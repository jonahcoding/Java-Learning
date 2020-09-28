package com.shinrin.java;

import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;

//测试失败了！！！
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE,TYPE_PARAMETER,TYPE_USE})
public @interface MyAnnotations {

    String value() default "hello";
}
