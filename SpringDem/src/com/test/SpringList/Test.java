package com.test.SpringList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/test/SpringList/conf.xml");
		Jbea t=(Jbea) ctx.getBean("hos");
		System.out.println("Hospital name "+t.getName());
		System.out.println("Departments "+t.getDepartment());
		System.out.println(t.getDepartment().getClass());
	}

}
