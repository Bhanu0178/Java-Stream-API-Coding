package org.bhanu.streams;

public class Employee 
{
	private String name;
	private Integer age;
	private Double salary;
	private String gender;
	
	
	//constructor
	public Employee(String name, Integer age, Double salary, String gender) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.gender = gender;
	}
	
	//getters/setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	//toString()
	@Override
	public String toString() {
		return "Employee " + name + " [age=" + age + ", salary=" + salary + ", gender=" + gender + "]";
	}
}
