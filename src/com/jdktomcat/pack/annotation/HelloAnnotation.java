package com.jdktomcat.pack.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface HelloAnnotation {

    int id() default -1;

    String name() default "tq";
}
