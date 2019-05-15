/** 
 * <pre>项目名称:dubbo-test-consumer 
 * 文件名称:UserTest.java 
 * 包名:com.jk.test 
 * 创建日期:2018年12月17日上午10:55:04 
 * Copyright (c) 2018, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.jk.text;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jk.service.UserService;

/** 
 * <pre>项目名称：dubbo-test-consumer    
 * 类名称：UserTest    
 * 类描述：    
 * 创建人：朱义龙
 * 创建时间：2018年12月17日 上午10:55:04    
 * 修改人：朱义龙    
 * 修改时间：2018年12月17日 上午10:55:04    
 * 修改备注：       
 * @version </pre>    
 */

public class UserTest {
  
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring-dubbo-consumer.xml");
		UserService uService = (UserService) ac.getBean("userService");
		String sayGoodBye = uService.hello("张三", 1);
		System.out.println(sayGoodBye);
		uService.sayHello("李四", "18");

	}
}
