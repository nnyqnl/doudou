package com.wenqi.doudou.boot.study;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(TestSelector.class)
public @interface EnableService {
}
