package com.nocli.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@SuppressWarnings("unused")
public @interface Choice {
    int value() default 0;
}
