package com.test.SpringAdv;

import org.springframework.beans.factory.annotation.RequiredAnnotationBeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Advt {

	public static void main(String[] args) {
		ApplicationContext apx=new ClassPathXmlApplicationContext("com/test/SpringAdv/conf.xml");
		Adv a=(Adv) apx.getBean("emp");
		System.out.println(a);
		 

	}

}
