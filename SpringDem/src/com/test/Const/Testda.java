package com.test.Const;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Testda {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/test/Const/confi.xml");
		Empd e=(Empd) ctx.getBean("emp");
		System.out.println(e);
//		Test t=(Test) ctx.getBean("address");
//		System.out.println(t);

	}

}
