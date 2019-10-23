package com.lib;

import java.lang.annotation.Retention;


@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)

public @interface Priority {
  int value() default 0;
}
