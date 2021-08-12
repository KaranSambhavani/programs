package com.demo.spring.entity;



public class Emp {

	private int empId;
	private String name;
	private String City;
	private double salary;
	
	public Emp() {
		super();
	}
	
	public Emp(int empId, String name, String city, double salary) {
		super();
		this.empId = empId;
		this.name = name;
		City = city;
		this.salary = salary;
	}



	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	@Override
	public boolean equals(Object obj) {
		Emp e=(Emp)obj;
		
		if(this.empId==e.empId)
		{
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		
		return this.empId;
	}

	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", name=" + name + ", City=" + City + ", salary=" + salary + "]";
	}
	

}
