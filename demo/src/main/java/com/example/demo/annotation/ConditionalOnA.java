package com.example.demo.annotation;

//import java.lang.annotation.ElementType;
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
//import java.lang.annotation.Target;
import java.lang.annotation.*;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import com.example.demo.constant.PropertyConstant;

//������(meta-annotation ������L������)
@Retention(RetentionPolicy.RUNTIME)  // meta-annotation �w�q�b���ӯŧO�i��
@Target({ ElementType.TYPE, ElementType.METHOD })  // meta-annotation �w�q�Y�ӵ������d��
@Documented  // meta-annotation
@ConditionalOnProperty(
		name = PropertyConstant.PropertyKey.CONDITIONAL_KEY,  //
		havingValue = PropertyConstant.PropertyValue.CONDITIONAL_VALUE_A,  // ���O�_�ۦP
		matchIfMissing = true  // else (default = false)
		)
public @interface ConditionalOnA {
	
	// name �M value ���i�P�ɨϥ�

}
