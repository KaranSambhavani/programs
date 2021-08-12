package com.demo.spring.dao;

import java.util.List;

import com.demo.spring.entity.Emp;

public interface EmpDao {
 
	public String save(Emp e);
	public Emp findById(int id);
	public List<Emp> getAll();
	public String deleteById(int id);
	public String UpdateById(int id);
	
	
	
}
