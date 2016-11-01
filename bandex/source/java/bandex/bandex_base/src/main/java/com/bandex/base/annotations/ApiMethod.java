package com.bandex.base.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiMethod {
	String value();

	String descript();

	ApiParam[] apiParams() default {};

	boolean needLogin() default false;

}
