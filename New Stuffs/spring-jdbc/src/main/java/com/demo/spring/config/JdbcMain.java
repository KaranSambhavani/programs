package com.demo.spring.config;


import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.demo.spring.dao.EmpDao;
import com.demo.spring.entity.Emp;

public class JdbcMain {

	public static void main(String[] args) {
		
		ApplicationContext ctx=new AnnotationConfigApplicationContext(JdbcConfig.class);
		
		EmpDao ob=(EmpDao) ctx.getBean("empDaoImpl");
		
		System.out.println(ob.save(new Emp(103,"Kp","Pune",60000)));
		
		List<Emp> l=ob.getAll();
		
		for(Emp e:l)
		{
			System.out.println(e);
		}
		
		System.out.println(ob.deleteById(100));
		
		Emp e=ob.findById(103);
		System.out.println(e);
		
		System.out.println(ob.UpdateById(102));
		
	}

}
