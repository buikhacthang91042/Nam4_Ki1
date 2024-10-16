package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import iuh.fit.se.beans.xmlbased.Student;

public class Main {
	private static ApplicationContext context;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		context = new ClassPathXmlApplicationContext("beans.xml");
		Student st1 = context.getBean("student1",Student.class);
		System.out.println(st1);
		
		Student st2 = context.getBean("student2",Student.class);
		System.out.println(st2);
		
		Student st3 = context.getBean("student3",Student.class);
		System.out.println(st3);
	}
}
