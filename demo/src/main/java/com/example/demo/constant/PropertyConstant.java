package com.example.demo.constant;

public class PropertyConstant {
	
	public static class PropertyKey {
		public static final String CONDITIONAL_KEY = "conditional.test";  // final 值不會再更改
		
//		public static final String STORE_RXM_REDIS_TEST_ON_BORROW = "store.rxm.redis.testOnBorrow";
	}

	public static class PropertyValue {
		public static final String CONDITIONAL_VALUE_A = "AAA";
		public static final String CONDITIONAL_VALUE_B = "BBB";
		
//		public static final String STORE_RXM_REDIS_TEST_ON_BORROW = "${" + PropertyKey.STORE_RXM_REDIS_TEST_ON_BORROW + ":true}";
	}
}
