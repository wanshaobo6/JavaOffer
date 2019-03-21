package com.example2.p65_stackWithMin;

public class People implements Comparable{
	private String name;
	private int age;
	
	
	
	@Override
	public String toString() {
		return "People [name=" + name + ", age=" + age + "]";
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return this.age - ((People)o).age;
	}
}
