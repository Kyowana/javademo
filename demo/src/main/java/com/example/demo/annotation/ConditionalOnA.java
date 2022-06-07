package com.example.demo.annotation;

//import java.lang.annotation.ElementType;
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
//import java.lang.annotation.Target;
import java.lang.annotation.*;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import com.example.demo.constant.PropertyConstant;

//元註釋(meta-annotation 註釋其他的註釋)
@Retention(RetentionPolicy.RUNTIME)  // meta-annotation 定義在哪個級別可用
@Target({ ElementType.TYPE, ElementType.METHOD })  // meta-annotation 定義某個註釋的範圍
@Documented  // meta-annotation
@ConditionalOnProperty(
		name = PropertyConstant.PropertyKey.CONDITIONAL_KEY,  //
		havingValue = PropertyConstant.PropertyValue.CONDITIONAL_VALUE_A,  // 比對是否相同
		matchIfMissing = true  // else (default = false)
		)
public @interface ConditionalOnA {
	
	// name 和 value 不可同時使用

}
