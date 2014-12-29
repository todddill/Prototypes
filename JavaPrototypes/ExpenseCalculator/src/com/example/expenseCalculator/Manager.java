package com.example.expenseCalculator;

import java.util.ArrayList;
import java.util.List;

public class Manager implements Employee, Organizational {

	private String title = "";
	private Double expenseAllocation = (double) 0;

	public String getTitle() {
		return title;
	}

	public void setTitle(String value) {
		title = value;
	}

	public double getExpenseAllocation() {
		return expenseAllocation;
	}

	public void setExpenseAllocation(double value) {
		expenseAllocation = value;
	}
	
	public Manager(String title, double expenseAllocation)
	{
		this.title = title;
		this.expenseAllocation = expenseAllocation;
	}
	
	private List<Employee> employees = new ArrayList<Employee>();

	public List<Employee> getEmployees() {
		return employees;
	}

	public double getTotalExpenses() {
		double expenses = 0;
		
		for(Employee employee : employees)
		{
			if (employee.getClass() ==  Manager.class)
				expenses += ((Manager)employee).getTotalExpenses();
			else
				expenses += employee.getExpenseAllocation();
		}
		
		return expenses + this.getExpenseAllocation();
	}
}
