package com.example.demo.annotation;

import java.lang.annotation.*;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import com.example.demo.constant.PropertyConstant;

@Retention(RetentionPolicy.RUNTIME)  // meta-annotation �w�q�b���ӯŧO�i��
@Target({ ElementType.TYPE, ElementType.METHOD })  // meta-annotation �w�q�Y�ӵ������d��
@Documented  // meta-annotation
@ConditionalOnProperty(
//		name = "conditional.test",
//		havingValue = "BBB"
		name = PropertyConstant.PropertyKey.CONDITIONAL_KEY,
		havingValue = PropertyConstant.PropertyValue.CONDITIONAL_VALUE_B
		)
public @interface ConditionalOnB {

}
