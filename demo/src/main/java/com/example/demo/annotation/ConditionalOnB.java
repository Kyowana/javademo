package com.example.demo.annotation;

import java.lang.annotation.*;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import com.example.demo.constant.PropertyConstant;

@Retention(RetentionPolicy.RUNTIME)  // meta-annotation 定義在哪個級別可用
@Target({ ElementType.TYPE, ElementType.METHOD })  // meta-annotation 定義某個註釋的範圍
@Documented  // meta-annotation
@ConditionalOnProperty(
//		name = "conditional.test",
//		havingValue = "BBB"
		name = PropertyConstant.PropertyKey.CONDITIONAL_KEY,
		havingValue = PropertyConstant.PropertyValue.CONDITIONAL_VALUE_B
		)
public @interface ConditionalOnB {

}
