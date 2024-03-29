package com.emsproject.entities;

public class Department {
	
	private int id;
	private String name;
	private int totalEmp;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTotalEmp() {
		return totalEmp;
	}
	public void updateTotalEmp(int totalEmp) {
		this.totalEmp = totalEmp;
	}

	
	
	

}
