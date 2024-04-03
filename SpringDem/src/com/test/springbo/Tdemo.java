package com.test.springbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tdemo {
		public static void main(String[] args) {
			ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/test/springbo/config.xml");
			Jbea jb=(Jbea) ctx.getBean("emp");
			System.out.println("Employee Id "+jb.getId());
			System.out.println("Employee name "+jb.getName());
			ctx.close();
	}

}
